package game;

import enu.Direction;
import living.Chicken;
import living.Duck;
import living.Human;
import living.Pig;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by renaud on 01/12/2015.
 */



public class CaseTest {

    @Test
    public void testGetNeighbour() throws Exception {

        Map map = new Map(3,3,1,0,0,0);
        Human h = new Human();
        Pig p = new Pig();
        Chicken c = new Chicken();
        Duck d = new Duck();
        Human h2 = new Human();
        Duck d2 = new Duck();
        map.setCase(1,1,new Case(1,1,h));
        map.setCase(1,0,new Case(1,0,p)); //au dessus
        map.setCase(1,2,new Case(1,2,c)); // en dessous
        map.setCase(0,1,new Case(0,1,d)); // a gauche
        map.setCase(2,1,new Case(2,1,h2)); // a droite
        map.setCase(2, 2, new Case(2, 2, d2));
        assertEquals(map.getCases()[1][1].getNeighbour(map, Direction.NORTH), p);
        assertEquals(map.getCases()[1][1].getNeighbour(map, Direction.EAST),h2);
        assertEquals(map.getCases()[1][1].getNeighbour(map, Direction.SOUTH),c);
        assertEquals(map.getCases()[1][1].getNeighbour(map, Direction.WEST),d);

        assertEquals(map.getCases()[0][0].getNeighbour(map, Direction.NORTH),null);
        assertEquals(map.getCases()[0][0].getNeighbour(map,Direction.EAST),p);
        assertEquals(map.getCases()[0][0].getNeighbour(map,Direction.SOUTH),d);
        assertEquals(map.getCases()[0][0].getNeighbour(map,Direction.WEST),null);

        assertEquals(map.getCases()[2][2].getNeighbour(map, Direction.NORTH),h2);
        assertEquals(map.getCases()[2][2].getNeighbour(map,Direction.EAST),d2);
        assertEquals(map.getCases()[2][2].getNeighbour(map,Direction.SOUTH),d2);
        assertEquals(map.getCases()[2][2].getNeighbour(map,Direction.WEST),c);

        assertEquals(map.getCases()[2][0].getNeighbour(map, Direction.NORTH),null);
        assertEquals(map.getCases()[2][0].getNeighbour(map,Direction.EAST),null);
        assertEquals(map.getCases()[2][0].getNeighbour(map,Direction.SOUTH),h2);
        assertEquals(map.getCases()[2][0].getNeighbour(map,Direction.WEST),p);


        Human h10 = new Human();
        Pig p10 = new Pig();
        Case c1 = new Case(10,10,h10);
        Case c2 = new Case(10,11,p10);

        c1.swap(c2);

        assertEquals(c1.getEntity(),p10);
        assertEquals(c2.getEntity(),h10);

        c1.setEntity(null);

        c1.swap(c2);

        assertEquals(c1.getEntity(),h10);
        assertEquals(c2.getEntity(),null);

    }
}