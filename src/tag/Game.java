package tag;

import bottleRecycler.Machine;
import highscore.HighscoreManager;
import java.io.IOException;
import tag.map.Map;
import tag.map.Register;
import tag.people.Enemy;
import tag.people.Player;

/**
 *
 * @author emilv
 */
public class Game
{

    public void playGame() throws IOException
    {

        Map gameMap = new Map(3, 5);
        gameMap.initMap(gameMap);
        Player player = new Player(gameMap, gameMap.getRoom(2, 4));
        Enemy enemy = new Enemy(gameMap, gameMap.getRoom(0, 4), "Tyrone");
        enemy.initEnemy(3);
        player.initPlayer(player);
        Machine recycle = new Machine();
        HighscoreManager hm = new HighscoreManager();
        
        while (player.getAnxiety() < 100 && player.getCurRoom() != gameMap.getRoom(0, 4))
        {

            if (player.getCurRoom().equals(enemy.getCurRoom()))
            {
                enemy.interaction(player);
            }
            if (player.getAnxiety() >= 100) break;
            if (player.getCurRoom().equals(gameMap.getRoom(0, 0)))
            {
                recycle.recycleBottles(player);
            }
            if (player.getAnxiety() >= 100) break;

            System.out.println("             ");
            player.getCurRoom().printRoomItems();
            System.out.println("Security guard Tyrone is currently in: " + enemy.getCurRoom());
            System.out.println("You are currently in: " + player.getCurRoom());
            System.out.println("====================================");
            player.pickUpItem();
            player.printInventory();
            player.nextRoom(player.getCurRoom());
            enemy.takeTurn();

        }

        if (player.getAnxiety() >= 100)
            System.out.println("Sorry! Your social anxiety is too much for you, and you abandon your shoppingcart and rush home to your mommy!");
        else
        {
            Register register = new Register();
            register.payForItems(player, player.getInventory());
        }
        if (player.getAnxiety() >= 100)
        {
            System.out.println("Sorry! Your social anxiety is too much for you, and you abandon your shoppingcart and rush home to your mommy!");
        } else
        {
            System.out.println("Congratulation. You reached the register and bought some items for your mom. \n You have won the game!!!");

            player.calcScore();

            hm.addScore(player.getName(), player.getPointSum());
        }
        System.out.print(hm.getHighscoreString());
    }

}
