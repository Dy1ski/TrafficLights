
/**
 * Write a description of class TrafficController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TrafficController
{
    // instance variables - replace the example below with your own
    private TrafficState currentState;
    private TrafficState nextState;

    /**
     * Constructor for objects of class TrafficController
     */
    public TrafficController()
    {
        // initialise instance variables
        this.nextState=TrafficState.GreenEastWestTraffic;
        this.currentState=nextState;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public TrafficState getCurrentState()
    {
        // put your code here
        return this.currentState;
    }
    
    public void setNextState(TrafficState pNextState)
    {
        this.nextState=pNextState;
    }
    
    public void setCurrentState(){
        this.currentState=this.nextState;
    }
}
