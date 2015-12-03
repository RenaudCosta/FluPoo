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
            this.daysToWait = sickness.getIncubationTime(); // TODO: fix sicknesses
        }
        else
            this.state = State.HEALTHY;
        this.mortalityRate = 0.4;
    }

    @Override
    public void changeState()
    {
        switch (state)
        {
            case SICK:
                state = State.CONTAGIOUS;
                setDaysToWait(this.getSickness().getContagionTime());
                break;
            case CONTAGIOUS:
                Random dieChanceRnd = new Random();
                double dieChance = dieChanceRnd.nextDouble();
                if (dieChance/sickness.getSeverity() < this.mortalityRate) {
                    this.state = State.DEAD;
                    setDaysToWait(-1);
                }
                else {
                    this.state = State.CONTAGIOUS;
                    setDaysToWait(this.getSickness().getContagionTime());
                }
                break;
        }

    }

    public String toString()
    {
        return "";
    }

}
