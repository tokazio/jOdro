<b>GPIOPin</b><br/>
The GPIOPin represents the hardware pin in the code.<br/>
```public GPIOPin(OdroPin pin, PinMode mode) //Constructor without default State (set to LOW)```<br/>
```public GPIOPin(OdroPin pin, PinMode mode, PinState state) //Constructor with default State```<br/><br/>
```public void low() //Sets the state of the pin to low```<br/>
```public void high() //Sets the state of the pin to high```<br/>
```public void toggle() //Reverses the state of the pin```<br/>
```public PinState read() //Reads the state of the pin```<br/>
```public void shutdown() //Shutsdown the pin (back to default and unexport)```<br/>
```public OdroPin getPin() //Returns the Constant for the pin```<br/>
```public PinMode getMode() //Returns the Mode of the pin```<br/>
<br/><br/>
<b>PinState</b><br/>
The PinState represents value of the pin in the code.<br/>
```PinState.LOW //Constant for a low value```<br/>
```PinState.HIGH //Constant for a high value```<br/><br/>
```public String getCode() //Returns the value which is used to control the GPIOs```<br/>
```public boolean toBool() //Returns the state state as a boolean```<br/>
```public int toInt() //Returns the state as a int```<br/>
```public String toString() //Returns the state as a String```<br/>
<br/><br/>
<b>PinMode</b><br/>
The PinState represents mode of the pin in the code.<br/>
```PinState.IN //Constant for a input```<br/>
```PinState.OUT //Constant for a output```<br/><br/>
```public String getCode() //Returns the value which is used to control the GPIOs```<br/>
```public boolean toBool() //Returns the mode state as a boolean```<br/>
```public int toInt() //Returns the mode as a int```<br/>
```public String toString() //Returns the mode as a String```<br/>
<br/><br/>
<b>OdroPin</b><br/>
The OdroPin represents the address of the pin in the code.<br/>
```public int getOdroidCode() //Returns the value which is used to control the GPIOs```<br/>
```public String getLabel //Returns the function of a pin. If there is no funktion the number.```<br/>
```public int getWiringPin() //Returns the GPIO number in the WiringPi Protokol```

<table>
  <tr>
    <th>OdroPin</th>
    <th>GPIO #</th>
    <th>Funktion</th>
    <th>WiringPi</th>
  </tr>
  <tr>
    <td>GPIO_00</td>
    <td>#74</td>
    <td>SDA1</td>
    <td>--</td>
  </tr>
  <tr>
    <td>GPIO_01</td>
    <td>#75</td>
    <td>SCL1</td>
    <td>--</td>
  </tr>
  <tr>
    <td>GPIO_02</td>
    <td>#83</td>
    <td>--</td>
    <td>7</td>
  </tr>
  <tr>
    <td>GPIO_03</td>
    <td>#88</td>
    <td>--</td>
    <td>0</td>
  </tr>
  <tr>
    <td>GPIO_04</td>
    <td>#116</td>
    <td>--</td>
    <td>2</td>
  </tr>
  <tr>
    <td>GPIO_05</td>
    <td>#115</td>
    <td>--</td>
    <td>3</td>
  </tr>
  <tr>
    <td>GPIO_06</td>
    <td>#107</td>
    <td>MOSI</td>
    <td>12</td>
  </tr>
  <tr>
    <td>GPIO_07</td>
    <td>#106</td>
    <td>MISO</td>
    <td>13</td>
  </tr>
  <tr>
    <td>GPIO_08</td>
    <td>#105</td>
    <td>SCLK</td>
    <td>14</td>
  </tr>
  <tr>
    <td>GPIO_09</td>
    <td>#76</td>
    <td>SDA2</td>
    <td>--</td>
  </tr>
  <tr>
    <td>GPIO_10</td>
    <td>#101</td>
    <td>--</td>
    <td>21</td>
  </tr>
  <tr>
    <td>GPIO_11</td>
    <td>#100</td>
    <td>--</td>
    <td>22</td>
  </tr>
  <tr>
    <td>GPIO_12</td>
    <td>#108</td>
    <td>--</td>
    <td>23</td>
  </tr>
  <tr>
    <td>GPIO_13</td>
    <td>#97</td>
    <td>--</td>
    <td>24</td>
  </tr>
  <tr>
    <td>GPIO_14</td>
    <td>#113</td>
    <td>TXD1</td>
    <td>--</td>
  </tr>
  <tr>
    <td>GPIO_15</td>
    <td>#114</td>
    <td>RXD1</td>
    <td>--</td>
  </tr>
  <tr>
    <td>GPIO_16</td>
    <td>#87</td>
    <td>--</td>
    <td>1</td>
  </tr>
  <tr>
    <td>GPIO_17</td>
    <td>#104</td>
    <td>--</td>
    <td>4</td>
  </tr>
  <tr>
    <td>GPIO_18</td>
    <td>#102</td>
    <td>--</td>
    <td>5</td>
  </tr>
  <tr>
    <td>GPIO_19</td>
    <td>#103</td>
    <td>--</td>
    <td>6</td>
  </tr>
  <tr>
    <td>GPIO_20</td>
    <td>#117</td>
    <td>CE0</td>
    <td>10</td>
  </tr>
  <tr>
    <td>GPIO_21</td>
    <td>#118</td>
    <td>--</td>
    <td>11</td>
  </tr>
  <tr>
    <td>GPIO_22</td>
    <td>#77</td>
    <td>SCL2</td>
    <td>--</td>
  </tr>
  <tr>
    <td>GPIO_23</td>
    <td>#99</td>
    <td>--</td>
    <td>26</td>
  </tr>
  <tr>
    <td>GPIO_24</td>
    <td>#98</td>
    <td>--</td>
    <td>27</td>
  </tr>
</table>
