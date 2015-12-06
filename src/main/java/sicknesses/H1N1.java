package sicknesses;

/**
 * Created by renaud on 03/12/2015.
 */
public class H1N1 extends Sickness {
    public H1N1()
    {
        this.incubationTime = 3;
        this.contagionTime = 4;
        this.recoverTime = 4;
        this.severity = 2;
        this.contagionRate = 0.2;
    }

    @Override
    public String toString() {
        return "H1N1{}";
    }
}
