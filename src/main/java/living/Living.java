package living;

import enu.State;
import sicknesses.Sickness;

import java.util.Random;

/**
 * Created by renaud on 26/11/2015.
 */
public abstract class Living {

    protected State state;
    protected double isSickChance;
    protected double mortalityRate;
    protected Sickness [] sicknesses;

    protected int daysToWait = -1;

    public Living()
    {
        Random contagion = new Random();
        isSickChance = contagion.nextDouble();
    }

    public State getState()
    {
        return state;
    }

    public void becomeSick() {
        this.state = State.SICK;
        setDaysToWait(getActiveSickness().getIncubationTime());
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
                setDaysToWait(this.getActiveSickness().getContagionTime());
                break;
            case CONTAGIOUS:
                Random dieChanceRnd = new Random();
                double dieChance = dieChanceRnd.nextDouble();
                if (dieChance/getActiveSickness().getSeverity() < this.mortalityRate) {
                    this.state = State.DEAD;
                    setDaysToWait(-1);
                }
                else
                {
                    this.state = State.RECOVERING;
                    setDaysToWait(this.getActiveSickness().getRecoverTime());
                }
                break;
            case RECOVERING:
                state = State.HEALTHY;
                setDaysToWait(-1);
        }

    }


    public Sickness getActiveSickness()
    {
        for (Sickness s : sicknesses)
        {
            if (s.isActive())
                return s;
        }
        return null;
    }


    public String toString()
    {
        return "";
    }

}
