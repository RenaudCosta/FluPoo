package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Pig  extends Animal {

    public Pig()
    {
        this.state = State.HEALTHY;
    }

    public Pig(State state)
    {
        this.state = state;
    }

    public String toString()
    {
        return "Pigg";
    }


}
