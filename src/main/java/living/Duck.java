package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Duck extends Flying {

    public Duck()
    {
        this.state = State.HEALTHY;
    }

    public Duck(State state)
    {
        this.state = state;
    }

    public String toString()
    {
        return "Duck";
    }

}
