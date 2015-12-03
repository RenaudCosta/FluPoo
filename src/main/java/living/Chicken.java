package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Chicken extends Flying {

    public Chicken()
    {

    }

    public Chicken(State state)
    {
        this.state = state;
    }

    public String toString()
    {
        if (this.state.equals(State.HEALTHY))
            return "Chck";
        else if (this.state.equals(State.DEAD))
            return "Chkx";
        else
            return "Chk"+daysToWait;
    }
}
