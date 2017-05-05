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
               tp.set_North_South_high(tlc.Red);
               if(timer.EmergencyTimeOut() == true)
               {
                   if((tp.isNorthEmeHigh()) || (tp.isSouthEmeHigh()== true))
                   {
                       nextState = currentstate.AmberEastWestTraffic;
                       timer.clearCount();
                   } 
               }
               else if (timer.StandardTimeOut() == true)
               {
                   if((tp.isNorthVehHigh() == true) || (tp.isSouthVehHigh() == true))
                   {
                       nextState = currentstate.AmberEastWestTraffic;
                       timer.clearCount();
                   } 
               }
               
               
           case AmberEastWestTraffic:
               nextState = currentstate.AmberEastWestTraffic;
               tp.set_East_West_high(tlc.Amber);
               tp.set_North_South_high(tlc.Red);
               if(timer.EmergencyTimeout() == true)
               {
                   if((tp.isEastEmeHigh() == true) || (tp.isWestEmeHigh() == true))
                   {
                       nextState = currentstate.GreenNorthSouthTraffic;
                       timer.clearCount();
                   }
                   else if(timer.StandardTimeout() == true)
                   {
                       if((tp.isEastVehHigh() == true) || (tp.isWestVehHigh() == true))
                       {
                          nextState = currentstate.GreenNorthSouthTraffic;
                          timer.clearCount();
                       }
                   }
               }
             
           case GreenNorthSouthTraffic:
               nextState = currentstate.GreenNorthSouthTraffic;
               tp.set_East_West_high(tlc.Red);
               tp.set_North_South_high(tlc.Green);
               if((tp.isEastEmeHigh() == true) || (tp.isWestEmeHigh() == true))
               {
                   nextState = currentstate.AmberNorthSouthTraffic;
                   timer.clearCount();
               }
               else if(timer.StandardTimeout() == true)
               {
                   if((tp.isEastVehHigh() == true) || (tp.isWestEmeHigh()) == true)
                   {
                       nextState = currentstate.AmberNorthSouthTraffic;
                       timer.clearCount(); 
                   }
               }
               
               
           case AmberNorthSouthTraffic:
               nextState = currentstate.GreenNorthSouthTraffic;
               tp.set_East_West_high(tlc.Red);
               tp.set_North_South(tlc.Amber);
               if((tp.isNorthEmeHigh() == true) || (tp.isSouthEmeHigh() == true))
               {
                   nextState = currentstate.AmberEastWestTraffic;
                   timer.clearCount();
               }
               else if(timer.StandardTimeout() == true)
                   if((tp.isNorthVehHigh() == true)||(tp.isNorthVehHigh() == true))
                   {
                       nextState = currentstate.AmberEastWestTraffic;
                       timer.clearCount();
                   }
                   
                   
              
                   
               
       
       
       }
   
   
   
   }
   
   
   
}
    