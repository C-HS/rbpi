<<<<<<< HEAD
///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package hellopi;
//import java.util.Date;
//
//import com.pi4j.io.serial.Serial;
//import com.pi4j.io.serial.SerialDataEvent;
//import com.pi4j.io.serial.SerialDataListener;
//import com.pi4j.io.serial.SerialFactory;
//import com.pi4j.io.serial.SerialPortException;
//import java.math.BigInteger;
///**
// *
// * @author user
// */
//public class SerialCommReader  {
//    
//   
//     byte[] cmdb=new byte[] { (byte)186, (byte)2, (byte)49, (byte)137};
//     boolean readTag=true;
//    public static Serial SerialCommReader() 
//    {
//        try{
//            System.out.println("chech 11111111:");
//        final Serial serial=SerialFactory.createInstance();
//        System.out.println("chech 22222222222:");
//        return serial;
//        }catch(Exception e){}
//        return null;
//    }
//    public void openSerialPort(Serial serial)
//    {
//        try{
//            System.out.println("chech 33333333333333:");
//            serial.open("/dev/ttyAMA0", 115200);
//            System.out.println("SerialPort Opened");
//        }catch(Exception e){}
//            
//    }
//    
//    public void sendSerialData(Serial serial)
//    {
//        try{
//              while(true) {
//                try {
//                    if(readTag)
//                    serial.write(cmdb);
//                  }
//                catch(IllegalStateException ex){
//                    ex.printStackTrace();                    
//                }
//                
//                // wait 1 second before continuing
//                Thread.sleep(100);
//             //   serial.close();
//              //  break;
//            }
//        }catch(Exception e){}
//    }
//    
//    public void closeSerialPort(Serial serial)
//    {
//         try{
//            serial.close();
//            System.out.println("SerialPort Closed");
//        }catch(Exception e){}
//    }
//    
//    public void receiveSignal(Serial serial) throws InterruptedException{
//            // create and register the serial data listener
//        serial.addListener(new SerialDataListener() {
//            @Override
//            public void dataReceived(SerialDataEvent event) {
//                // print out the data received to the console
//               // String s = new String();
//                String s=toHexIDString(event.getData().getBytes());
//               if(s!=null)
//               {
//                   readTag=false;
//               }
//               try{
//               Thread.sleep(10000);
//               readTag=true;
//               }catch(Exception e){}
//               
//                if(!s.equalsIgnoreCase("No Tag"))
//                System.out.print("CardID:: "+s);
//            }            
//        });
//    }
//    
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
//            if(strHex.length() > 22)
//               return strHex.substring(strHex.indexOf("bd")+6, 22); 
//            
//        }else if(c=='1'){
//            return "No Tag";
//        }
//         }
//
//    return "No Tag";
//}
//    
//    
//    public static void main(String[] args)
//    {
//        try{
//       // SerialCommReader scomr;
//        Serial serial=SerialCommReader.SerialCommReader();
//        SerialCommReader scomr1=new SerialCommReader();
//        System.out.println("chech 1:");
//        
//        scomr1.openSerialPort(serial);
//        scomr1.receiveSignal(serial);
//        scomr1.sendSerialData(serial);
//        }catch(Exception e){}
//    }
//    
//}
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellopi;
import java.util.Date;

import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialDataEvent;
import com.pi4j.io.serial.SerialDataListener;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.SerialPortException;
import java.math.BigInteger;
/**
 *
 * @author user
 */
public class SerialCommReader  {
    
   
     byte[] cmdb=new byte[] { (byte)186, (byte)2, (byte)49, (byte)137};
     boolean readTag=true;
    public static Serial SerialCommReader() 
    {
        try{
            System.out.println("chech 11111111:");
        final Serial serial=SerialFactory.createInstance();
        System.out.println("chech 22222222222:");
        return serial;
        }catch(Exception e){}
        return null;
    }
    public void openSerialPort(Serial serial)
    {
        try{
            System.out.println("chech 33333333333333:");
            serial.open("/dev/ttyAMA0", 115200);
            System.out.println("SerialPort Opened");
        }catch(Exception e){}
            
    }
    
    public void sendSerialData(Serial serial)
    {
        try{
              while(true) {
                try {
                    if(readTag)
                    serial.write(cmdb);
                  }
                catch(IllegalStateException ex){
                    ex.printStackTrace();                    
                }
                
                // wait 1 second before continuing
                Thread.sleep(100);
             //   serial.close();
              //  break;
            }
        }catch(Exception e){}
    }
    
    public void closeSerialPort(Serial serial)
    {
         try{
            serial.close();
            System.out.println("SerialPort Closed");
        }catch(Exception e){}
    }
    
    public void receiveSignal(Serial serial) throws InterruptedException{
            // create and register the serial data listener
        serial.addListener(new SerialDataListener() {
            @Override
            public void dataReceived(SerialDataEvent event) {
                // print out the data received to the console
               // String s = new String();
                String s=toHexIDString(event.getData().getBytes());
               if(s!=null)
               {
                   readTag=false;
               }
               try{
               Thread.sleep(10000);
               readTag=true;
               }catch(Exception e){}
               
                if(!s.equalsIgnoreCase("No Tag"))
                System.out.print("CardID:: "+s);
            }            
        });
    }
    
        
    public static String toHexIDString(byte[] ba) {
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
            
        }else if(c=='1'){
            return "No Tag";
        }
         }

    return "No Tag";
}
    
    
    public static void main(String[] args)
    {
        try{
       // SerialCommReader scomr;
        Serial serial=SerialCommReader.SerialCommReader();
        SerialCommReader scomr1=new SerialCommReader();
        System.out.println("chech 1:");
        
        scomr1.openSerialPort(serial);
        scomr1.receiveSignal(serial);
        scomr1.sendSerialData(serial);
        }catch(Exception e){}
    }
    
}
>>>>>>> 62409f0c6e1e06296ada39ca874cf7ed38bd9a98
