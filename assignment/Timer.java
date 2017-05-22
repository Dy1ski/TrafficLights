
/**
 * Write a description of class Timer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



import java.util.concurrent.atomic.AtomicInteger;

public class Timer 
{
    // instance variables - replace the example below with your own
    private AtomicInteger count;
    
    

    /**
     * Constructor for objects of class Timer
     */
    public Timer()
    {
        // initialise instance variables
        count = new AtomicInteger(0);
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
        if (this.count.get() >= 5000) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public  boolean PedestrianTimeOut()
    {
        // put your code here
        if (this.count.get() >= 3000) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public boolean EmergencyTimeOut()
    {
        // put your code here
        if (this.count.get() >= 1000) {
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
       this.count.incrementAndGet();
    }
    
    public void congestion()
    {
      this.count.addAndGet(200);  
    }
    
    public int getCount()
    {
      return this.count.get();    
    }
    
    public void clearCount()
    {
       this.count.set(0); 
    }
    
    
    
}
