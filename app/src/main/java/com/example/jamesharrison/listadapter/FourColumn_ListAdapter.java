package com.example.jamesharrison.listadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by jamesharrison on 12/5/16.
 */

public class FourColumn_ListAdapter extends ArrayAdapter<Item>
{
    private LayoutInflater inflater;

    private ArrayList<Item> items;

    private int mViewResourceId;

    public FourColumn_ListAdapter(Context context, int textViewResourseId, ArrayList<Item> items)
    {
        super(context, textViewResourseId, items);

        this.items = items;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        mViewResourceId = textViewResourseId;

    }

    public View getView(int position, View convertView, ViewGroup parents)
    {
        convertView = inflater.inflate(mViewResourceId, null);

        Item item = items.get(position);

        if(item != null)
        {
            TextView itemName = (TextView) convertView.findViewById(R.id.itemNameText);
            TextView itemDescription = (TextView) convertView.findViewById(R.id.itemDescriptionText);
            TextView itemPrice = (TextView) convertView.findViewById(R.id.itemPriceText);
            TextView itemQuantity = (TextView) convertView.findViewById(R.id.itemQuantityText);

            if(itemName != null)
            {
                itemName.setText(item.getItemName());
            }

            if (itemDescription != null)
            {
                itemDescription.setText(item.getItemDescription());
            }

            if(itemPrice != null)
            {
                itemPrice.setText(item.getItemPrice());
            }

            if (itemQuantity != null)
            {
                itemQuantity.setText(item.getItemQuantity());
            }

        }

        return convertView;
    }



}
