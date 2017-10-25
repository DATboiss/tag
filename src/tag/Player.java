/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author emilv
 */
public class Player extends Creature
{
    private String name;
    private int anxiety;
    private int money;
    ArrayList<Item> inventory = new ArrayList();

    public Player(String name)
    {
        this.name = name;
        anxiety = 0;
        money = 100;
    }

    // Asks the player for name
        public void initPlayer(Player player)
    {  
        curRoom = gameMap.getRoom(2, 4);
        TextIO text = new TextIO(new SysTextIO());
        text.put("Greetings kind adventurer, what is your name?");
        String name = text.get();
        player.setName(name);
        System.out.println("Greetings, " + player);
    }
         public void nextRoom(Room curRoom)
    {
        TextIO text = new TextIO(new SysTextIO());
        String[] strings = {"North", "East", "South", "West"};
        

        if (!curRoom.isNorth())
            strings[0] += " is not a valid option";
        else
            strings[0] += " '" + goNorth(curRoom).toString() + "'";
        if (!curRoom.isEast())
            strings[1] += " is not a valid option";
        else
            strings[1] += " '" + goEast(curRoom).toString() + "'";
        if (!curRoom.isSouth())
            strings[2] += " is not a valid option";
        else
            strings[2] += " '" + goSouth(curRoom).toString() + "'";
        if (!curRoom.isWest())
            strings[3] += " is not a valid option";
        else
            strings[3] += " '" + goWest(curRoom).toString() + "'";
        List choices = Arrays.asList(strings);
        int answer = text.select("Where do you wanna go", choices, "===================");
        System.out.println("You choose to head " + strings[answer]);

        switch (answer)
        {
            case 0:
                if (curRoom.isNorth())
                {
                    setCurRoom(goNorth(curRoom));
                } else
                {
                    System.out.println("Please choose another option");
                    answer = text.select("Where do you wanna go", choices, "===================");
                }
                break;

            case 1:
                if (curRoom.isEast())
                {
                    setCurRoom(goEast(curRoom));
                } else
                {
                    System.out.println("Please choose another option");
                    answer = text.select("Where do you wanna go", choices, "===================");
                }
                break;

            case 2:
                if (curRoom.isSouth())
                {
                    setCurRoom(goSouth(curRoom));
                } else
                {
                    System.out.println("Please choose another option");
                    answer = text.select("Where do you wanna go", choices, "===================");
                }
                break;

            case 3:
                if (curRoom.isWest())
                {
                    setCurRoom(goWest(curRoom));
                } else
                {
                    System.out.println("Please choose another option");
                    answer = text.select("Where do you wanna go", choices, "===================");
                }
                break;
            default:
                text.put("That is not a valid command");
        }
        
        
    }
    public String getName()
    {
        return name;
    }
    // getAnxiety represents the players health. It starts as 0 and lose if you reach certain max
    public int getAnxiety()
    {
        return anxiety;
    }

    public int getMoney()
    {
        return money;
    }

    public ArrayList<Item> getInventory()
    {
        return inventory;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    @Override
    public String toString()
    {
        return name;
    }
   
}
