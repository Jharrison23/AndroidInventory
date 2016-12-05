package com.example.jamesharrison.listadapter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, ViewListContents.class);

                startActivity(intent);

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String name = itemName.getText().toString();
                String description = itemDescription.getText().toString();
                String price =  itemPrice.getText().toString();
                String quantity = itemQuantity.getText().toString();

                if(name.length() != 0 && description.length() != 0 && price.length() != 0 && quantity.length() != 0)
                {
                    // try to add the elements to the database
                    boolean result = myDB.addData(name, description, price, quantity);

                    if (result)
                    {
                        Toast.makeText(MainActivity.this, "Item Added to Inventory", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        Toast.makeText(MainActivity.this, "Something wrong cant add", Toast.LENGTH_SHORT).show();
                    }

                    // once everything is added reset the UI elements to make the blank again
                    itemName.setText("");
                    itemPrice.setText("");
                    itemDescription.setText("");
                    itemQuantity.setText("");

                }

                else
                {
                    Toast.makeText(MainActivity.this, "There is nothing to add", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}
