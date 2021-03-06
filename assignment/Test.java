
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
        TrafficController TC1= new TrafficController();
        
        Thread syncThread = new Thread(new Runnable(){
            
            public void run(){
                while(true){
                    T1.delayPeriod();
                    TC1.setCurrentState();
                }
            }
        },"sync Thread");
        
        
        Thread combinationalThread = new Thread(new Runnable(){
            public void run(){
                while(true){
                    TP1.set_North_South_Traffic_low(TrafficLightsColor.Red);
                    TP1.set_North_South_Traffic_low(TrafficLightsColor.Amber);
                    TP1.set_North_South_Traffic_low(TrafficLightsColor.Green);
                    
                    TP1.set_East_West_Traffic_low(TrafficLightsColor.Red);
                    TP1.set_East_West_Traffic_low(TrafficLightsColor.Amber);
                    TP1.set_East_West_Traffic_low(TrafficLightsColor.Green);
                    
                    if(TC1.getCurrentState()==TrafficState.GreenEastWestTraffic){
                        TP1.set_North_South_Traffic_high(TrafficLightsColor.Red);
                        TP1.set_East_West_Traffic_high(TrafficLightsColor.Green);
                        if (T1.EmergencyTimeOut()){
                            if(TP1.isNorthEmeHigh()==true || TP1.isSouthEmeHigh()==true){
                                System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberEastWestTraffic);
                            }
                        }
                        
                        if(T1.StandardTimeOut()){
                             if(TP1.isSouthVehHigh()==true|| TP1.isNorthVehHigh()==true){
                                 System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberEastWestTraffic);
                             
                             }
                        }
                    }
                    
                    if(TC1.getCurrentState()==TrafficState.GreenEastWestPedestrian){
                        if(T1.PedestrianTimeOut()){
                             if(TP1.isSouthVehHigh()==true|| TP1.isNorthVehHigh()==true){
                                 System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberEastWestTraffic);
                             
                             }
                             else{
                                 System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.GreenEastWestTraffic);
                             }
                        }
                    }
                    
                    if(TC1.getCurrentState()==TrafficState.AmberEastWestTraffic){
                        TP1.set_North_South_Traffic_high(TrafficLightsColor.Amber);
                        TP1.set_East_West_Traffic_high(TrafficLightsColor.Amber);
                        if (T1.EmergencyTimeOut()){
                            if(TP1.isNorthEmeHigh()==true || TP1.isSouthEmeHigh()==true){
                                System.out.println(TC1.getCurrentState().toString());
                                T1.clearCount();
                                TC1.setNextState(TrafficState.GreenNorthSouthTraffic);
                            }
                        }
                        
                        if(T1.StandardTimeOut()){
                             System.out.println(TC1.getCurrentState().toString());
                             T1.clearCount();
                             TC1.setNextState(TrafficState.GreenNorthSouthTraffic);
                        }
                    }
                    
                    if(TC1.getCurrentState()==TrafficState.GreenNorthSouthTraffic){
                        TP1.set_North_South_Traffic_high(TrafficLightsColor.Green);
                        TP1.set_East_West_Traffic_high(TrafficLightsColor.Red);
                        
                        if(T1.EmergencyTimeOut()){
                            if(TP1.isEastEmeHigh()==true || TP1.isWestEmeHigh()==true){
                                System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberNorthSouthTraffic);
                            }
                        }
                        if(T1.StandardTimeOut()){
                             if(TP1.isEastVehHigh()==true || TP1.isWestVehHigh()==true){
                                 System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberNorthSouthTraffic);
                             
                             }
                        }
                    }
                    
                    if(TC1.getCurrentState()==TrafficState.GreenNorthSouthPedestrian){
                        if(T1.PedestrianTimeOut()){
                             if(TP1.isEastVehHigh()==true || TP1.isWestVehHigh()==true){
                                 System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberNorthSouthTraffic);
                             
                             }
                             else{
                                 System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.GreenNorthSouthTraffic);
                             }
                        }
                    }
                    
                    if(TC1.getCurrentState()==TrafficState.AmberNorthSouthTraffic){
                        TP1.set_North_South_Traffic_high(TrafficLightsColor.Amber);
                        TP1.set_East_West_Traffic_high(TrafficLightsColor.Amber);
                        if(T1.EmergencyTimeOut()){
                            if(TP1.isEastEmeHigh()==true || TP1.isWestEmeHigh()==true){
                                System.out.println(TC1.getCurrentState().toString());
                                T1.clearCount();
                                TC1.setNextState(TrafficState.GreenEastWestTraffic);
                            }
                        }
                        
                        if(T1.StandardTimeOut()){
                             System.out.println(TC1.getCurrentState().toString());
                             T1.clearCount();
                             TC1.setNextState(TrafficState.GreenEastWestTraffic);
                        }
                    }
                }
            }
        }, "combinational thread");
        
        
        
        combinationalThread.start();
        syncThread.start();
        //test.start();
        
        /*
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
        */
    }
    
}
