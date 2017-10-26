/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.map;

import tag.map.Scenario;

/**
 *
 * @author emilv
 */
public class Room
{
    private String name;
    private String desc;
    private Scenario scen;
    private int id;
    private int x, y;
    private boolean north, east, south, west;

    public Room(String name, String desc, int id, int x, int y, boolean north, boolean east, boolean south, boolean west)
    {
        this.name = name;
        this.desc = desc;
        this.id = id;
        this.north = north;
        this.east = east;
        this.south = south;
        this.west = west;
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    /**
     * Checks if the player can access the a direction
     * @return 
     */
    public boolean isNorth()
    {
        return north;
    }

    public boolean isEast()
    {
        return east;
    }

    public boolean isSouth()
    {
        return south;
    }

    public boolean isWest()
    {
        return west;
    }
    
    @Override
    public String toString()
    {
        return name;
    }


    
}
