package sicknesses;

/**
 * Created by renaud on 03/12/2015.
 */
public abstract class Sickness {

    protected int incubationTime;
    protected int contagionTime;
    protected int recoverTime;
    protected boolean active;
    protected double severity; // The random numbers chosen to decide whether Livings die or not get divided by this. (>=1)
    protected double contagionRate;

    public Sickness()
    {
        active = false;
    }

    public double getContagionRate()
    {
        return contagionRate;
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

    public void disable()
    {
        active = false;
    }

    public void enable()
    {
        active = true;
    }

    public boolean isActive()
    {
        return active;
    }

}
