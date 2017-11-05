
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



//extends the Creature class (the ability to move around the map)
public class Player extends Creature
{

    private int anxiety;
    private int money;
    private int pointSum;

    
    
    // sets the anxiety (health) to 0 so it can easily be modified
    public Player(Map gameMap, Room curRoom)
    {
        super(gameMap, curRoom);
        anxiety = 0;
        money = 250;
    }

    public int getPointSum()
    {
        return pointSum;
    }

    public String getName()
    {
        return name;
    }

    // getAnxiety represents the players health. It will be modified troughout the game, and reaching 100 means death.
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

//Adds item to the inventory without giving the player any input options.
    public void addItemToInventory(int i)
    {
        
        
//the snickers will be consumed as soon as you pick it up.
        if (curRoom.getRoomItem(i).getName().equalsIgnoreCase("Snickers bar"))
        {
            Consumable cons = (Consumable) curRoom.getRoomItem(i);
            System.out.println("You couldn't help yourself. You ate the snickers immediately and your anxiety dropped by " + cons.getValue());
            anxiety -= cons.getValue();
        } else
        {
            inventory.add(curRoom.getRoomItem(i));
        }
        curRoom.removeRoomItem(i);
    }
    
    
//method for picking up the given items in each room, using the TextIO template.
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

  //calculates the highscore. each item in the inventory during the end will add to the highscore sum, which then is multiplied by 100-anxiety.
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
        sum *= 100 - anxiety;

        return sum;
    }

// the player's settings
    public void initPlayer(Player player)
    {

        TextIO text = new TextIO(new SysTextIO());
        text.put("Greetings kind adventurer, what is your name?");
        String name = text.get();
        player.setName(name);
        System.out.println("Greetings, " + player);
    }

//Checks the current room for available paths to other rooms. The arraylist choices is used in the switch to validate your choice.
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
        money += i;
    }

    @Override
    public void takeTurn() //
    {
    }

    public void alterPointsum(int i)
    {
        pointSum += i;
    }

}
