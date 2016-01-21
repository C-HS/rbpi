/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midstrbpserver;

import com.pi4j.io.serial.Serial;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 *
 * @author habib
 */
public class MidstRBPServer {

    private static final int PORT = 3012;
    
    private final static Logger LOGGER = Logger.getLogger(MidstRBPServer.class.getName()); 
    static SerialCommReader scomr1=new SerialCommReader();
    static int clientConnected =0;
    public static void main(String args[]) throws Exception 
    { 

        System.out.println("The chat server is running.");
        ServerSocket serverSocket=null;
        try 
        {
//                 serverSocket = new ServerSocket(PORT);
                
                 
                 Serial serial=SerialCommReader.SerialCommReader();
                 System.out.println("chech 1:");
                 new CardReader(serial).start();
                 
                 new IPProviderThread().start();
            
            while (true) 
            {
                if(clientConnected==0)
                {
                    serverSocket = new ServerSocket(PORT);
                    System.out.println("The chat server");
                    Socket socket = serverSocket.accept();

                    BufferedReader in = new BufferedReader(new InputStreamReader( socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                    CardIDSender cis= new CardIDSender(out);
                    cis.start();
                    new Handler(in,out,cis).start();

                    LOGGER.info("main()---ClientAccepted");
                    System.out.println("ClientAccepted");
                    clientConnected=1;
                    serverSocket.close();
                   
                }
            }
        }
        catch(IOException e)
        {
            LOGGER.warning("main()---IOException");
            System.out.println("main()---IOException------"+e.getMessage());
        }
        catch(Exception e)
        {
            LOGGER.warning("main()---Exception");
            System.out.println("main()---Exception------"+e.getMessage());
        }
        finally 
        {
            LOGGER.info("main()---listener closed");
            if(serverSocket!=null)
            serverSocket.close();
        }
    }

    private static class Handler extends Thread {
        private final BufferedReader in;
        private final PrintWriter out;
        CardIDSender cis;

        public Handler(BufferedReader in,PrintWriter out,CardIDSender cis) {
            this.in = in;
            this.out = out;
            this.cis = cis;
        }
        @Override
        public void run() 
        {
            try 
            {
                out.println("yes");
                while(true) 
                {
                    System.out.println("MsgFromCLient ");
                    String input = in.readLine();
                    System.out.println("MsgFromCLient : "+input);
                    if("authenticated".equals(input))
                    {
                     new GPIOThread().start();  
                     out.println("yes");
                    }
                    if (input == null) 
                    {
                        return;
                    }
                }
            } 
            catch (IOException e) 
            {
                LOGGER.warning("Handler---IOException");
                System.out.println("IOException-----Handler-----"+e.getMessage());
            } 
            catch (Exception e) 
            {
                LOGGER.warning("Handler---Exception");
                System.out.println("Exception-----Handler--------"+e.getMessage());
            } 
            finally 
            {
               clientConnected=0;
                cis.runFlag=false;
            }
        }
    }
    

        private static class CardIDSender extends Thread {
        private final PrintWriter out;
        boolean runFlag=true;
        public CardIDSender(PrintWriter out) {
            this.out = out;
        }
        @Override
        public void run() 
        {
            try 
            {
               while(runFlag)
                {
                        try
                        {
                          System.out.print("rt "+scomr1.readTag);  
//                          Thread.sleep(2000);
                            Thread.sleep(1000);
                         }
                         catch(Exception e){}

                        if(!"na".equals(scomr1.cardId))
                        {
                         String data =scomr1.cardId;
                         out.println(data);
                         scomr1.setCardId("na");
                         scomr1.setReadTag(true);
                        }
                }
            } 
            catch (Exception e) 
            {
                LOGGER.warning("CardIDSender---Exception");
                System.out.println("Exception-----CardIDSender--------"+e.getMessage());
            }
            finally 
            {

            }
        }
    }
        
       private static class CardReader extends Thread {
        Serial serial;
        
        public CardReader(Serial serial) {
            this.serial = serial;
        }
        @Override
        public void run() 
        {
            try 
            {
                 scomr1.openSerialPort(serial);
                 scomr1.receiveSignal(serial);
                 scomr1.sendSerialData(serial);   
            }
            catch(InterruptedException e)
            {
             LOGGER.warning("CardReader---InterruptedException");
             System.out.println("InterruptedException---CardReader------"+e.getMessage());
            }
            catch (Exception e) 
            {
                LOGGER.warning("CardReader---Exception");
                System.out.println("Exception-----CardReader--------"+e.getMessage());
            }
            finally 
            {

            }
        }
    }
       
       private static class GPIOThread extends Thread {
        @Override
        public void run() 
        {
            try 
            {
                  System.out.println("call pinHigh");
                  scomr1.setGPIOPinHigh();
            }
            catch (Exception e) 
            {
                LOGGER.warning("GPIOThread---Exception");
                System.out.println("Exception-----GPIOThread--------"+e.getMessage());
            }
            finally 
            {

            }
        }
    }
       
       
     private static class IPProviderThread extends Thread {
       private static final int listenerPORT = 2535;
        @Override
        public void run() 
        {
            try 
            {
        System.out.println("The chat server is running.");
        ServerSocket listener=null;
        try 
        {
                 listener = new ServerSocket(listenerPORT);
            while (true) 
            {
                System.out.println("Start");
                
                Socket socket = listener.accept();
                
                BufferedReader in = new BufferedReader(new InputStreamReader( socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                
                try
                {
                 String input = in.readLine();
                 if("midst".equals(input))
                 {
                  out.println("yes");
                 }
                 in.close();
                 out.close();
                 socket.close();
                }
                catch(Exception e)
                {
                
                }
                System.out.println("ClientAccepted");
            }
        }
        catch(IOException e)
        {
            System.out.println("IPProviderThread---IOException------"+e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("IPProviderThread---Exception------"+e.getMessage());
        }
        finally 
        {
            if(listener!=null)
            listener.close();
        }
            }
            catch (Exception e) 
            {
                LOGGER.warning("IPProviderThread---Exception");
                System.out.println("Exception-----IPProviderThread--------"+e.getMessage());
            }
            finally 
            {

            }
        }
    }
       
}
