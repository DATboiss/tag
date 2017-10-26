/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.people;

import java.util.Random;
import tag.map.Map;
import tag.map.Room;
import tag.people.Creature;

/**
 *
 * @author adams
 */
public class Enemy extends Creature
{

    private int health;
    private Random rnd = new Random();

    public Enemy(Map gameMap, Room curRoom, String name)
    {
        super(gameMap, curRoom);
        this.curRoom = gameMap.getRoom(0, 4);
        this.name = name;
    }

    @Override
    public void takeTurn()
    {
        boolean enemyTurn = true;
        int result = rnd.nextInt(4);
        while (enemyTurn)
        {
        switch (result)
        {
            case 0:
                if (curRoom.isNorth())
                {
                    setCurRoom(goNorth(curRoom));
                    enemyTurn = false;
                } else
                {
                    result = rnd.nextInt(4);
                }
                break;

            case 1:
                if (curRoom.isEast())
                {
                    setCurRoom(goEast(curRoom));
                    enemyTurn = false;
                } else
                {
                    
                    result = rnd.nextInt(4);
                    
                }
                break;

            case 2:
                if (curRoom.isSouth())
                {
                    setCurRoom(goSouth(curRoom));
                    enemyTurn = false;
                } else
                {
                    result = rnd.nextInt(4);
                }
                break;

            case 3:
                if (curRoom.isWest())
                {
                    setCurRoom(goWest(curRoom));
                    enemyTurn = false;
                } else
                {
                    result = rnd.nextInt(4);
                }
                break;
            default:
                System.out.println("Something went wrong");
        }
        }
    }

}
