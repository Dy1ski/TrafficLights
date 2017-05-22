
/**
 * Write a description of class TrafficPorts here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.*;
import java.util.*;


public class TrafficPorts
{
    // instance variables - replace the example below with your own
     private static final Pin[] pinMap = new Pin[] {RaspiPin.GPIO_00, RaspiPin.GPIO_01, RaspiPin.GPIO_02, RaspiPin.GPIO_03, RaspiPin.GPIO_04, 
        RaspiPin.GPIO_05, RaspiPin.GPIO_06, RaspiPin.GPIO_07, RaspiPin.GPIO_08, RaspiPin.GPIO_09, RaspiPin.GPIO_10, 
        RaspiPin.GPIO_11, RaspiPin.GPIO_12, RaspiPin.GPIO_13, RaspiPin.GPIO_14, RaspiPin.GPIO_15, RaspiPin.GPIO_16, 
        RaspiPin.GPIO_17, RaspiPin.GPIO_18, RaspiPin.GPIO_19, RaspiPin.GPIO_20};
        
    
    private GpioController gpio;
    private GpioPinDigitalOutput North_South_Traffic [];
                                               
    private GpioPinDigitalOutput East_West_Traffic[];
                                               
    private GpioPinDigitalInput NorthVehBtn ;
    private GpioPinDigitalInput SouthVehBtn ;
    private GpioPinDigitalInput EastVehBtn ;
    private GpioPinDigitalInput WestVehBtn ;

    private GpioPinDigitalInput NorthEmeBtn ;
    private GpioPinDigitalInput SouthEmeBtn ;
    private GpioPinDigitalInput EastEmeBtn ;
    private GpioPinDigitalInput WestEmeBtn;
    
    /**
     * Constructor for objects of class TrafficPorts
     */
    public TrafficPorts()
    {
        // initialise instance variables
        //North_South_Traffic = new GpioPinDigitalOutput[3];
        //East_West_Traffic = new GpioPinDigitalOutput[3];
        gpio = GpioFactory.getInstance();
        
        North_South_Traffic = new GpioPinDigitalOutput[]{ gpio.provisionDigitalOutputPin(pinMap[0], PinState.LOW),
                                                 gpio.provisionDigitalOutputPin(pinMap[1], PinState.LOW),
                                                 gpio.provisionDigitalOutputPin(pinMap[2], PinState.LOW)};
        //gpio = GpioFactory.getInstance();
        East_West_Traffic = new GpioPinDigitalOutput[]{ gpio.provisionDigitalOutputPin(pinMap[3], PinState.LOW),
                                                 gpio.provisionDigitalOutputPin(pinMap[4], PinState.LOW),
                                                 gpio.provisionDigitalOutputPin(pinMap[5], PinState.LOW)};
                                               
        NorthVehBtn = gpio.provisionDigitalInputPin(pinMap[6], PinPullResistance.PULL_DOWN);
        SouthVehBtn = gpio.provisionDigitalInputPin(pinMap[7], PinPullResistance.PULL_DOWN);
        EastVehBtn = gpio.provisionDigitalInputPin(pinMap[15], PinPullResistance.PULL_DOWN);
        WestVehBtn = gpio.provisionDigitalInputPin(pinMap[10], PinPullResistance.PULL_DOWN);
        
        NorthEmeBtn = gpio.provisionDigitalInputPin(pinMap[11], PinPullResistance.PULL_DOWN);
        SouthEmeBtn = gpio.provisionDigitalInputPin(pinMap[12], PinPullResistance.PULL_DOWN);
        EastEmeBtn = gpio.provisionDigitalInputPin(pinMap[13], PinPullResistance.PULL_DOWN);
        WestEmeBtn = gpio.provisionDigitalInputPin(pinMap[14], PinPullResistance.PULL_DOWN);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void set_North_South_Traffic_high(TrafficLightsColor i)
    {
        // put your code here
        North_South_Traffic[i.ordinal()].high();
        
    }
    
    public void set_North_South_Traffic_low(TrafficLightsColor i)
    {
        // put your code here
        North_South_Traffic[i.ordinal()].low();
        
    }
    
    public void set_East_West_Traffic_high(TrafficLightsColor i)
    {
        // put your code here
        East_West_Traffic[i.ordinal()].high();
    }
    
    public void set_East_West_Traffic_low(TrafficLightsColor i)
    {
        // put your code here
        East_West_Traffic[i.ordinal()].low();
    }
    
    public boolean isNorthVehHigh()
    {
        // put your code here
        return NorthVehBtn.isHigh();
        
    }
    
    public boolean isSouthVehHigh()
    {
        // put your code here
        return SouthVehBtn.isHigh();
        
    }
    
    public boolean isEastVehHigh()
    {
        // put your code here
        return EastVehBtn.isHigh();
    }
    
    public boolean isWestVehHigh()
    {
        // put your code here
        return WestVehBtn.isHigh();
    }
    
    public boolean isNorthEmeHigh()
    {
        // put your code here
        return NorthEmeBtn.isHigh();
        
    }
    
    public boolean isSouthEmeHigh()
    {
        // put your code here
        return SouthEmeBtn.isHigh();
        
    }
    
    public boolean isEastEmeHigh()
    {
        // put your code here
        return EastEmeBtn.isHigh();
    }
    
    public boolean isWestEmeHigh()
    {
        // put your code here
        return WestEmeBtn.isHigh();
    }
    
    
}
