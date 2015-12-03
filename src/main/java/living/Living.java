package living;

import enu.State;

import java.util.Random;

/**
 * Created by renaud on 26/11/2015.
 */
public abstract class Living {

    protected State state;
    protected int contagionRate;
    protected double isSickChance;
    protected int mortalityRate;

    public Living() //TODO: Gerer les différentes maladies
    {
        Random contagion = new Random();
        isSickChance = contagion.nextDouble();
    }

    public State getState()
    {
        return state;
    }

    public String toString()
    {
        return "";
    }

}
