package tag.map;

import java.util.ArrayList;
import tag.item.Item;
import tag.item.Objective;
import tag.people.Player;

/**
 *
 * @author emilv
 */
public class Register
{

    public void payForItems(Player player, ArrayList<Item> inventory)
    {

        for (Item i : inventory)
        {
            if (i instanceof Objective)
            {
                if (i.getPrice() <= player.getMoney())
                {
                    System.out.println("The cashierlady scans in the " + i.getName() + " and fortunately, you have enough money for it");
                    player.alterPointsum(i.getPrice());
                    player.alterMoney(-i.getPrice());
                } else
                {
                    System.out.println("The cashierlady is about to scan in the " + i.getName() + " but you realize that you dont have enought money for it. "
                            + "You tell the cashierlady, that you can't afford the item. She seems anoyed, and your anxiety is raised by 10");
                    player.alterAnxiety(10);
                }
            }
        }

    }

}
