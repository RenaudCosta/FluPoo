package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public abstract class Living {
    protected State state;
    protected int contagionRate;
    protected int mortalityRate;

    public Living()
    {

    }

    public State getState()
    {
        return state;
    }

}
