/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficlightsfin;

/**
 *
 * @author dylan
 */

public class StateMachine {
   public enum TrafficState
{
    GreenEastWestTraffic, AmberEastWestTraffic, GreenEastWestPedestrian, GreenNorthSouthTraffic, 
    AmberNorthSouthTraffic, GreenNorthSouthPedestrian
} 
   public enum TrafficLightsColor
{
    Red, Amber, Green
}
   TrafficPorts tp = new TrafficPorts();
   TrafficLightsColor tlc;
   TrafficState currentstate;
   TrafficState nextState;
   
   
   
   Timer timer = new Timer();
   
   public int reset = 0;
   
   
   public void SyncProcess()
   {
       while(true)
       {
           if(reset == 1)
           {
             currentstate = TrafficState.GreenEastWestTraffic; // 
           } 
           else 
           {
               timer.delayPeriod(); // call the method
               currentstate = nextState;
           }
          
       }          
                       
           
   }
   
   public void CombinProcess()
   {
       timer.clearCount(); // clear the counter
       nextState = currentstate.GreenEastWestTraffic;
       
       switch(currentstate) 
       {
           // case 1
           case GreenEastWestTraffic:
               nextState = currentstate.GreenEastWestTraffic;
               tp.set_East_West_high(tlc.Green);
               tp.set_North_South_low(tlc.Red);
               // this this meant to be low or high 
               // correct this if it incorrect
               // let me know
               
               // not sure about the if part here 
               // message me on slack
               // same goes for the other case options 
             
               
           case AmberEastWestTraffic:
               nextState = currentstate.AmberEastWestTraffic;
               tp.set_East_West_high(tlc.Amber);
               tp.set_North_South_high(tlc.Red);
               
           case GreenNorthSouthTraffic:
               nextState = currentstate.GreenNorthSouthTraffic;
               tp.set_East_West_high(tlc.Red);
               tp.set_North_North_high(tlc.Green);
               
         // amber north continue here 
                   
                   
              
                   
               
       
       
       }
   
   
   
   }
   
   
   
}
    