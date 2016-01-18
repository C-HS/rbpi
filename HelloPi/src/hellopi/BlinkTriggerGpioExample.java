// START SNIPPET: blink-trigger-gpio-snippet


/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  BlinkTriggerGpioExample.java  
 * 
 * This file is part of the Pi4J project. More information about 
 * this project can be found here:  http://www.pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2015 Pi4J
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */
package hellopi;


import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.io.gpio.trigger.GpioBlinkStateTrigger;
import com.pi4j.io.gpio.trigger.GpioBlinkStopStateTrigger;

/**
 * This example code demonstrates how to setup blinking triggers for GPIO pins on the Raspberry Pi.
 * 
 * @author Robert Savage
 */
public class BlinkTriggerGpioExample {
    
//    public static void main(String[] args) throws InterruptedException {
//        
//        System.out.println("<--Pi4J--> GPIO Blink Trigger Example ... started.");
//
//        // create gpio controller
//        final GpioController gpio = GpioFactory.getInstance();
//        //gpio.
//        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "PinLED", PinState.HIGH);
//        System.out.println("light is: ON");
//        
//        // wait 2 seconds
//        Thread.sleep(2000);
//        for(int i=0;i<100;i++)
//        {
//        // turn off GPIO 1
//        pin.low();
//        System.out.println("light is: OFF");
//        // wait 1 second
//        Thread.sleep(1000);
//        // turn on GPIO 1 for 1 second and then off
//        System.out.println("light is: ON for 1 second");
//        pin.pulse(1000, true);
//        }
//        // release the GPIO controller resources
//        gpio.shutdown();
//        
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
////        for (;;) {
////            Thread.sleep(500);
////        }
//        
//        // stop all GPIO activity/threads by shutting down the GPIO controller
//        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)
//        // gpio.shutdown();   <--- implement this method call if you wish to terminate the Pi4J GPIO controller        
//    }
}
// END SNIPPET: blink-trigger-gpio-snippet
