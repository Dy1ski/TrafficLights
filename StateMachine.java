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
   TrafficPorts tp = new TrafficPorts();
   TrafficLightsColor tlc = new TrafficLightsColor();
   TrafficState currentstate;
   TrafficState nextState;
   
   
   Timer timer = new Timer();
   
   public int reset = 0;
   
   
   public void SyncMachine()
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
   
   
   
}
    