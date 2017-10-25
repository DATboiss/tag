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

    public Map(int mapWidth, int mapHeight)
    {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        gameMap = new Room[mapWidth][mapHeight];

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

    public Room getRoom(int x, int y)
    {
        return gameMap[x][y];
    }
//    
//    This method is used to move the player around in the game, and moves the player to the selected choice.
//    

    /**
     * Used to move players into the new room
     *
     * @return
     */
}
