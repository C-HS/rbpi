/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midstrbpserver;

/**
 *
 * @author habib
 */
import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.SerialPortException;
import java.math.BigInteger;
import java.util.logging.Logger;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
/**
 *
 * @author habib
 */

   public class SerialCommReader {
     
   private final static Logger LOGGER = Logger.getLogger(SerialCommReader.class.getName()); 
     byte[] cmdb=new byte[] { (byte)186, (byte)2, (byte)49, (byte)137};
     boolean readTag=true;
     
     String cardId="na";
     
     static GpioController gpio;
     static GpioPinDigitalOutput pin;
     
    public static Serial SerialCommReader() 
    {
        try
        {
            final Serial serial=SerialFactory.createInstance();
            LOGGER.info("SerialCommReader()--SerialPort Instance Created");
            gpio= GpioFactory.getInstance();
            pin= gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "PinLED", PinState.HIGH);
            pin.low();

            return serial;
        }
        catch(SerialPortException e)
        {
            LOGGER.warning("SerialCommReader()---SerialPortException");
            System.out.println("SerialPortException from SerialCommReader()------"+e.getMessage());
        }
        catch(Exception e)
        {
            LOGGER.warning("SerialCommReader()---IOException");
            System.out.println("Exception from SerialCommReader()------"+e.getMessage());
        }
        return null;
    }
    public void openSerialPort(Serial serial)
    {
        try
        {
            System.out.println("chech 33333333333333:");
            serial.open("/dev/ttyAMA0", 115200);
            System.out.println("SerialPort Opened");
            LOGGER.info("openSerialPort()--SerialPort Opened");
        }
        catch(SerialPortException e)
        {
            LOGGER.warning("openSerialPort()---SerialPortException");
            System.out.println("SerialPortException from openSerialPort()------"+e.getMessage());
        }
        catch(Exception e)
        {
        LOGGER.warning("openSerialPort()---Exception");
        System.out.println("Exception from openSerialPort()------"+e.getMessage());
        }
    }
    
    public void sendSerialData(Serial serial)
    {
        try
        {
            System.out.println("sendSerialData:");
              while(true) 
              {
                try 
                {
                    System.out.println("readTag:-----------------"+readTag);
                    if(readTag)
                    serial.write(cmdb);
                    
                try{
                   Thread.sleep(1000);
                   }catch(Exception e){}
                }
                catch(SerialPortException e)
                {
                    LOGGER.warning("sendSerialData()---SerialPortException");
                    System.out.println("SerialPortException from sendSerialData()------"+e.getMessage());
                }
                catch(IllegalStateException ex)
                {
                    LOGGER.warning("sendSerialData()---IllegalStateException");
                    System.out.println("IllegalStateException from sendSerialData()------"+ex.getMessage());                  
                }
                catch(Exception ex)
                {
                     LOGGER.warning("sendSerialData()---Exception");
                    System.out.println("Exception from sendSerialData()------"+ex.getMessage());                  
                }
                Thread.sleep(100);
            }
        }
        catch(Exception e)
        {
        LOGGER.warning("Exception sendSerialData()");    
        System.out.println("Exception sendSerialData()------"+e.getMessage()); 
        }
    }
    
    public void closeSerialPort(Serial serial)
    {
         try
         {
            serial.close();
            LOGGER.info("closeSerialPort()--SerialPort Closed");
            System.out.println("SerialPort Closed");
         }
         catch(Exception e)
         {
          LOGGER.warning("Exception closeSerialPort()");
          System.out.println("Exception closeSerialPort()------"+e.getMessage()); 
         }
    }
    
    public void receiveSignal(Serial serial) throws InterruptedException
    {
        // create and register the serial data listener
        System.out.println("receiveSignal:");
        serial.addListener(new SerialDataListener() 
        {
            @Override
            public void dataReceived(SerialDataEvent event) {
               String s=toHexIDString(event.getData().getBytes());
               
               System.out.print("Data Recieved "+s);
               
               if(s!=null && !"na".equals(s))
               {
                   System.out.print("CardID:: "+s);
                   setCardId(s);
                   setReadTag(false);
               }
            }            
        });
    }
    
        
    public static String toHexIDString(byte[] ba) 
    {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < ba.length; i++)
        {
            str.append(String.format("%x", ba[i]));
        }
        String strHex=str.toString();

        if(strHex.length() > 30 )
        {
            int indOfBD=strHex.indexOf("bd");
            char c=strHex.charAt(indOfBD+5);
            if(c=='0')
            {
                strHex=strHex.substring(strHex.indexOf("bd"), 32);
                //exact possition of 8Byte ID
                if(strHex.length() > 22)
                   return strHex.substring(strHex.indexOf("bd")+6, 22); 

            }
            else if(c=='1')
            {
                return "na";
            }
         }

        return "na";
   }
    
    synchronized public void setReadTag(boolean b)
    {
     readTag=b;
    }
    synchronized public void setCardId(String id)
    {
     cardId=id;
    }
    
    public void setGPIOPinHigh()
    {
      try
      {
            if(pin.isLow())
            {
                pin.high();
                LOGGER.info("Set Pin High");
                try
                {
                Thread.sleep(5000);
                }
                catch(Exception e)
                {
                LOGGER.warning("Exception in sleep");
                } 
                pin.low();
                LOGGER.info("Set Pin Low");
            }
        }
        catch(Exception e)
        {
        LOGGER.warning("Exception in Set Pin High");
        System.out.println("Exception--in--setGPIOPinHigh()--"+e.getMessage());
        } 
    }
    
}