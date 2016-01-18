///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hellopi;
//
//import java.util.Date;
//
//import com.pi4j.io.serial.Serial;
//import com.pi4j.io.serial.SerialDataEvent;
//import com.pi4j.io.serial.SerialDataListener;
//import com.pi4j.io.serial.SerialFactory;
//import com.pi4j.io.serial.SerialPortException;
//import java.math.BigInteger;
//
///**
// * This example code demonstrates how to perform serial communications using the Raspberry Pi.
// * 
// * @author Robert Savage
// */
//public class UartTest {
//    
//    
//    
//    public static void main(String args[]) throws InterruptedException {
//        
//        // !! ATTENTION !!
//        // By default, the serial port is configured as a console port 
//        // for interacting with the Linux OS shell.  If you want to use 
//        // the serial port in a software program, you must disable the 
//        // OS from using this port.  Please see this blog article by  
//        // Clayton Smith for step-by-step instructions on how to disable 
//        // the OS console for this port:
//        // http://www.irrational.net/2012/04/19/using-the-raspberry-pis-serial-port/
//                
//        System.out.println("<--Pi4J--> Serial Communication Example ... started11111.");
//        System.out.println(" ... connect using settings: 115200, N, 8, 1.");
//        System.out.println(" ... data received on serial port should be displayed below.");
//        
//       
//        byte[] cmdb=new byte[] { (byte)186, (byte)2, (byte)49, (byte)137};
//        
//       
//        
//        //byte[] b=(byte)cmdar[0];
//        // create an instance of the serial communications class
//        final Serial serial = SerialFactory.createInstance();
//
//        // create and register the serial data listener
//        serial.addListener(new SerialDataListener() {
//            @Override
//            public void dataReceived(SerialDataEvent event) {
//                // print out the data received to the console
//               // String s = new String();
//                String s=toHexIDString(event.getData().getBytes());
//               
//                if(!s.equalsIgnoreCase("No Tag"))
//                System.out.print("CardID:: "+s);
//            }            
//        });
//            
//        
//        
//        try {
//            // open the default serial port provided on the GPIO header
//            serial.open("/dev/ttyAMA0", 115200);
//            System.out.println("SerialPort Opened");
//            
//            // continuous loop to keep the program running until the user terminates the program
//            while(true) {
//                try {
//                    
//                    serial.write(cmdb);
//                    
//                }
//                catch(IllegalStateException ex){
//                    ex.printStackTrace();                    
//                }
//                
//                // wait 1 second before continuing
//                Thread.sleep(100);
//             //   serial.close();
//              //  break;
//            }
//            
//        }
//        catch(SerialPortException ex) {
//            System.out.println(" ==>> SERIAL SETUP FAILED : " + ex.getMessage());
//            return;
//        }
//    }
//    
//    public static String toHexIDString(byte[] ba) {
//    StringBuilder str = new StringBuilder();
//    
//    for(int i = 0; i < ba.length; i++)
//    {
//        
//        str.append(String.format("%x", ba[i]));
//    }
//    
//    String strHex=str.toString();
//    
//    if(strHex.length() > 30 )
//    {
//        int indOfBD=strHex.indexOf("bd");
//        char c=strHex.charAt(indOfBD+5);
//        if(c=='0')
//        {
//            strHex=strHex.substring(strHex.indexOf("bd"), 32);
//            //exact possition of 8Byte ID
//            return strHex.substring(strHex.indexOf("bd")+6, 22);
//        }else if(c=='1'){
//            return "No Tag";
//        }
//         }
//
//    return "No Tag";
//}
//    
//}