/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellopi;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

/**
 *
 * @author user
 */
public class HelloPi {

    /**
     * @param args the command line arguments
     */
<<<<<<< HEAD
    public static void main(String[] args) {
        try{
                // get a handle to the GPIO controller
             System.out.println("Raspberry Pi Led Example");
    	final GpioController gpio = GpioFactory.getInstance();
        
        // creating the pin with parameter PinState.HIGH
        // will instantly power up the pin
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "PinLED", PinState.HIGH);
       // final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "PinLED", PinState.HIGH);
        System.out.println("light is: ON");
        
        // wait 2 seconds
        Thread.sleep(2000);
        
        // turn off GPIO 1
        pin.low();
       /// pin1.low();
        System.out.println("light is: OFF");
        // wait 1 second
        Thread.sleep(1000);
        pin.high();
      //  pin1.high();
        // turn on GPIO 1 for 1 second and then off
        System.out.println("light is: ON for 1 second");
       // pin.pulse(1000, true);
        
        // release the GPIO controller resources
         // turn off GPIO 1
        pin.low();
      //  pin1.low();
        System.out.println("light is: OFF1");
        // wait 1 second
        Thread.sleep(1000);
        pin.high();
      //  pin1.high();
        // turn on GPIO 1 for 1 second and then off
        System.out.println("light is: ON for 1 second");
       // pin.pulse(1000, true);
        
        // release the GPIO controller resources
         // turn off GPIO 1
        pin.low();
       // pin1.low();
        System.out.println("light is: OFF");
        // wait 1 second
        Thread.sleep(1000);
        pin.high();
      //  pin1.high();
        // turn on GPIO 1 for 1 second and then off
        System.out.println("light is: ON for 1 second");
       // pin.pulse(1000, true);
        
        // release the GPIO controller resources
         // turn off GPIO 1
        pin.low();
      //  pin1.low();
        System.out.println("light is: OFF");
        // wait 1 second
        Thread.sleep(1000);
        pin.high();
     //   pin1.high();
        // turn on GPIO 1 for 1 second and then off
        System.out.println("light is: ON for 1 second");
       // pin.pulse(1000, true);
        
        // release the GPIO controller resources
         // turn off GPIO 1
        pin.low();
      //  pin1.low();
        System.out.println("light is: OFF");
        // wait 1 second
        Thread.sleep(1000);
        pin.high();
      //  pin1.high();
        // turn on GPIO 1 for 1 second and then off
        System.out.println("light is: ON for 1 second");
       // pin.pulse(1000, true);
        
        // release the GPIO controller resources
        gpio.shutdown();
        }catch(Exception e){}
        
//        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
//        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, 
//                                                  PinPullResistance.PULL_DOWN);
//        
//        System.out.println(" ... complete the GPIO #02 circuit and see the blink trigger take effect.");
//        
//        // setup gpio pins #04 an output pins and make sure they are all LOW at startup
//        final GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
//        
//        // create a gpio control trigger on the input pin ; when the input goes HIGH, turn on blinking
//        myButton.addTrigger(new GpioBlinkStateTrigger(PinState.HIGH, myLed, 250));
//
//        // create a gpio control trigger on the input pin ; when the input goes LOW, turn off blinking
//        myButton.addTrigger(new GpioBlinkStopStateTrigger(PinState.LOW, myLed));

        // keep program running until user aborts (CTRL-C)
  
        
    }
=======
//    public static void main(String[] args) {
//        try{
//                // get a handle to the GPIO controller
//             System.out.println("Raspberry Pi Led Example");
//    	final GpioController gpio = GpioFactory.getInstance();
//        
//        // creating the pin with parameter PinState.HIGH
//        // will instantly power up the pin
//        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "PinLED", PinState.HIGH);
//        final GpioPinDigitalOutput pin1 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "PinLED", PinState.HIGH);
//        System.out.println("light is: ON");
//        
//        // wait 2 seconds
//        Thread.sleep(2000);
//        
//        // turn off GPIO 1
//        pin.low();
//        pin1.low();
//        System.out.println("light is: OFF");
//        // wait 1 second
//        Thread.sleep(1000);
//        pin.high();
//        pin1.high();
//        // turn on GPIO 1 for 1 second and then off
//        System.out.println("light is: ON for 1 second");
//       // pin.pulse(1000, true);
//        
//        // release the GPIO controller resources
//         // turn off GPIO 1
//        pin.low();
//        pin1.low();
//        System.out.println("light is: OFF1");
//        // wait 1 second
//        Thread.sleep(1000);
//        pin.high();
//        pin1.high();
//        // turn on GPIO 1 for 1 second and then off
//        System.out.println("light is: ON for 1 second");
//       // pin.pulse(1000, true);
//        
//        // release the GPIO controller resources
//         // turn off GPIO 1
//        pin.low();
//        pin1.low();
//        System.out.println("light is: OFF");
//        // wait 1 second
//        Thread.sleep(1000);
//        pin.high();
//        pin1.high();
//        // turn on GPIO 1 for 1 second and then off
//        System.out.println("light is: ON for 1 second");
//       // pin.pulse(1000, true);
//        
//        // release the GPIO controller resources
//         // turn off GPIO 1
//        pin.low();
//        pin1.low();
//        System.out.println("light is: OFF");
//        // wait 1 second
//        Thread.sleep(1000);
//        pin.high();
//        pin1.high();
//        // turn on GPIO 1 for 1 second and then off
//        System.out.println("light is: ON for 1 second");
//       // pin.pulse(1000, true);
//        
//        // release the GPIO controller resources
//         // turn off GPIO 1
//        pin.low();
//        pin1.low();
//        System.out.println("light is: OFF");
//        // wait 1 second
//        Thread.sleep(1000);
//        pin.high();
//        pin1.high();
//        // turn on GPIO 1 for 1 second and then off
//        System.out.println("light is: ON for 1 second");
//       // pin.pulse(1000, true);
//        
//        // release the GPIO controller resources
//        gpio.shutdown();
//        }catch(Exception e){}
//        
////        // provision gpio pin #02 as an input pin with its internal pull down resistor enabled
////        final GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, 
////                                                  PinPullResistance.PULL_DOWN);
////        
////        System.out.println(" ... complete the GPIO #02 circuit and see the blink trigger take effect.");
////        
////        // setup gpio pins #04 an output pins and make sure they are all LOW at startup
////        final GpioPinDigitalOutput myLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
////        
////        // create a gpio control trigger on the input pin ; when the input goes HIGH, turn on blinking
////        myButton.addTrigger(new GpioBlinkStateTrigger(PinState.HIGH, myLed, 250));
////
////        // create a gpio control trigger on the input pin ; when the input goes LOW, turn off blinking
////        myButton.addTrigger(new GpioBlinkStopStateTrigger(PinState.LOW, myLed));
//
//        // keep program running until user aborts (CTRL-C)
//  
//        
//    }
>>>>>>> 62409f0c6e1e06296ada39ca874cf7ed38bd9a98
    
}
