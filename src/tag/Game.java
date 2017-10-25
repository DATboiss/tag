package tag;

/**
 *
 * @author emilv
 */
public class Game
{

    public void playGame()
    {
        
        Player player = new Player("");

        player.initCreature();
        player.initPlayer(player);
        player.initCreature();
       

        while (player.getCurRoom() != player.getGameMap().getRoom(0, 4))
        {
            System.out.println("You are currently in: " + player.getCurRoom());
            player.nextRoom(player.getCurRoom());
        }
    }

}
