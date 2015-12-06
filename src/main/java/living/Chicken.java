package living;

import enu.State;
import sicknesses.H5N1;

/**
 * Created by renaud on 26/11/2015.
 */
public class Chicken extends Flying {

    public Chicken()
    {
        sickness = new H5N1();
        if (this.isSickChance < this.sickRate) {
            this.state = State.SICK;
            this.daysToWait = sickness.getIncubationTime();
        }
        else
            this.state = State.HEALTHY;
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
