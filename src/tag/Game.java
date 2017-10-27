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

        System.out.print(hm.getHighscoreString());

        while (player.getCurRoom() != enemy.getCurRoom() && player.getCurRoom() != gameMap.getRoom(0, 4))
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
        } else
        {
            int score = player.calcScore();
            hm.addScore(player.getName(), score);
            System.out.println("You won the game, your score is: " + score);

        }
            System.out.println(hm.getHighscoreString());
    }

}
