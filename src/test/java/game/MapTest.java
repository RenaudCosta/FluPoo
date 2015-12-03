package game;

import junit.framework.TestCase;

/**
 * Created by renaud on 03/12/2015.
 */
public class MapTest extends TestCase {

    public void testSimulateOneStep() throws Exception {

        Map map = new Map(3,3);
        System.out.println(map);
        map.simulateOneStep();
        System.out.println("\n------------------------------------\n");
        System.out.println(map);

    }
}