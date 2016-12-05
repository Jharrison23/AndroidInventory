package com.example.jamesharrison.listadapter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by jamesharrison on 12/3/16.
 */

public class ViewListContents extends AppCompatActivity
{

    DatabaseHelper myDB;

    ListView listView;

    ArrayList<Item> itemList;

    Item item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        listView = (ListView) findViewById(R.id.listView);

        myDB = new DatabaseHelper(this);

        itemList = new ArrayList<Item>();

        Cursor data = myDB.getListContents();

        // represents the amount of rows stored in the sql database
        int numRows = data.getCount();

        // check and make sure there database isn't empty
        if(numRows == 0)
        {
            Toast.makeText(ViewListContents.this, "The database is empty", Toast.LENGTH_SHORT).show();
        }

        else
        {

            // iterate through the database with the cursor
            while(data.moveToNext())
            {
                // get the elements of the item from the database, name, description, price, quantity
                item = new Item(data.getString(1), data.getString(2), data.getString(3), data.getString(4));

                // add the new item to the itemlist array
                itemList.add(item);
            }

            // link the list adapter view
            FourColumn_ListAdapter adapter = new FourColumn_ListAdapter(this, R.layout.list_adapter_view, itemList);

            // set list to the adapter
            listView.setAdapter(adapter);
        }

    }
}
