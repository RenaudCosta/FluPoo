package game;

import enu.Direction;
import enu.State;
import living.*;

import java.util.Random;


/**
 * Created by renaud on 26/11/2015.
 */
public class Map {

    private final static State[] 

    private final static int DEFAULT_HUMANRATE = 5;
    private final static int DEFAULT_DUCKRATE = 1;
    private final static int DEFAULT_CHICKENRATE = 2;
    private final static int DEFAULT_PIGRATE = 3;

    private final static int DEFAULT_WIDTH = 200;
    private final static int DEFAULT_HEIGHT = 100;

    int width;
    int height;



    private Case[][] cases;

    public Map()
    {
        //Construire la map : valeurs par defaut
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Map(int width, int height)
    {
        //Construire la map : Rates par defaut
        this(width, height, DEFAULT_HUMANRATE, DEFAULT_DUCKRATE, DEFAULT_CHICKENRATE, DEFAULT_PIGRATE);
    }

    public Map(int width, int height, int hr, int dr, int cr, int pr)
    {
        this.width = width;
        this.height = height;
        //Construire la map.
        cases = new Case[width][height];
        for (int i = 0; i < width; i++)
        {
            for (int j = 0; j < height; j++)
            {
                int totalProportion = hr+dr+cr+pr;
                Living entity;
                Random rnd = new Random();
                int proportion = (rnd.nextInt(totalProportion)+1)*2;

                if (proportion > 0 && proportion <= hr)
                {
                    entity = new Human();
                }
                else if (proportion > hr && proportion <= (hr+dr))
                {
                    entity = new Duck();
                }
                else if (proportion > (hr+dr) && proportion <= (hr+dr+cr))
                {
                    entity = new Chicken();
                }
                else if (proportion > (hr+dr+cr) && proportion <= (hr+dr+cr+pr))
                {
                    entity = new Pig();
                }
                else
                {
                    entity = null;
                }

                cases[i][j] = new Case(i,j,entity);
            }
        }
    }


    public void simulateOneStep()
    {
        for (Case [] cArray : cases)
        {
            for (Case c : cArray)
            {
                if (c.getEntity() != null) {
                    for (Direction dir : Direction.values()) {
                        if ((c.getNeighbour(this, dir) != null) && (c.getNeighbour(this, dir).getState()).equals(State.CONTAGIOUS)) {
                            Random rndDir = new Random();
                            int intDir = rndDir.nextInt(9);


                            //NEIGHBOUR IS CONTAGIOUS -> PROBABILITY OF GETTING SICK
                            Random rnd = new Random();
                            double sickChance = rnd.nextDouble();
                        }
                        System.out.println("-");
                    }
                }
            }
        }

    }

    public Case[][] getCases()
    {
        return cases;
    }

    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }

    public void setCase(int x, int y, Case c)
    {
        cases[x][y] = c;
    }

    @Override
    public String toString() {
        String tab = "";
        for (int j = 0; j < height;j++)
        {
            for (int i = 0; i < width;i++)
            {
                tab += cases[i][j].toString();
            }
        }
        return tab;
    }
}
