package living;

import enu.State;
import sicknesses.H5N1;

/**
 * Created by renaud on 26/11/2015.
 */
public class Pig  extends Animal {

    public Pig()
    {
        sickness = new H5N1();
        if (this.isSickChance < this.sickRate) {
            this.state = State.SICK;
            this.daysToWait = sickness.getIncubationTime();
        }
        else
            this.state = State.HEALTHY;
    }

    public Pig(State state)
    {
        this.state = state;
    }

    public String toString()
    {
        if (this.state.equals(State.HEALTHY))
            return "Pigg";
        else if (this.state.equals(State.DEAD))
            return "Pigx";
        else
            return "Pig"+daysToWait;
    }


}
