/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tag.item.Consumable;
import tag.people.Creature;
import tag.item.Item;
import tag.item.Objective;
import tag.map.Map;
import tag.map.Room;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author emilv
 */
public class Player extends Creature
{

    
    private int anxiety;
    private int money;
    private int pointSum;
    

    public Player(Map gameMap, Room curRoom)
    {
        super(gameMap, curRoom);
        anxiety = 0;
        money = 100; //change later
    }

    public int getPointSum()
    {
        return pointSum;
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

   public void addItemToInventory(int i) {
        
        if (curRoom.getRoomItem(i).getName().equalsIgnoreCase("Snickers bar"))
        {
            Consumable cons = (Consumable)curRoom.getRoomItem(i);
            System.out.println("You couldn't help yourself. You ate the snickers immediately and your anxiety dropped by " + cons.getValue());   
            anxiety -= cons.getValue();
        }
        else
        {
        inventory.add(curRoom.getRoomItem(i));
        }
        curRoom.removeRoomItem(i);
    }

    public void pickUpItem()
    {

        while (curRoom.getRoomItems().size() > 0)
        {
            {
                TextIO text = new TextIO(new SysTextIO());
                String[] strings = new String[curRoom.getRoomItems().size() + 1];

                for (int i = 0; i < curRoom.getRoomItems().size(); i++)
                {
                    strings[i] = "pick up " + curRoom.getRoomItem(i).getName();
                }
                strings[curRoom.getRoomItems().size()] = "To not pickup any items";
                List choices = Arrays.asList(strings);

                int answer = text.select("What do you want to pick up?", choices, "Select a valid option!");
                if (answer != curRoom.getRoomItems().size())
                {
                    System.out.println(curRoom.getRoomItem(answer) + "\n");
                    addItemToInventory(answer);
                } else
                {
                    System.out.println("You chose to not pick up any items.");
                    break;
                }
            }
           
        }

    }
    

    public void printInventory()
    {
        System.out.println("  Item list  ");
        System.out.println("=============");
        for (Item item : inventory)
        {
            System.out.println(item.getName());
        }
        System.out.println("=============");
        System.out.println(" ");
    }

    public int calcScore()
    {
        int sum = 0;
        for (Item i : inventory)
        {
            if (i instanceof Objective)
            {
                sum += ((Objective) i).getPoints();
            }
        }
        sum *= 100-anxiety;

        return sum;
    }

    // Asks the player for name
    public void initPlayer(Player player)
    {

        TextIO text = new TextIO(new SysTextIO());
        text.put("Greetings kind adventurer, what is your name?");
        String name = text.get();
        player.setName(name);
        System.out.println("Greetings, " + player);
    }

    public void nextRoom(Room curRoom)
    {
        TextIO text = new TextIO(new SysTextIO());
        String[] strings =
        {
            "North", "East", "South", "West"
        };

        if (!curRoom.isNorth())
        {
            strings[0] += " is not a valid option";
        } else
        {
            strings[0] += " '" + goNorth(curRoom).toString() + "'";
        }
        if (!curRoom.isEast())
        {
            strings[1] += " is not a valid option";
        } else
        {
            strings[1] += " '" + goEast(curRoom).toString() + "'";
        }
        if (!curRoom.isSouth())
        {
            strings[2] += " is not a valid option";
        } else
        {
            strings[2] += " '" + goSouth(curRoom).toString() + "'";
        }
        if (!curRoom.isWest())
        {
            strings[3] += " is not a valid option";
        } else
        {
            strings[3] += " '" + goWest(curRoom).toString() + "'";
        }
        List choices = Arrays.asList(strings);
        int answer = text.select("Where do you wanna go", choices, "===================");
        System.out.println("\n" + "You choose to head " + strings[answer]);

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

    @Override
    public String toString()
    {
        return name;
    }

    public void alterAnxiety(int i)
    {
        anxiety += i;
    }
    
    public void alterMoney(int i)
    {
        anxiety += i;
    }
     
    
    
    
    @Override
    public void takeTurn() //
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
