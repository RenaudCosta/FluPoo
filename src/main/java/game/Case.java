package game;

import enu.Direction;
import living.Human;
import living.Living;

/**
 * Created by renaud on 26/11/2015.
 */
public class Case {
    private Living entity;
    private int x, y;

    public Case()
    {
        x = 0;
        y = 0;
        entity = null;
    }

    public Case(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Case{" +
                "entity=" + entity +
                '}';
    }

    public Case(int x, int y, Living living)
    {
        this.x = x;
        this.y = y;
        this.entity = living;
    }

    public Living getEntity()
    {
        return entity;
    }

    public Living getNeighbour(Map map, Direction dir)
    {
        Case[][] cases = map.getCases();
        switch (dir)
        {
            case NORTH:
                return (y-1)>=0 ? cases[x][y-1].getEntity() : entity; // RETOURNER L'ENTITE DE LA CASE AU DESSUS. SI ON SORT DE LA MAP, RETOURNER L'ENTITE PRESENTE SUR LA CASE COURANTE
            case SOUTH:
                return (y+1)<map.getHeight() ? cases[x][y+1].getEntity() : entity;
            case EAST:
                return (x+1) < map.getWidth() ? cases[x+1][y].getEntity() : entity;
            case WEST:
                return (x-1) >= 0 ? cases[x-1][y].getEntity() : entity;
            case NORTHEAST:
                return (x+1 < map.getWidth() && y-1>=0) ? cases[x+1][y-1].getEntity() : entity;
            case SOUTHEAST:
                return (x+1 < map.getWidth() && y+1 < map.getHeight()) ? cases[x+1][y+1].getEntity() : entity;
            case SOUTHWEST:
                return (x-1 >= 0 && y+1 < map.getHeight()) ? cases[x-1][y+1].getEntity() : entity;
            case NORTHWEST:
                return (x-1 >= 0 && y-1 >= 0) ? cases[x-1][y-1].getEntity() : entity;
            default:
                return null;
        }
    }

    public Case getNeighbourCase(Map map, Direction dir)
    {
        Case[][] cases = map.getCases();
        switch (dir)
        {
            case NORTH:
                return (y-1)>=0 ? cases[x][y-1] : this; // RETOURNER L'ENTITE DE LA CASE AU DESSUS. SI ON SORT DE LA MAP, RETOURNER L'ENTITE PRESENTE SUR LA CASE COURANTE
            case SOUTH:
                return (y+1)<map.getHeight() ? cases[x][y+1] : this;
            case EAST:
                return (x+1) < map.getWidth() ? cases[x+1][y] : this;
            case WEST:
                return (x-1) >= 0 ? cases[x-1][y] : this;
            case NORTHEAST:
                return (x+1 < map.getWidth() && y-1>=0) ? cases[x+1][y-1] : this;
            case SOUTHEAST:
                return (x+1 < map.getWidth() && y+1 < map.getHeight()) ? cases[x+1][y+1] : this;
            case SOUTHWEST:
                return (x-1 >= 0 && y+1 < map.getHeight()) ? cases[x-1][y+1] : this;
            case NORTHWEST:
                return (x-1 >= 0 && y-1 >= 0) ? cases[x-1][y-1] : this;
            default:
                return null;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setEntity(Living entity)
    {
        this.entity = entity;
    }

    public void swap(Case c)
    {
        Living thisEntity = this.entity;
        Living otherEntity = c.getEntity();
        c.setEntity(thisEntity);
        this.setEntity(otherEntity);

    }


}
