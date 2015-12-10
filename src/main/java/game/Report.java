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

    public Report(Map map) {
        this.map = map;
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

    public void countDead()
    {
        totalDead = 0;
        for (Case[] cases : map.getCases()) {
            for (Case c : cases) {
                if (c.getEntity() != null) {
                    if (c.getEntity().getState().equals(State.DEAD)) {
                        totalDead++;
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
        System.out.println("-----");
        day++;
        countDead();
    }

}

