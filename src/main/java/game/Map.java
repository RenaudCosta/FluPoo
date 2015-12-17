package game;

import enu.Direction;
import enu.State;
import living.*;

import java.util.Random;


/**
 * Created by renaud on 26/11/2015.
 */
public class Map {

    //d�finition de la correspondance entre des nombres de 0 � 7 et les directions.
    private final static Direction[] directions = {Direction.NORTH,Direction.WEST,Direction.SOUTH,Direction.EAST,Direction.NORTHWEST,Direction.NORTHEAST,Direction.SOUTHWEST,Direction.SOUTHEAST};

    private final static int DEFAULT_HUMANRATE = 5;
    private final static int DEFAULT_DUCKRATE = 1;
    private final static int DEFAULT_CHICKENRATE = 2;
    private final static int DEFAULT_PIGRATE = 3;

    private final static int DEFAULT_WIDTH = 200;
    private final static int DEFAULT_HEIGHT = 100;

    private final static int DEFAULT_CONTAGION = 4;

    int width;
    int height;
    int contagion;



    private Case[][] cases;

    public Map()
    {
        //Construire la map : valeurs par defaut
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Map(int width, int height)
    {
        //Construire la map : Rates par defaut
        this(width, height, DEFAULT_HUMANRATE, DEFAULT_DUCKRATE, DEFAULT_CHICKENRATE, DEFAULT_PIGRATE,DEFAULT_CONTAGION);
    }

    public Map(int width, int height, int hr, int dr, int cr, int pr, int contagion)
    {
        this.width = width;
        this.height = height;
        this.contagion = contagion;
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
                if (c.getEntity() != null && !c.getEntity().getState().equals(State.DEAD)) {

                    //Mettre a jour l'etat des entit�s malades
                    c.updateState();

                    //NEIGHBOUR IS CONTAGIOUS -> PROBABILITY OF GETTING SICK
                    c.contagion(this);

                    //move the entity
                    c.move(this);
                }
            }
        }
        //System.out.println(this);
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
                if (cases[i][j].getEntity() != null) tab += cases[i][j].getEntity().toString()+" ";
                else tab+="null ";
            }
            tab += "\n";
        }
        return tab;
    }


    /*
    *
    *   Renvoie vrai si:
    *   - Que des null sur la map
    *   - Que des Living HEALTHY
    *   - Que des Living DEAD
    *
     */
    public boolean gameOver()
    {
        for (Case [] c1 : cases)
        {
            for (Case c : c1)
            {
                if (c.getEntity() != null && !c.getEntity().getState().equals(State.DEAD) && !c.getEntity().getState().equals(State.HEALTHY)) return false;
            }
        }
        return true;
    }

    public Object getObjectAt(int row, int col) {
        if(cases[row][col].getEntity() != null){
            return cases[row][col].getEntity();
        }
        else {
            return null;
        }
    }

    public int getContagion() {
        return contagion;
    }
}
