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

    // This method is used for giving the player money if the has picked up any consumeable bottle objects.
    // If the player has no bottles or he chooses to do nothing he will gain a bit of anxiety.
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
                // We use the iterator to check the list for Items while also removing items, if they match the item we are looking for.

                for (Iterator<Item> iterator = player.getInventory().iterator(); iterator.hasNext();)
                {

                    Item cons = iterator.next();
                    if ("Recycling bottle".equals(cons.getName()))
                    {
                        // We cast the Item cons value to Consumable, to get it's value, as items do not have a value, but consumables do.
                        Consumable money = (Consumable) cons;
                        player.alterMoney(money.getValue());
                        System.out.println("You recycle the bottle and gain " + money.getValue() + " kr.");
                        iterator.remove();
                        hasBottle = true;
                    }
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
