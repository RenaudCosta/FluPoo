package living;

import enu.State;

import java.util.Random;

/**
 * Created by renaud on 26/11/2015.
 */
public abstract class Animal extends Living {

    protected final static double sickRate = 0.3; // Chances of being sick upon start

    public Animal()
    {
        if (this.isSickChance < this.sickRate) {
            this.state = State.SICK;
            this.daysToWait = 3;
        }
        else
            this.state = State.HEALTHY;
        this.mortalityRate = 0.4;
    }

    public String toString()
    {
        return "";
    }

}
