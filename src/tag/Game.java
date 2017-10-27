package tag;

import highscore.HighscoreManager;
import java.io.IOException;
import tag.map.Map;
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
        player.initPlayer(player);
        HighscoreManager hm = new HighscoreManager();
        hm.addScore("Bart", 240);
        hm.addScore("Marge", 300);
        hm.addScore("Maggie", 220);
        hm.addScore("Homer", 100);
        hm.addScore("Lisa", 270);
        hm.addScore("Emil", 0);

        System.out.print(hm.getHighscoreString());

        while (player.getCurRoom() != enemy.getCurRoom())
        {
            System.out.println("Tyrone is at " + enemy.getCurRoom());
            System.out.println("You are currently in: " + player.getCurRoom());
            player.getCurRoom().printRoomItems();
            System.out.println("====================================");
            player.nextRoom(player.getCurRoom());
            player.pickUpItem();
            player.printInventory();
            enemy.takeTurn();

        }
        if (player.getCurRoom().equals(enemy.getCurRoom()))
        {
            System.out.println("Oh no! you got caught by Tyrone");
        }
    }

}
