package game;

/**
 * Created by renaud on 17/12/2015.
 */
public class Timer {

    private final static long DEFAULT_TIME = 1;

    private long time;

    public Timer(long time)
    {
        this.time = time;
    }

    public void sleep() throws InterruptedException
    {
        synchronized (this) {
            this.wait(time);
        }
    }
}
