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
public class Objective extends Item
{
    private int points;

    public Objective(String name, String description, int price)
    {
        super(name, description, price);
        points = price;
    }

    public int getPoints()
    {
        return points;
    }
    
    
}
