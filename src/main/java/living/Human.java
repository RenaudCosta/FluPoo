package living;

import enu.State;
import sicknesses.H1N1;
import sicknesses.H5N1;
import sicknesses.Sickness;

import java.util.Random;

/**
 * Created by renaud on 26/11/2015.
 */
public class Human extends Living {

    private double sickRate = 0.1;

    public Human()
    {
        sicknesses = new Sickness[2];
        sicknesses[0] = new H1N1();
        sicknesses[1] = new H5N1();
        if (this.isSickChance < this.sickRate) {
            this.state = State.SICK;
            Random rnd = new Random();
            int sickness = rnd.nextInt(2);
            sicknesses[sickness].enable();
            this.daysToWait = getActiveSickness().getIncubationTime();
        }
        else
            this.state = State.HEALTHY;
        mortalityRate = 0.1;
    }


    @Override
    public String toString() {
        if (this.state.equals(State.HEALTHY))
            return "Hman";
        else if (this.state.equals(State.DEAD))
            return "HMNX";
        else
            return "Hmn"+daysToWait;
    }
}
