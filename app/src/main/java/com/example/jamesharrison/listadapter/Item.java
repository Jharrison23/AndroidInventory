package com.example.jamesharrison.listadapter;

/**
 * Created by jamesharrison on 12/5/16.
 */

public class Item
{
    private String ItemName;
    private String ItemDescription;
    private Double ItemPrice;
    private Integer ItemQuantity;


    public Item(String itemName, String itemDescription, Double itemPrice, Integer itemQuantity)
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

    public Double getItemPrice()
    {
        return ItemPrice;
    }

    public Integer getItemQuantity()
    {
        return ItemQuantity;
    }
}
