package game;

import enu.State;

/**
 * Created by renaud on 10/12/2015.
 */
public class Report {


    private Map map;
    private int day;
    private int nbHuman;
    private int nbPig;
    private int nbDuck;
    private int nbChicken;
    private int totalEntities;
    private int totalDead;

    private int h1n1Victims;
    private int h5n1Victims;

    public Report(Map map) {
        this.map = map;
        h1n1Victims = 0;
        h5n1Victims = 0;
        day = 1;
        nbHuman = 0;
        nbPig = 0;
        nbDuck = 0;
        nbChicken = 0;
        totalEntities = 0;
        totalDead = 0;
        for (Case[] cases : map.getCases()) {
            for (Case c : cases) {
                if (c.getEntity() != null) {
                    switch (c.getEntity().getClass().getSimpleName()) {
                        case "Human":
                            nbHuman++;
                            break;
                        case "Pig":
                            nbPig++;
                            break;
                        case "Duck":
                            nbDuck++;
                            break;
                        case "Chicken":
                            nbChicken++;
                            break;
                        default:
                            break;
                    }
                    totalEntities++;
                }
            }
        }
    }

    public void countStates()
    {
        h1n1Victims = 0;
        h5n1Victims = 0;
        totalDead = 0;
        for (Case[] cases : map.getCases()) {
            for (Case c : cases) {
                if (c.getEntity() != null) {
                    if (c.getEntity().getState().equals(State.DEAD)) {
                        totalDead++;
                    }
                    else if (c.getEntity().getState().equals(State.SICK) || c.getEntity().getState().equals(State.CONTAGIOUS))
                    {
                        if (c.getEntity().getActiveSickness().getClass().getSimpleName().equals("H1N1"))
                        {
                            h1n1Victims++;
                        }
                        else if (c.getEntity().getActiveSickness().getClass().getSimpleName().equals("H5N1"))
                        {
                            h5n1Victims++;
                        }
                    }
                }
            }
        }
    }


    public void disp()
    {
        System.out.println("-----");
        System.out.println("Day " + day + ": ");
        System.out.println(nbHuman + " Humans, " + nbPig + " Pigs, " + nbChicken + " Chicken, " + nbDuck + " Ducks.");
        System.out.println((totalEntities - totalDead) + " living entities");
        System.out.println(totalDead + " dead entities");
        System.out.println(h1n1Victims + " victimes d'H1N1, " + h5n1Victims + " victimes d'H5N1");
        System.out.println("-----");
        day++;
        countStates();
    }

}

