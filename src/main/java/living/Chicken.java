package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Chicken extends Flying {

    public Chicken()
    {
        this.state = State.HEALTHY;
    }

    public Chicken(State state)
    {
        this.state = state;
    }
}
