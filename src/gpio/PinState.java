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
public enum PinState {
    /**
    * Value for a low-output
    */
    LOW("0", 0, "low"), 
    /**
    * Value for a low-output
    */
    HIGH("1", 1, "high");
    
    private final String code;
    private final int state;
    private final String label;
    
    private PinState(String code, int state, String label){
        this.code = code;
        this.state = state;
        this.label = label;
    }
    
    /**
    * @return This value is used to control the GPIOs.
    * 0 for low or a 1 for high.
    */
    public String getCode(){
        return this.code;
    }
    
    /**
    * @return Returns the state as a boolean value.
    * false for low or true for high.
    */
    public boolean toBool(){
        return this.state != 0;
    }
    
    /**
    * @return Returns the state as a int value.
    * 0 for low or a 1 for high.
    */
    public int toInt(){
        return this.state;
    }
    
    /**
    * @return Returns the state as a String value.
    * Low for low or a High for high.
    */
    @Override
    public String toString(){
        char first = Character.toUpperCase(this.label.charAt(0));
        String string = first + this.label.substring(1);
        return string;
    }
}
