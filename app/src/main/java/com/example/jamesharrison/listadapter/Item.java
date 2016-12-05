package com.example.jamesharrison.listadapter;

/**
 * Created by jamesharrison on 12/5/16.
 */

public class Item
{
    private String ItemName;
    private String ItemDescription;
    private String ItemPrice;
    private String ItemQuantity;


    public Item(String itemName, String itemDescription, String itemPrice, String itemQuantity)
    {
        ItemName = itemName;

        ItemDescription = itemDescription;

        ItemPrice = itemPrice;

        ItemQuantity = itemQuantity;
    }


    public String getItemName()
    {
        return ItemName;
    }

    public String getItemDescription()
    {
        return ItemDescription;
    }

    public String getItemPrice()
    {
        return ItemPrice;
    }

    public String getItemQuantity()
    {
        return ItemQuantity;
    }
}
