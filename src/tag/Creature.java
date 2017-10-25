/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.Arrays;
import java.util.List;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author adams
 */
public abstract class Creature
{
    protected Room curRoom;
    protected Map gameMap;
    
    
    public void initCreature()
    {
        gameMap = new Map(3, 5);
        gameMap.initMap(gameMap);
        
    }

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
