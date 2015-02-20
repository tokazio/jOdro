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

    public GPIOPin(OdroPin pin, PinMode mode) {
        this(pin, mode, PinState.LOW);
    }

    public GPIOPin(OdroPin pin, PinMode mode, PinState state) {
        this.pin = pin;
        this.mode = mode;
        this.export();
        this.direction();
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
    * @return Reads the input of the pin
    */
    public PinState read() {
        this.readValue();
        return this.state;
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

    private void readValue() {
        String out = CmdExecutor.execute("cat /sys/class/gpio/gpio" + this.pin.getOdroidCode() + "/value ");
        System.out.println(out.split("\n")[0]);
        if (out.split("\n")[0].equals(PinState.HIGH.getCode())) {
            this.state = PinState.HIGH;
        } else {
            this.state = PinState.LOW;
        }
    }
}
