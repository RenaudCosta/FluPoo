package living;

import enu.State;

import java.util.Random;

/**
 * Created by renaud on 26/11/2015.
 */
public abstract class Animal extends Living {

    private final static double sickRate = 0.3; // between 0 and 1

    public Animal()
    {
        Random rnd = new Random();
        double sickChance = rnd.nextDouble();
        if (sickChance <= sickRate) this.state = State.SICK;
    }

    public String toString()
    {
        return "";
    }

}
