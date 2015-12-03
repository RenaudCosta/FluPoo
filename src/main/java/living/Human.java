package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Human extends Living {

    public Human()
    {
        this.state = State.HEALTHY;
    }

    public Human(State state)
    {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Human{}";
    }
}
