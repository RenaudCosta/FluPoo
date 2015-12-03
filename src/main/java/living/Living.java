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
    protected double mortalityRate;

    protected int daysToWait = -1;

    public Living() //TODO: Gerer les différentes maladies
    {
        Random contagion = new Random();
        isSickChance = contagion.nextDouble();
    }

    public State getState()
    {
        return state;
    }

    public int getDaysToWait() { return daysToWait; }

    public void decrDaysToWait() { daysToWait--; }

    public void setDaysToWait(int days) {daysToWait = days;}

    public void changeState()
    {
        switch (state)
        {
            case SICK:
                state = State.CONTAGIOUS;
                setDaysToWait(4);
                break;
            case CONTAGIOUS:
                Random dieChanceRnd = new Random();
                double dieChance = dieChanceRnd.nextDouble();
                if (dieChance < this.mortalityRate)
                    this.state = State.DEAD;
                else
                    this.state = State.HEALTHY;
                setDaysToWait(-1);
        }

    }

    public String toString()
    {
        return "";
    }

}
