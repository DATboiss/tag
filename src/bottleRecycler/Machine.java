/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bottleRecycler;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import tag.item.Consumable;
import tag.item.Item;
import tag.people.Player;
import textio.SysTextIO;
import textio.TextIO;

/**
 *
 * @author adams
 */
public class Machine
{

    public Machine()
    {

    }

    public void recycleBottles(Player player)
    {
        TextIO text = new TextIO(new SysTextIO());
        text.put("You see a big red bottle recycling machine in front of you. As a manlet, the height intimidates you.");
        String[] strings =
        {
            "Grab a box, stand on it and recycle the bottles in your inventory", "Nothing"
        };

        List choices = Arrays.asList(strings);
        int answer = text.select("What would you like to do?", choices, "");
        switch (answer)
        {

            case 0:
        {
            boolean hasBottle = false;
           
                for (Iterator<Item> iterator = player.getInventory().iterator(); iterator.hasNext();)
                {
//                    if (c instanceof Consumable && c.getName().equals("Recycling bottle"))
////                    {
                        Item cons = iterator.next();
                        if("Recycling bottle".equals(cons.getName()))
                        {
//                        player.alterMoney(cons.);
//                        System.out.println("You recycle the bottle and gain " + cons.getValue() + " kr.");
                        iterator.remove();
                        hasBottle = true;
                        }


//                    }
                    
                }
                    
            if (!hasBottle)
            {
                System.out.println("You try to insert " + player.getInventory().get(answer).getName() + " into the machine, "
                        + "as you do not have any bottles in your inventory. "
                        + "The people around you cringe and you feel very, very stupid.");
                player.alterAnxiety(10);
            }
                    break;
        }
            case 1:
                System.out.println("You do nothing but stare at the recycling machine, the people around you stare at you "
                        + "and shake their heads");
                player.alterAnxiety(10);
                break;
        }
    }
}
