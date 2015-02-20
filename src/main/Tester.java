/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gpio.GPIOPin;
import gpio.OdroPin;
import gpio.PinMode;
import gpio.PinState;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michi
 */
public class Tester{
    
    
    private static final int delay = 500;
    
    GPIOPin led;
    GPIOPin in;
    
    public void startTest() {
        led = new GPIOPin(OdroPin.GPIO_24, PinMode.OUT, PinState.LOW);
        in = new GPIOPin(OdroPin.GPIO_23, PinMode.IN);
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            led.shutdown();
            in.shutdown();
        }));
        
        while(true){
            led.toggle();
            System.out.println(in.read());
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
