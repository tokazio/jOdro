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
public class GPIOPin {

    private OdroPin pin;
    private PinMode mode;
    private PinState state;
    
    private GPIOFileReader reader;

    public GPIOPin(OdroPin pin, PinMode mode) {
        this(pin, mode, PinState.LOW);
    }

    public GPIOPin(OdroPin pin, PinMode mode, PinState state) {
        this.pin = pin;
        this.mode = mode;
        this.reader = new GPIOFileReader(this);
        this.export();
        this.direction();
        this.listen();
    }

    /**
    * Add a listener to the pin. The Listeners are notified, when the state of the pin changed.
    * @param l The Listener for any Changes of the GPIO state.
    */
    public void addGPIOListener(GPIOListener l){
        this.reader.addListener(l);
    }
    
    /**
    * Set the state of the pin to low.
    */
    public void low() {
        this.state = PinState.LOW;
        this.value();
    }

    /**
    * Set the state of the pin to high.
    */
    public void high() {
        this.state = PinState.HIGH;
        this.value();
    }

    /**
    * Reverse the state of the pin.
    */
    public void toggle() {
        if (this.state == PinState.HIGH) {
            this.state = PinState.LOW;
        } else {
            this.state = PinState.HIGH;
        }
        this.value();
    }

    /**
    * Sets the properties back to the default values and unexports it. The mode of the Pin is set to input.
    * The state of the Pin is set to low. At the end its unexported.
    */
    public void shutdown() {
        this.state = PinState.LOW;
        this.mode = PinMode.IN;
        this.value();
        this.direction();
        this.unexport();
    }

    /**
    * @return Returns the Hardware Pin
    */
    public OdroPin getPin() {
        return this.pin;
    }

    /**
    * @return Returns the Mode of the GPIO Pin. In or Out
    */
    public PinMode getMode() {
        return this.mode;
    }

    /**
    * @return Returns the State of the GPIO Pin. High or Low
    */
    public PinState getState() {
        return this.state;
    }

    private void export() {
        String[] export = {"sudo", "/bin/sh", "-c", "echo " + this.pin.getOdroidCode() + " > /sys/class/gpio/export"};
        CmdExecutor.execute(export);
    }

    private void unexport() {
        String[] export = {"sudo", "/bin/sh", "-c", "echo " + this.pin.getOdroidCode() + " > /sys/class/gpio/unexport"};
        CmdExecutor.execute(export);
    }

    private void direction() {
        String[] directory = {"sudo", "/bin/sh", "-c", "echo " + this.mode.getCode() + " > /sys/class/gpio/gpio" + this.pin.getOdroidCode() + "/direction"};
        CmdExecutor.execute(directory);
    }

    private void value() {
        String[] high = {"sudo", "/bin/sh", "-c", "echo " + this.state.getCode() + " > /sys/class/gpio/gpio" + this.pin.getOdroidCode() + "/value"};
        CmdExecutor.execute(high);
    }

    private void listen() {
        this.reader.start();
    }
}
