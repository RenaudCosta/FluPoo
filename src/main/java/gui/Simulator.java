package gui;

import enu.Direction;
import enu.State;
import game.*;
import game.Map;
import living.*;

import java.util.*;
import java.awt.Color;

/**
 * A simple predator-prey simulator, based on a rectangular field containing
 * rabbits and foxes.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class Simulator {

    private final static Direction[] directions = {Direction.NORTH,Direction.WEST,Direction.SOUTH,Direction.EAST,Direction.NORTHWEST,Direction.NORTHEAST,Direction.SOUTHWEST,Direction.SOUTHEAST};
    private final static int DEFAULT_HUMANRATE = 5;
    private final static int DEFAULT_DUCKRATE = 1;
    private final static int DEFAULT_CHICKENRATE = 2;
    private final static int DEFAULT_PIGRATE = 3;

    private final static int DEFAULT_WIDTH = 200;
    private final static int DEFAULT_HEIGHT = 100;

    private Map map;
    private int step;
    private List<SimulatorView> views;

    private Case[][] cases;

    public Simulator() {
        this(DEFAULT_HEIGHT, DEFAULT_WIDTH);
    }

    public Simulator(int width, int height)
    {
        //Construire la map : Rates par defaut
        this(width, height, DEFAULT_HUMANRATE, DEFAULT_DUCKRATE, DEFAULT_CHICKENRATE, DEFAULT_PIGRATE);
    }

    public Simulator(int width, int height, int hr, int dr, int cr, int pr)
    {
        map = new Map(width, height, hr, dr, cr, pr);
        views = new ArrayList<>();
        SimulatorView view = new GridView(height, width);
        view.setColor(Human.class, Color.RED);
        view.setColor(Pig.class, Color.PINK);
        //view.setColor(Chicken.class, Color.YELLOW);
        view.setColor(Duck.class, Color.GREEN);
        views.add(view);

        view = new GraphView(500, 150, 500);
        view.setColor(Human.class, Color.RED);
        view.setColor(Pig.class, Color.PINK);
        //view.setColor(Chicken.class, Color.YELLOW);
        view.setColor(Duck.class, Color.GREEN);
        views.add(view);

        // Setup a valid starting point.
        reset();
    }

    public void simulate() {
        //int cpt = 0;
        while(!map.gameOver()){
            simulateOneStep();
            //cpt++;
        }
    }

    public void simulateOneStep() {
        step++;
        map.simulateOneStep();
        updateViews();
    }

    public void reset() {
        step = 0;
        for (SimulatorView view : views) {
            view.reset();
        }

        //populate();
        updateViews();
    }

    private void updateViews() {
        for (SimulatorView view : views) {
            view.showStatus(step, map);
        }
    }
}







