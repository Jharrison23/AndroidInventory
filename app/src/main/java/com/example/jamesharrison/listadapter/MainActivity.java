package com.example.jamesharrison.listadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

// Project by James Harrison, example to model and inventory which reads and writes to an sqlite database
public class MainActivity extends AppCompatActivity
{

    DatabaseHelper myDB;

    EditText itemName, itemPrice, itemQuantity, itemDescription;
    Button btnAdd, btnView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        itemName = (EditText) findViewById(R.id.itemName);
        itemPrice = (EditText) findViewById(R.id.itemPrice);
        itemDescription = (EditText) findViewById(R.id.itemDescription);
        itemQuantity = (EditText) findViewById(R.id.itemQuantity);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);

        //myDB = new DatabaseHelper(this);




    }
}
