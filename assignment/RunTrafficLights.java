
/**
 * Write a description of class RunTrafficLights here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RunTrafficLights
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class RunTrafficLights
     */
    public RunTrafficLights()
    {
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void run()
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
                        if (T1.EmergencyTimeOut()&&(TP1.isEastEmeHigh()==false && TP1.isWestEmeHigh()==false)){
                            if(TP1.isNorthEmeHigh()==true || TP1.isSouthEmeHigh()==true){
                                System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberEastWestTraffic);
                            }
                        }
                        
                        if(T1.StandardTimeOut()){
                             if((TP1.isSouthVehHigh()==true|| TP1.isNorthVehHigh()==true)&&
                             (TP1.isWestEmeHigh()==false&&TP1.isEastEmeHigh()==false)){
                                 System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberEastWestTraffic);
                             
                             }
                        }
                    }
                    
                    
                    if(TC1.getCurrentState()==TrafficState.AmberEastWestTraffic){
                        TP1.set_North_South_Traffic_high(TrafficLightsColor.Amber);
                        TP1.set_East_West_Traffic_high(TrafficLightsColor.Amber);
                        if (T1.EmergencyTimeOut()){
                            if(TP1.isNorthEmeHigh()==true || TP1.isSouthEmeHigh()==true ||
                            TP1.isEastEmeHigh()==true || TP1.isWestEmeHigh()==true){
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
                        
                        if(T1.EmergencyTimeOut()&&(TP1.isNorthEmeHigh()==false && TP1.isSouthEmeHigh()==false)){
                            if(TP1.isEastEmeHigh()==true || TP1.isWestEmeHigh()==true){
                                System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberNorthSouthTraffic);
                            }
                        }
                        if(T1.StandardTimeOut()){
                             if((TP1.isEastVehHigh()==true || TP1.isWestVehHigh()==true)&&
                             (TP1.isNorthEmeHigh()==false&& TP1.isSouthEmeHigh()==false)){
                                 System.out.println(TC1.getCurrentState().toString());
                                 T1.clearCount();
                                 TC1.setNextState(TrafficState.AmberNorthSouthTraffic);
                             
                             }
                        }
                    }
                    
                    
                    if(TC1.getCurrentState()==TrafficState.AmberNorthSouthTraffic){
                        TP1.set_North_South_Traffic_high(TrafficLightsColor.Amber);
                        TP1.set_East_West_Traffic_high(TrafficLightsColor.Amber);
                        if(T1.EmergencyTimeOut()){
                            if(TP1.isEastEmeHigh()==true || TP1.isWestEmeHigh()==true ||
                            TP1.isNorthEmeHigh()==true || TP1.isSouthEmeHigh()==true){
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
    }
}
