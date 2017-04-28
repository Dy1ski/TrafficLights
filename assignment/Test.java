
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
            
           
           if(TP1.isSouthVehHigh()){
                System.out.println(" --> GPIO PIN STATE CHANGE: High");
                TP1.set_North_South_high(TrafficLightsColor.Red);
                
                T1.VehiclePedestrianDelay();
                
                TP1.set_North_South_low(TrafficLightsColor.Red);
                
                TP1.set_North_South_high(TrafficLightsColor.Amber);
                
                T1.VehiclePedestrianDelay();
                
                TP1.set_North_South_low(TrafficLightsColor.Amber);
                
                TP1.set_North_South_high(TrafficLightsColor.Green);
                
                T1.VehiclePedestrianDelay();
                
                TP1.set_North_South_low(TrafficLightsColor.Green);
            }
        }
    }
    
}
