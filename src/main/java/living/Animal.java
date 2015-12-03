package living;

import enu.State;

import java.util.Random;

/**
 * Created by renaud on 26/11/2015.
 */
public abstract class Animal extends Living {

    private final static double sickRate = 0.3; // between 0 and 1
    //TODO: Comparer isSickChance avec sickRate

    public Animal()
    {
        if (this.isSickChance < this.sickRate)
            this.state = State.SICK;
        else
            this.state = State.HEALTHY;
    }

    public String toString()
    {
        return "";
    }

}
