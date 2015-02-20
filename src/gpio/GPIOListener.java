/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpio;

/**
 *
 * @author Michi
 */
public interface GPIOListener {
    public void valueChanged(GPIOPin pin);
}
