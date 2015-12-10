package living;

import enu.State;

import java.util.Random;

/**
 * Created by renaud on 26/11/2015.
 */
public abstract class Animal extends Living {

    protected final static double sickRate = 0.3; // Chances of being sick upon startq

    public Animal()
    {
        this.mortalityRate = 0.4;
    }


    @Override
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
                else {
                    this.state = State.CONTAGIOUS;
                    setDaysToWait(this.getActiveSickness().getContagionTime());
                }
                break;
        }

    }

    public String toString()
    {
        return "";
    }

}
