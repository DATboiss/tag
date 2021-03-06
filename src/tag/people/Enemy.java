/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.people;

import static java.awt.SystemColor.text;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import tag.item.Consumable;
import tag.item.Item;
import tag.map.Map;
import tag.map.Room;
import textio.SysTextIO;
import textio.TextIO;

//extends the Creature class (the ability to move around the map)
public class Enemy extends Creature
{

    private Random rnd = new Random();
    private boolean hasMet = false;

    public Enemy(Map gameMap, Room curRoom, String name)
    {
        super(gameMap, curRoom);
        this.curRoom = gameMap.getRoom(0, 4);
        this.name = name;
    }

//gives tyrone the bottles that will be dropped upon "defeat".
    public void initEnemy(int e)
    {
        Consumable recyclingBottle = new Consumable("Recycling bottle", "You can get money for recycling this", 0, 10);
        for (int i = 0; i < e; i++)
        {
            inventory.add(recyclingBottle);
        }
    }

// the enemies turn method. using a random(rnd) to make the walking pattern for Tyrone non-predictable.
    @Override
    public void takeTurn()
    {
        boolean enemyTurn = true;
        int result = rnd.nextInt(4);
        while (enemyTurn)
        {
            switch (result)
            {
                case 0:
                    if (curRoom.isNorth())
                    {
                        setCurRoom(goNorth(curRoom));
                        enemyTurn = false;
                    } else
                    {
                        result = rnd.nextInt(4);
                    }
                    break;

                case 1:
                    if (curRoom.isEast())
                    {
                        setCurRoom(goEast(curRoom));
                        enemyTurn = false;
                    } else
                    {

                        result = rnd.nextInt(4);

                    }
                    break;

                case 2:
                    if (curRoom.isSouth())
                    {
                        setCurRoom(goSouth(curRoom));
                        enemyTurn = false;
                    } else
                    {
                        result = rnd.nextInt(4);
                    }
                    break;

                case 3:
                    if (curRoom.isWest())
                    {
                        setCurRoom(goWest(curRoom));
                        enemyTurn = false;
                    } else
                    {
                        result = rnd.nextInt(4);
                    }
                    break;
                default:
                    System.out.println("Something went wrong");
            }
        }

    }

// the (non)combat method interaction will be played when the players curRoom == enemies curRoom.
// the hasMet method prompts a string that will be printed if you have "beat" Tyrone and meet him again.
    public void interaction(Player player)
    {
        TextIO text = new TextIO(new SysTextIO());
        if (hasMet)
        {
            text.put("My man!");
        } else
        {
            System.out.println("\n" + "\033[0;31m" +"Oh no! The security guard Tyrone has spotted you!" + "\u001B[0m");
            text.put("Hey, you there! Stop! I saw you on the CCTV eating that Snicker. "
                    + "Couldn't resist eating that chocolate bar fatty? "
                    + "If you don't pay me I'll give you another black chocolate bar to eat!");

            String[] strings =
            {
                "Show me your bobs and vegana, or I'll show you my katana",
                "I didn't eat it *lie*",
                "Sorry I'll give it back. Here you go *pukes the Snickers bar up",
                "Yo momma so stupid, she locked in the grocery store and starved",
                "Uuh that sounds tasty, let me get some of that good good",
                "Sorry I don't want to cause any trouble *pays security guard*",
            };

            List choices = Arrays.asList(strings);
            int answer = text.select("How will you answer Tyrone?", choices, "");
            
            
//this swicth contains Tyrones answers to your interaction, using a random for a non predictable playtrough, and adds to the players anxiety using the alterAnxiety method.
            switch (answer)
            {
                case 0:
                {
                    int chance = rnd.nextInt(2);
                    if (chance == 0)
                    {
                        text.put("Oh no, not the katana! "
                                + "I'll show you my bobs and vegana");
                    } else
                    {
                        text.put("Shut up weirdo");
                        player.alterAnxiety(25);
                    }
                    hasMet = true;
                    dropLoot();
                    break;

                }

                case 1:
                {
                    text.put("You have chocolate around your mouth fattie");
                    player.alterAnxiety(50);
                    hasMet = true;
                    break;
                }
                case 2:
                {
                    text.put("Disgusting scum! *Pukes while running away from you");
                    player.alterAnxiety(25);
                    hasMet = true;
                    dropLoot();
                    break;
                }
                case 3:
                {
                    text.put("Don't you dare talk about my momma! *Slaps you and kicks you out of the shop*");
                    player.alterAnxiety(100);
                    hasMet = true;
                    break;
                }
                case 4:
                {
                    text.put("I don't swing that way, homie *knocks you down*");
                    player.alterAnxiety(50);
                    hasMet = true;
                    break;
                }
                case 5:
                {
                    text.put("My man!");
                    player.alterMoney(-7);
                    hasMet = true;
                    dropLoot();
                    break;
                }

                default:
                    System.out.println("Why are you trying to break the game? Hackerman!!!");
                    dropLoot();
                    dropLoot();
                    dropLoot();
                    dropLoot();

            }
        }

    }

// the loot that Tyrone will "drop" for you, if you beat him. Bottles for the recycler
    public void dropLoot()
    {
        int count = 0;
        for (Item i : inventory)
        {
            curRoom.addItemToRoom(i);
            count++;
        }
        System.out.println("\nTyrone dropped " + count + " bottles");
    }
}
