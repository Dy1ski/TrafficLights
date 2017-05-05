
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
    private int count;
    
    

    /**
     * Constructor for objects of class Timer
     */
    public Timer()
    {
        // initialise instance variables
        count = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public boolean StandardTimeOut()
    {
        // put your code here
        if (count >= 5000) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public boolean PedestrianTimeOut()
    {
        // put your code here
        if (count >= 3000) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public boolean EmergencyTimeOut()
    {
        // put your code here
        if (count >= 2000) {
            return true;
        }
        else{
            return false;
        }
        
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
    
    public void delayPeriod()
    {
       sleepMillisec(1);
       count++;
    }
    
    public void congestion()
    {
      count= count+200;  
    }
    
    public void clearCount()
    {
       count = 0; 
    }
    
}
