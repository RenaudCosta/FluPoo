package living;

import enu.State;
import sicknesses.H5N1;

/**
 * Created by renaud on 26/11/2015.
 */
public class Duck extends Flying {

    public Duck()
    {
        sickness = new H5N1();
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
