package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Pig  extends Animal {

    public Pig()
    {

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
