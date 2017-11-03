/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.item;

/**
 *
 * @author emilv
 */
public abstract class Item
{
    protected String name, description;
    protected int price;

    public Item(String name, String description, int price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public int getPrice()
    {
        return price;
    }

    @Override
    public String toString()
    {
        return "You picked up:\n" + name + "\n" + description + "\n" + price + ",-";
    }

  
    
    
}
