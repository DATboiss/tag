/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag;

import java.util.ArrayList;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author emilv
 */
public class Player
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
    // Asks the player for name
    public void initPlayer(Player player)
    {  
        
        TextIO text = new TextIO(new SysTextIO());
        text.put("Greetings kind adventurer, what is your name?");
        String name = text.get();
        player.setName(name);
        System.out.println("Greetings, " + player);
    }

    @Override
    public String toString()
    {
        return name;
    }
   
}
