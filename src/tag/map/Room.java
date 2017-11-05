/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.map;

import java.util.ArrayList;
import tag.item.Item;


/**
 *
 * @author emilv
 */
public class Room
{

    private String name;
    private String desc;
    private int id;
    private int x, y;
    private boolean north, east, south, west;
    private ArrayList<Item> roomItems = new ArrayList();

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

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public String getDesc()
    {
        return desc;
    }

    
    
    public void addItemToRoom(Item item)
    {
        roomItems.add(item);
    }

    public void printRoomItems()
    {
        for (Item item : roomItems)
        {
            System.out.println(item.getName());
        }
    }

    /**
     * Checks if the player can access the a direction
     *
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

    public ArrayList<Item> getRoomItems()
    {
        return roomItems;
    }

    public void removeRoomItem(int n)
    {
        roomItems.remove(n);
    }

    public Item getRoomItem(int n)
    {
        return roomItems.get(n);
    }

    @Override
    public String toString()
    {
        return name;
    }

}
