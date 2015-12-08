package game;

import enu.State;
import living.Human;
import living.Living;
import living.Pig;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Map map = new Map(10,10);

        while (!map.gameOver()) {
            map.simulateOneStep();
        }



    }



}
