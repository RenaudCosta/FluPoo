package game;

import enu.State;
import gui.Simulator;
import living.Human;
import living.Living;
import living.Pig;

public class Main {

    public static void main(String[] args) {
        Simulator simulator = new Simulator(200, 200);
        simulator.simulate();
    }
}
