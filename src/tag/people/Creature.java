/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.people;

import java.util.ArrayList;
import tag.item.Item;
import tag.map.Map;
import tag.map.Room;


/**
 *
 * @author adams
 */
public abstract class Creature
{
    protected Room curRoom;
    protected Map gameMap;
    protected String name;
    protected ArrayList<Item> inventory = new ArrayList();

    public Creature(Map gameMap, Room curRoom)
    {
        this.gameMap = gameMap;
        this.curRoom = curRoom;
    }

    public String getName()
    {
        return name;
    }

  
    
    
    
    

    public abstract void takeTurn();
    
    protected void setCurRoom(Room curRoom)
    {
        this.curRoom = curRoom;
    }
    


       
        
            public Room goNorth(Room curRoom)
    {
        return gameMap.getRoom(curRoom.getX(), curRoom.getY() - 1);
    }

    public Room goEast(Room curRoom)
    {
        return gameMap.getRoom(curRoom.getX() + 1, curRoom.getY());
    }

    public Room goSouth(Room curRoom)
    {
        return gameMap.getRoom(curRoom.getX(), curRoom.getY() + 1);
    }

    public Room goWest(Room curRoom)
    {
        return gameMap.getRoom(curRoom.getX() - 1, curRoom.getY());
    }

    public Room getCurRoom()
    {
        return curRoom;
    }

    public Map getGameMap()
    {
        return gameMap;
    }
    
 

    

}
