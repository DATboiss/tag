package tag;

import tag.map.Map;
import tag.people.Enemy;
import tag.people.Player;

/**
 *
 * @author emilv
 */
public class Game
{

    public void playGame()
    {
        
        Map gameMap = new Map(3, 5);
        gameMap.initMap(gameMap);
        Player player = new Player(gameMap, gameMap.getRoom(2, 4));
        Enemy enemy = new Enemy(gameMap, gameMap.getRoom(0, 4), "Tyrone");
        player.initPlayer(player);
        System.out.println(enemy.getName());
        System.out.println(player.getName());
        
        
       

        while (player.getCurRoom() != enemy.getCurRoom())
        {
            System.out.println("Tyrone is at " + enemy.getCurRoom());
            System.out.println("You are currently in: " + player.getCurRoom());
            player.nextRoom(player.getCurRoom());
            enemy.takeTurn();
        }
        if (player.getCurRoom().equals(enemy.getCurRoom()))
            {
                System.out.println("Oh no! you got caught by Tyrone");
            }
    }

}
