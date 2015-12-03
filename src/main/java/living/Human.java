package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Human extends Living {

    private double sickRate = 0.1;

    public Human()
    {
        if (this.isSickChance < this.sickRate) {
            this.state = State.SICK;
            this.daysToWait = 3;
        }
        else
            this.state = State.HEALTHY;
        mortalityRate = 0.1;
    }

    public Human(State state)
    {
        this.state = state;
    }

    @Override
    public String toString() {
        if (this.state.equals(State.HEALTHY))
            return "Hman";
        else if (this.state.equals(State.DEAD))
            return "Hmnx";
        else
            return "Hmn"+daysToWait;
    }
}
