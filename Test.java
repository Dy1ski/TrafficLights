
/**
 * Write a description of class Test here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Test
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Test
     */
    public Test()
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
    public void test()
    {
        // put your code here
        TrafficPorts TP1 = new TrafficPorts();
        Timer T1= new Timer();
        while(true){
           
           if(T1.StandardTimeOut()){
               if(TP1.isSouthVehHigh()){
                   System.out.println(" --> Time Out");
                   T1.clearCount();
                   System.out.println(" --> GPIO PIN STATE CHANGE: High");
                   TP1.set_North_South_high(TrafficLightsColor.Red);
               }
               
            }
            if(T1.EmergencyTimeOut()){
               if(TP1.isEastVehHigh()){
                   System.out.println(" --> Time Out");
                   T1.clearCount();
                   System.out.println(" --> GPIO PIN STATE CHANGE: Low");
                   TP1.set_North_South_low(TrafficLightsColor.Red);
               }    
            }
            T1.delayPeriod();
        }
    }
    
}
