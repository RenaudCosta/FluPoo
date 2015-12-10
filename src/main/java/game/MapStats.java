package game;

import enu.State;
import gui.Counter;
import living.Living;

import java.util.HashMap;

/**
 * Created by Kevin on 10/12/2015.
 */
public class MapStats {

    private HashMap<Class, Counter> counters;
    private boolean countsValid;

    public MapStats(){
        counters = new HashMap<>();
        countsValid = false;
    }

    public String getPopulationDetails(Map map) {
        StringBuffer buffer = new StringBuffer();
        if (!countsValid) {
            generateCounts(map);
        }
        for (Class key : counters.keySet()) {
            Counter info = counters.get(key);
            buffer.append(info.getName());
            buffer.append(": ");
            buffer.append(info.getCount());
            buffer.append(' ');
        }
        return buffer.toString();
    }

    public int getPopulationCount(Map map, Class key) {
        if (!countsValid) {
            generateCounts(map);
        }

        Counter counter = counters.get(key);
        return counter.getCount();
    }

    public void reset() {
        countsValid = false;
        for (Class key : counters.keySet()) {
            Counter count = counters.get(key);
            count.reset();
        }
    }

    public void incrementCount(Class animalClass) {
        Counter count = counters.get(animalClass);
        if (count == null) {
            // We do not have a counter for this species yet.
            // Create one.
            count = new Counter(animalClass.getName());
            counters.put(animalClass, count);
        }
        count.increment();
    }

    public void countFinished() {
        countsValid = true;
    }

    private void generateCounts(Map map) {
        reset();
        for (int row = 0; row < map.getHeight(); row++) {
            for (int col = 0; col < map.getWidth(); col++) {
                Living animal = (Living) map.getObjectAt(row, col);
                if (animal != null) {
                    if(!animal.getState().equals(State.DEAD))
                        incrementCount(animal.getClass());
                }
            }
        }
        countsValid = true;
    }
    /*public int getPopulationCount(Field field, Class key) {
        if (!countsValid) {
            generateCounts(field);
        }

        Counter counter = counters.get(key);
        return counter.getCount();
    }*/
}
