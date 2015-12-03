package living;

import enu.State;

/**
 * Created by renaud on 26/11/2015.
 */
public class Human extends Living {

    private double sickRate = 0.1;

    public Human()
    {
        if (this.isSickChance < this.sickRate)
            this.state = State.SICK;
        else
            this.state = State.HEALTHY;
    }

    public Human(State state)
    {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Hman";
    }
}
