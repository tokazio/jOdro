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
public enum OdroPin {
    /**
    * GPIO #74, Function: SDA1, No WiringPi
    */
    GPIO_00(74, "SDA1", -1),
    /**
    * GPIO #75, Function: SCL1, No WiringPi
    */
    GPIO_01(75, "SCL1", -1),
    /**
    * GPIO #83, No Funktion, WiringPi: 7
    */
    GPIO_02(83, "#83", 7),
    /**
    * GPIO #88, No Funktion, WiringPi: 0
    */
    GPIO_03(88, "#88", 0),
    /**
    * GPIO #88, No Funktion, WiringPi: 2
    */
    GPIO_04(116, "#116", 2),
    /**
    * GPIO #115, No Funktion, WiringPi: 3
    */
    GPIO_05(115, "#115", 3),
    /**
    * GPIO #107, Funktion: MOSI, WiringPi: 12
    */
    GPIO_06(107, "MOSI", 12),
    /**
    * GPIO #106, Funktion: MISO, WiringPi: 13
    */
    GPIO_07(106, "MISO", 13),
    /**
    * GPIO #105, Funktion: SCLK, WiringPi: 14
    */
    GPIO_08(105, "SCLK", 14),
    /**
    * GPIO #76, Funktion: SDA2, No WiringPi
    */
    GPIO_09(76, "SDA2", -1),
    /**
    * GPIO #101, No Funktion, WiringPi: 21
    */
    GPIO_10(101, "#101", 21),
    /**
    * GPIO #100, No Funktion, WiringPi: 22
    */
    GPIO_11(100, "#100", 22),
    /**
    * GPIO #108, No Funktion, WiringPi: 23
    */
    GPIO_12(108, "#108", 23),
    /**
    * GPIO #97, No Funktion, WiringPi: 24
    */
    GPIO_13(97, "#97", 24),
    /**
    * GPIO #113, Funktion: TXD1, No WiringPi
    */
    GPIO_14(113, "TXD1", -1),
    /**
    * GPIO #114, Funktion: RXD1, No WiringPi
    */
    GPIO_15(114, "RXD1", -1),
    /**
    * GPIO #87, No Funktion, WiringPi: 1
    */
    GPIO_16(87, "#87", 1),
    /**
    * GPIO #104, No Funktion, WiringPi: 4
    */
    GPIO_17(104, "#104", 4),
    /**
    * GPIO #102, No Funktion, WiringPi: 5
    */
    GPIO_18(102, "#102", 5),
    /**
    * GPIO #103, No Funktion, WiringPi: 6
    */
    GPIO_19(103, "#103", 6),
    /**
    * GPIO #117, No Funktion, WiringPi: 10
    */
    GPIO_20(117, "CE0", 10),
    /**
    * GPIO #118, No Funktion, WiringPi: 11
    */
    GPIO_21(118, "#118", 11),
    /**
    * GPIO #77, Funktion: SCL2, No WiringPi
    */
    GPIO_22(77, "SCL2", -1),
    /**
    * GPIO #99, No Funktion, WiringPi: 26
    */
    GPIO_23(99, "#99", 26),
    /**
    * GPIO #98, No Funktion, WiringPi: 27
    */
    GPIO_24(98, "#98", 27);
    
    private final int code;
    private final String label;
    private final int wiring;

    private OdroPin(int code, String label, int wiring){
        this.code = code;
        this.label = label;
        this.wiring = wiring;
    }
    
    /**
    * @return This value is used to control the GPIOs.
    */
    public int getOdroidCode(){
        return this.code;
    }
    
    /**
    * @return Returns the function of a pin. If there is no special funktion the
    * number of the pin in the format #[number] is returned.
    */
    public String getLabel(){
        return this.label;
    }
    
    /**
    * @return Returns the GPIO number in the WiringPi Protokol.
    */
    public int getWiringPin(){
        return this.wiring;
    }
}
