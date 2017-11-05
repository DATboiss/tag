/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.map;

import tag.item.Consumable;
import tag.item.Objective;
import tag.item.ShoppingList;

/**
 *
 * @author emilv
 */
public class Map
{

    private int mapWidth;
    private int mapHeight;
    private Room[][] gameMap;

    public Map(int mapWidth, int mapHeight)
    {
        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        gameMap = new Room[mapWidth][mapHeight];

    }

    // tests method to display the map in a 2D array
    public void display()
    {

        for (int y = 0; y < mapHeight; y++)
        {
            for (int x = 0; x < mapWidth; x++)
            {
                System.out.print(gameMap[x][y] + " ");
            }
            System.out.println(" ");
        }

    }

    public void insert(Room aRoom, int x, int y)
    {
        gameMap[x][y] = aRoom;
    }

    // creates and allocates all the rooms to a coordinate in the map
    public static void initMap(Map miniMap)
    {
        ShoppingList shoppinglist = new ShoppingList();
        shoppinglist.initShoppingList();
        Objective eggPlant = new Objective("Egg Plant", "Long and hard", 8);
        Objective toast = new Objective("Toast", "Soft like a babies butt", 20);
        Objective fishSticks = new Objective("Fish sticks", "Do you like to put them in your mouth?", 20);
        Objective ham = new Objective("Ham", "John's very own", 12);
        Objective cheddar = new Objective("Cheddar Cheese", "Nacho Cheese", 6);
        Objective milk = new Objective("Lactose Glutenfree extra vegan natural soya milk", "Issa Milk bottle", 25);
        Objective sausage = new Objective("Sausage", "Huge weiner", 35);
        Objective tappas = new Objective("Tappas", "Ay Caramba", 45);
        Objective booze = new Objective("Grand Marnier", "Triple Sec Orrange liqour", 75);
        Objective intimateSoap = new Objective("Vivag", "Mommy smells a bit fishy", 40);
        Objective doritos = new Objective("XXL Doritos", "XXL, when you've got to compensate for something", 30);
        Consumable snickers = new Consumable("Snickers bar", "You're not your when you're hungry", 6, -20);

        //boolean north, east, south, west   
        Room sp = new Room("Start", "", 1, 2, 4, true, false, false, false);
        Room freshProd = new Room("Fresh produce", "", 2, 2, 3, true, false, false, true);
        Room bread = new Room("Bread", "", 3, 1, 3, true, true, false, false);
        Room frozen = new Room("Frozen", "", 4, 1, 2, false, true, true, false);
        Room coldCuts = new Room("Cold cuts", "", 5, 2, 2, true, false, true, true);
        Room cheese = new Room("Cheese", "", 6, 2, 1, true, false, true, true);
        Room dairy = new Room("Dairy", "", 7, 2, 0, false, false, true, true);
        Room butcher = new Room("Butcher", "", 8, 1, 0, false, true, true, false);
        Room deli = new Room("Deli", "", 9, 1, 1, true, true, false, true);
        Room alcohol = new Room("Alchohol", "", 10, 0, 1, true, true, true, false);
        Room bottle = new Room("Bottle recycler", "", 11, 0, 0, false, false, true, false);
        Room personalHygeine = new Room("Personal Hygeine", "", 12, 0, 2, true, false, true, false);
        Room candy = new Room("Candy", "", 13, 0, 3, true, false, true, false);
        Room register = new Room("Register", "", 14, 0, 4, true, false, false, false);
        Room goAwayNull = new Room("    ", "", 14, 1, 4, false, false, false, false);
        freshProd.addItemToRoom(eggPlant);
        freshProd.addItemToRoom(snickers);
        bread.addItemToRoom(toast);
        frozen.addItemToRoom(fishSticks);
        coldCuts.addItemToRoom(ham);
        cheese.addItemToRoom(cheddar);
        dairy.addItemToRoom(milk);
        butcher.addItemToRoom(sausage);
        deli.addItemToRoom(tappas);
        alcohol.addItemToRoom(booze);
        personalHygeine.addItemToRoom(intimateSoap);
        candy.addItemToRoom(doritos);

        miniMap.insert(sp, 2, 4);
        miniMap.insert(freshProd, 2, 3);
        miniMap.insert(bread, 1, 3);
        miniMap.insert(frozen, 1, 2);
        miniMap.insert(coldCuts, 2, 2);
        miniMap.insert(cheese, 2, 1);
        miniMap.insert(dairy, 2, 0);
        miniMap.insert(butcher, 1, 0);
        miniMap.insert(deli, 1, 1);
        miniMap.insert(alcohol, 0, 1);
        miniMap.insert(bottle, 0, 0);
        miniMap.insert(personalHygeine, 0, 2);
        miniMap.insert(candy, 0, 3);
        miniMap.insert(register, 0, 4);
        miniMap.insert(goAwayNull, 1, 4);
        sp.setDesc("Your mom has asked you to go grocery shopping for her. "
                + "She’s given you a shopping list with the following items: \n"
                + "===================\n" 
                + shoppinglist.shoppingListToString() 
                + "===================\n" 
                + "She’s given 250 kr. to buy it all. "
                + "Since you’re socially anxious, try to avoid all forms of social contact!");

        
        freshProd.setDesc("You enter the supermarket, and the cold and humid surroundings of the fresh produce section makes you shiver. You look at mom’s shopping list, and notice she needs an eggplant.");
        bread.setDesc("The bread section is a small double sided aisle, with little room. You look for the soft, most baby-butt like toast you can find.");
        frozen.setDesc("Mom also wanted fishsticks. Do I like fishsticks? hell yeah. The coolers are filled with various fish and pizzas. You resist the urge to ...fish up a frozen pizza and go straight for the fishsticks.");
        coldCuts.setDesc("The smell of flesh surrounds your nose, and as you inhale, you are reminded that mom wanted ham. Ham and fishstick sandwich for dinner? I hope not.");
        cheese.setDesc("The cheese section, however, is the worst thing you have done to your nose, since you played 37 hours of WoW on the Wrath of the Lich King expansion. Luckily, she only needed cheddar.");
        dairy.setDesc("I know my mom, and I know she has all types of imaginary allergies. And she needs milk. So naturally, you look for the Lactose, gluten free extra vegan natural soy milk.");
        butcher.setDesc("Mom need’s sausage - so naturally you ask the hairy-woodcutter butcher man for a phat piece of sausage. He delivers.");
        deli.setDesc("Mom’s having friends over tomorrow, and wanted tapas. I have no idea what that means, but there are various tapas kit. That’ll have to do.");
        alcohol.setDesc("Mom’s a raging alcoholic and needs her daily fix of a bottle of Grand Marnier.");
        bottle.setDesc("Mom’s been having too much fun with the neighbours, and her private parts has gone sour. She needs her ViVag");
        personalHygeine.setDesc("Mom’s been having too much fun with the neighbours, and her private parts has gone sour. She needs her ViVag.");
        candy.setDesc("Unlike 50 cent, your mom doesn’t take you to the candy shop. She wants you to buy some game fuel in the shape of doritos and mountain dew. However, this probably will not amount to 50 cent.");
        register.setDesc("You have reached the end of the line. This is what you have been training for. Let’s see if you have enough money for it all");

    }

    public Room getRoom(int x, int y)
    {
        return gameMap[x][y];
    }
//    
//    This method is used to move the player around in the game, and moves the player to the selected choice.
//    

    /**
     * Used to move players into the new room
     *
     * @return
     */
}
