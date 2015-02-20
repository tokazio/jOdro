# jOdro
Java Library for controlling the GPIO Pins of the Odroid C1

I started writing this Library because I wasn't able to find a Java Library like Pi4j for the Odroid C1.
This Project is in development, when you have some ideas for changed or new features please contact me.

<b> How to install:</b> <br>
Download and add the jOdro.jar from the dist folder to your project.<br>
Run the following command on your Odroid to give the library the needed permissions: <br>
```sudo chmod 222 /sys/class/gpio/export /sys/class/gpio/unexport```

<b> What is supported:</b> <br>
At the moment you can set and read a pin.

<b> How to use jOdro:</b> <br>
```
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
```
This is a short example shows how to use jOdro. At first you have to define a GPIOPin, which represents the Pin in the software.
For this pin you have to define which hardware pin you want to select (e.g. OdroPin.GPIO_24), in which direction the pin should work (e.g. PinMode.OUT)
and maybe which should be the default value (e.g. PinState.LOW).

Than you can minpulate or read the Pin (see at the table below).

At the end of the programm you have to shutdown the pins. This resets the pins to default (low and input) and unexports it.

<b>For a full list of all Features see: [a Core Functions](core functions.md)s</b>
