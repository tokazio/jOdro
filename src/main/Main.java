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
public class Main{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Tester t = new Tester();
        t.startTest();
    }
}
