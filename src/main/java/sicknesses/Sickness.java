package sicknesses;

/**
 * Created by renaud on 03/12/2015.
 */
public abstract class Sickness {

    protected int incubationTime;
    protected int contagionTime;
    protected int recoverTime;
    protected double severity; // The random numbers chosen to decide whether Livings die or not get divided by this. (>=1)

    public Sickness()
    {

    }

    public int getIncubationTime() {
        return incubationTime;
    }

    public int getContagionTime() {
        return contagionTime;
    }

    public int getRecoverTime() {
        return recoverTime;
    }

    public double getSeverity()
    {
        return severity;
    }

}
