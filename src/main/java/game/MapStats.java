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
    private boolean alreadyInitialize = false;
    private int nbChicken;
    private int nbHuman;
    private int nbPig;
    private int nbDucks;

    public MapStats(){
        counters = new HashMap<>();
    }

    /*public String getPopulationDetails(Map map) {
        StringBuffer buffer = new StringBuffer();
        //if (!countsValid) {
            generateCounts(map);
        //}
        for (Class key : counters.keySet()) {
            Counter info = counters.get(key);
            buffer.append(info.getName());
            buffer.append(": ");
            buffer.append(info.getCount());
            buffer.append(' ');
        }
        return buffer.toString();
    }*/

    /*public int getPopulationCount(Map map, Class key) {
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
    }*/

    /*public void decrementCount(Class animalClass) {
        Counter count = counters.get(animalClass);
        if (count == null) {
            // We do not have a counter for this species yet.
            // Create one.
            count = new Counter(animalClass.getName());
            counters.put(animalClass, count);
        }
        count.decrement();
    }*/


    /*private void generateCounts(Map map) {
        reset();
        for (int row = 0; row < map.getHeight(); row++) {
            for (int col = 0; col < map.getWidth(); col++) {
                Living animal = (Living) map.getObjectAt(row, col);
                if (animal != null) {
                    if(animal.getState().equals(State.DEAD))
                        decrementCount(animal.getClass());
                }
            }
        }
        countsValid = true;
    }*/
    /*public int getPopulationCount(Field field, Class key) {
        if (!countsValid) {
            generateCounts(field);
        }

        Counter counter = counters.get(key);
        return counter.getCount();
    }*/
    public void initialize(Map map){
        nbChicken = 0;
        nbDucks = 0;
        nbHuman = 0;
        nbPig = 0;
        for (int i = 0; i < map.getWidth(); ++i) {
            for (int j = 0; j < map.getHeight(); ++j) {
                Living animal = (Living) map.getObjectAt(j, i);
                if (animal != null) {
                    if (animal.toString().equals("Chicken"))
                        ++nbChicken;
                    else if (animal.toString().equals("Duck"))
                        ++nbDucks;
                    else if (animal.toString().equals("Human"))
                        ++nbHuman;
                    else if (animal.toString().equals("Pig"))
                        ++nbPig;
                }
            }
        }
    }

    public void generateCount(Map map){
        for(int i = 0; i < map.getWidth(); ++i) {
            for (int j = 0; j < map.getHeight(); ++j) {
                Living animal = (Living) map.getObjectAt(j, i);
                if(animal != null) {
                    if (animal.toString().equals("Chicken")) {
                        if (animal.getState().equals(State.DEAD))
                            --nbChicken;
                    } else if (animal.toString().equals("Duck")) {
                        if (animal.getState().equals(State.DEAD))
                            --nbDucks;
                    } else if (animal.toString().equals("Human")) {
                        if (animal.getState().equals(State.DEAD))
                            --nbHuman;
                    } else if (animal.toString().equals("Pig")) {
                        if (animal.getState().equals(State.DEAD))
                            --nbPig;
                    }
                }
            }
        }
    }

    public String getLivingDetails(Map map){
        StringBuffer buffer = new StringBuffer();
        generateCount(map);
        buffer.append("Chicken : ");
        buffer.append(nbChicken);
        buffer.append(" Pig :");
        buffer.append(nbPig);
        buffer.append(" Ducks :");
        buffer.append(nbDucks);
        buffer.append(" Human :");
        buffer.append(nbHuman);
        return buffer.toString();
    }

    public int getNbChicken(){
        return nbChicken;
    }

    public int getNbHuman(){
        return nbHuman;
    }

    public int getNbPig(){
        return nbPig;
    }

    public int getNbDucks(){
        return nbDucks;
    }


}
