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
        if (this.isSickChance < this.sickRate) {
            this.state = State.SICK;
            this.daysToWait = sickness.getIncubationTime();
        }
        else
            this.state = State.HEALTHY;
    }

    public Duck(State state)
    {
        sickness = new H5N1();
        this.state = state;
        daysToWait = sickness.getIncubationTime();
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
