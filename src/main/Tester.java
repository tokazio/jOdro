/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gpio.GPIOListener;
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
public class Tester implements GPIOListener{
    
    
    private static int delay = 500;
    
    static GPIOPin led;
    
    public void startTest() {
        led = new GPIOPin(OdroPin.GPIO_24, PinMode.OUT, PinState.LOW);
        led.addGPIOListener(this);
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            led.shutdown();
        }));
        
        while(true){
            led.toggle();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void valueChanged(GPIOPin pin) {
        System.out.println("Changed Value of "+pin.getPin().name()+" to: "+pin.getState().toString());
    }
}
