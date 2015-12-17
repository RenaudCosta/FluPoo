package game;

import junit.framework.TestCase;

/**
 * Created by renaud on 17/12/2015.
 */
public class TimerTest extends TestCase {

    public void testSleep() throws Exception {

        Timer timer = new Timer(500);

        for (int i = 0; i < 10; i++)
        {
            System.out.println(i);
            timer.sleep();
        }

    }
}