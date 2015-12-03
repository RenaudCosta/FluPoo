package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Duck extends Flying {

    public Duck()
    {

    }

    public Duck(State state)
    {
        this.state = state;
    }

    public String toString()
    {
        if (this.state.equals(State.HEALTHY))
            return "Duck";
        else if (this.state.equals(State.DEAD))
            return "Dckx";
        else
            return "Dck"+daysToWait;
    }

}
