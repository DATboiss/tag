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
 * @author emilv
 */
public class Map
{

    private int mapWidth;
    private int mapHeight;
    private Room[][] gameMap;
    private Room curRoom;

    public Map(int mapWidth, int mapHeight)
    {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        gameMap = new Room[mapWidth][mapHeight];
        this.curRoom = curRoom;
    }

    public Room getRoom(int x, int y)
    {
        return gameMap[x][y];
    }

    // tests method to display the map in a 2D array
    public void display()
    {

        for (int y = 0; y < mapHeight; y++)
        {
            for (int x = 0; x < mapWidth; x++)
            {
                System.out.print(gameMap[x][y] + " ");
            }
            System.out.println(" ");
        }

    }

    public void insert(Room aRoom, int x, int y)
    {
        gameMap[x][y] = aRoom;
    }

    // creates and allocates all the rooms to a coordinate in the map
    public static void initMap(Map miniMap)
    {                                                                       //boolean north, east, south, west
        Room sp = new Room("Start", "Starting Point", 1, 2, 4, true, false, false, false);
        Room freshProd = new Room("Fresh produce", "desc", 2, 2, 3, true, false, false, true);
        Room bread = new Room("Bread", "desc", 3, 1, 3, true, true, false, false);
        Room frozen = new Room("Frozen", "desc", 4, 1, 2, false, true, true, false);
        Room coldCuts = new Room("Cold cuts", "desc", 5, 2, 2, true, false, true, true);
        Room cheese = new Room("Cheese", "desc", 6, 2, 1, true, false, true, true);
        Room dairy = new Room("Dairy", "desc", 7, 2, 0, false, false, true, true);
        Room butcher = new Room("Butcher", "desc", 8, 1, 0, false, true, true, false);
        Room deli = new Room("Deli", "desc", 9, 1, 1, true, true, false, true);
        Room alcohol = new Room("Alchohol", "desc", 10, 0, 1, true, true, true, false);
        Room bottle = new Room("Bottle recycler", "desc", 11, 0, 0, false, false, true, false);
        Room cleaning = new Room("Cleaning appliances", "desc", 12, 0, 2, true, false, true, false);
        Room candy = new Room("Candy", "desc", 13, 0, 3, true, false, true, false);
        Room register = new Room("Register", "desc", 14, 0, 4, true, false, false, false);
        Room goAwayNull = new Room("    ", "desc", 14, 1, 4, false, false, false, false);
        miniMap.insert(sp, 2, 4);
        miniMap.insert(freshProd, 2, 3);
        miniMap.insert(bread, 1, 3);
        miniMap.insert(frozen, 1, 2);
        miniMap.insert(coldCuts, 2, 2);
        miniMap.insert(cheese, 2, 1);
        miniMap.insert(dairy, 2, 0);
        miniMap.insert(butcher, 1, 0);
        miniMap.insert(deli, 1, 1);
        miniMap.insert(alcohol, 0, 1);
        miniMap.insert(bottle, 0, 0);
        miniMap.insert(cleaning, 0, 2);
        miniMap.insert(candy, 0, 3);
        miniMap.insert(register, 0, 4);
        miniMap.insert(goAwayNull, 1, 4);
    }
//    
//    This method is used to move the player around in the game, and moves the player to the selected choice.
//    

    public Room nextRoom(Room curRoom)
    {
        TextIO text = new TextIO(new SysTextIO());
        String[] strings = {"North", "East", "South", "West"};
        boolean stop = false;

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
                    return goNorth(curRoom);
                } else
                {
                    System.out.println("Please choose another option");
                    answer = text.select("Where do you wanna go", choices, "===================");
                }
                break;

            case 1:
                if (curRoom.isEast())
                {
                    return goEast(curRoom);
                } else
                {
                    System.out.println("Please choose another option");
                    answer = text.select("Where do you wanna go", choices, "===================");
                }
                break;

            case 2:
                if (curRoom.isSouth())
                {
                    return goSouth(curRoom);
                } else
                {
                    System.out.println("Please choose another option");
                    answer = text.select("Where do you wanna go", choices, "===================");
                }
                break;

            case 3:
                if (curRoom.isWest())
                {
                    return goWest(curRoom);
                } else
                {
                    System.out.println("Please choose another option");
                    answer = text.select("Where do you wanna go", choices, "===================");
                }
                break;
            default:
                text.put("That is not a valid command");
        }

        return curRoom;
    }

    /**
     * Used to move players into the new room
     *
     * @return
     */
    public Room goNorth(Room curRoom)
    {
        return getRoom(curRoom.getX(), curRoom.getY() - 1);
    }

    public Room goEast(Room curRoom)
    {
        return getRoom(curRoom.getX() + 1, curRoom.getY());
    }

    public Room goSouth(Room curRoom)
    {
        return getRoom(curRoom.getX(), curRoom.getY() + 1);
    }

    public Room goWest(Room curRoom)
    {
        return getRoom(curRoom.getX() - 1, curRoom.getY());
    }

}
