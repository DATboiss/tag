/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.item;

import java.util.ArrayList;

/**
 *
 * @author emilv
 */
public class ShoppingList
{

    private ArrayList<Objective> objectiveList = new ArrayList();

    public ShoppingList()
    {
    }

    public void initShoppingList()
    {
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

        objectiveList.add(eggPlant);
        objectiveList.add(toast);
        objectiveList.add(fishSticks);
        objectiveList.add(ham);
        objectiveList.add(cheddar);
        objectiveList.add(milk);
        objectiveList.add(sausage);
        objectiveList.add(tappas);
        objectiveList.add(booze);
        objectiveList.add(intimateSoap);
        objectiveList.add(doritos);
    }

    public void printShoppingList()
    {
        for (Objective o : objectiveList)
        {
            System.out.println(o.getName());
        }
    }

    public String shoppingListToString()
    {
        String str = "";
        for (Objective o : objectiveList)
        {
            str += o.getName() + "\n";
        }
        return str;
    }
}
