package enu;

/**
 * Created by renaud on 26/11/2015.
 */
public enum State {

    HEALTHY("healthy"), SICK("sick"), CONTAGIOUS("contagious"), RECOVERING("recovering"), DEAD("dead");

    private String state;

    State(String state)
    {
        this.state = state;
    }

    public String toString()
    {
        return state;
    }

}
