
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


import java.util.*;

public class Timer
{
    // instance variables - replace the example below with your own
    private int x;
    
    

    /**
     * Constructor for objects of class Timer
     */
    public Timer()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void VehiclePedestrianDelay()
    {
        // put your code here
        sleepMillisec(5000);
        
    }
    
    public void EmergencyDelay()
    {
        // put your code here
        sleepMillisec(2000);
        
    }
    
    private void sleepMillisec(int millisec)
    {
        try
        {
            Thread.sleep(millisec);
        }
        catch ( InterruptedException e)
        {
        }
    }
    
    
}
