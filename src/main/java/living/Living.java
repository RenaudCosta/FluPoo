package living;

import enu.State;

import java.util.Random;

/**
 * Created by renaud on 26/11/2015.
 */
public abstract class Living {

    protected State state;
    protected double contagionRate;
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

    public double getContagionRate()
    {
        return contagionRate;
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
                    this.state = State.RECOVERING;
                setDaysToWait(3);
                break;
            case RECOVERING:
                state = State.HEALTHY;
                setDaysToWait(-1);
        }

    }

    public String toString()
    {
        return "";
    }

}
