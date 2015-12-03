package enu;

/**
 * Created by renaud on 28/11/2015.
 */
public enum Direction {
    NORTH("N"),SOUTH("S"),EAST("E"),WEST("W"),NORTHEAST("NE"),SOUTHEAST("SE"),SOUTHWEST("SW"),NORTHWEST("NW");
    String direction;

    Direction(String dir)
    {
        this.direction = dir;
    }
}
