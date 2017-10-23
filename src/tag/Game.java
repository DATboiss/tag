package tag;

/**
 *
 * @author emilv
 */
public class Game
{

    public void playGame()
    {
        Map gameMap = new Map(3, 5);
        Player player = new Player("");

        gameMap.initMap(gameMap);
        player.initPlayer(player);

        Room curRoom = gameMap.getRoom(2, 4);

        while (curRoom != gameMap.getRoom(0, 4))
        {
            System.out.println("You are currently in: " + curRoom);
            curRoom = gameMap.nextRoom(curRoom);
        }
    }

}
