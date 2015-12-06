package living;

import enu.State;
import sicknesses.H1N1;

/**
 * Created by renaud on 26/11/2015.
 */
public class Human extends Living {

    private double sickRate = 0.1;

    public Human()
    {
        sickness = new H1N1();
        if (this.isSickChance < this.sickRate) {
            this.state = State.SICK;
            this.daysToWait = sickness.getIncubationTime();
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
