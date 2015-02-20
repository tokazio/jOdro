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
public enum PinMode {
    /**
    * Constant for Input
    */
    IN("in", 0, "input"), 
    /**
    * Constant for Output
    */
    OUT("out", 1, "output");
    
    private final String code;
    private final int state;
    private final String label;
    
    private PinMode(String code, int state, String label){
        this.code = code;
        this.state = state;
        this.label = label;
    }
    
    /**
    * @return This value is used to control the GPIOs.
    * out for out or in for in.
    */
    public String getCode(){
        return this.code;
    }
    
    /**
    * @return Returns the mode as a int value.
    * 0 for In or a 1 for Out.
    */
    public int toInt(){
        return this.state;
    }
    
    /**
    * @return Returns the mode as a String value.
    * Output for out or a Input for input.
    */
    @Override
    public String toString(){
        char first = Character.toUpperCase(this.label.charAt(0));
        String string = first + this.label.substring(1);
        return string;
    }
}
