/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tag.item;

import tag.item.Item;

/**
 *
 * @author adams
 */
public class Consumable extends Item
{
    private int value;


    public Consumable(String name, String description, int price, int value)
    {
        super(name, description, price);
        this.value = value;
    }
    
    public int getValue()
    {
        return value;
    }
    
    
}
