package com.example.jamesharrison.listadapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jamesharrison on 12/3/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper
{


    public static final String DATABASE_NAME = "myDatabase.db";
    public static final String TABLE_NAME = "Inventory";
    public static final String COL1 = "ID";
    public static final String COL2 = "ITEMNAME";
    public static final String COL3 = "ITEMDESCRIPTION";
    public static final String COL4 = "ITEMPRICE";
    public static final String COL5 = "ITEMQUANTITY";



    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTable = "CREATE TABLE " + TABLE_NAME + " ( ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " ITEMNAME TEXT, ITEMDESCRIPTION TEXT, ITEMPRICE REAL, ITEMQUANTITY INTEGER) ";

        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP IF TABLE EXIST " +  TABLE_NAME);

        onCreate(db);

    }


    public boolean addData(String itemName, String itemDescription, String itemPrice, String itemQuantity)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        Double price = Double.parseDouble(itemPrice);

        Integer quantity = Integer.parseInt(itemQuantity);

        values.put(COL2, itemName);
        values.put(COL3, itemDescription);
        values.put(COL4, price);
        values.put(COL5, quantity);

        long result = db.insert(TABLE_NAME, null, values);

        if(result == -1)
        {
            return false;
        }

        else
        {
            return true;
        }
    }


    public Cursor getListContents()
    {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        return data;
    }
}
