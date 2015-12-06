package game;

import enu.State;
import living.Human;
import living.Pig;

public class Main {

    public static void main(String[] args) {
	// write your code here


        Map map = new Map(2,2);
        for (Case [] cases : map.getCases())
        {
            for (Case c : cases)
            {
                c.setEntity(null);
            }
        }
        map.setCase(0,0,new Case(0,0,new Human()));
        map.setCase(0,1,new Case(0,1,new Pig(State.SICK)));
        while (!map.gameOver()) {
            map.simulateOneStep();
        }



    }



}
