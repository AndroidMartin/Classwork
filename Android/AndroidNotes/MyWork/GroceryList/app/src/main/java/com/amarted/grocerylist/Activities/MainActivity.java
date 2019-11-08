package com.amarted.grocerylist.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.amarted.grocerylist.Data.DatabaseHandler;
import com.amarted.grocerylist.Model.Grocery;
import com.amarted.grocerylist.R;

/*
 *      This file is obviously what drives the application.  It is here were call everything to happen as the
 *      application starts up.  This is also where we can call our other scripts to handle actions.
 */

public class MainActivity extends AppCompatActivity {

    // DECLARE YOUR VARIABLES (objects)
    private AlertDialog.Builder dialogBuilder;
    private AlertDialog dialog;
    private EditText groceryItem;
    private EditText quantity;
    private Button saveButton;

    // INVOKE DatabaseHandler.java
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // instantiate handler
        db = new DatabaseHandler(this);

        // calls our method we created at the bottom
        byPassActivity();
// ToDo: Add onClickListener to fab in the ListActivity
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                createPopupDialog();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createPopupDialog() {
        // Instantiate Dialog Builder
        dialogBuilder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.popup,null);
        // Instantiate variable declared in beginning
        groceryItem = view.findViewById(R.id.groceryItem);
        quantity = view.findViewById(R.id.groceryQty);
        saveButton = view.findViewById(R.id.saveButton);

        // Show dialog box
        dialogBuilder.setView(view);
        dialog = dialogBuilder.create();
        dialog.show();

        // ??
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!groceryItem.getText().toString().isEmpty() && !quantity.getText().toString().isEmpty());
                    saveGroceryToDB(view);
            }
        });
    }

    // Save Method
    private void saveGroceryToDB(View view){
        // create grocery object
        Grocery grocery = new Grocery();
        String newGrocery = groceryItem.getText().toString();
        String newGroceryQty = quantity.getText().toString();

        grocery.setName(newGrocery);
        grocery.setQuantity(newGroceryQty);

        // Save to DB
        db.addGrocery(grocery);

        Snackbar.make(view,"Item Saved!",Snackbar.LENGTH_SHORT).show();
        //Log.d("New Item ID",String.valueOf(db.getCount()));

        // add a handler on a slight delay to allow for proper memory allocation and better UI
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // dismiss the dialog we created that is popup.xml
                dialog.dismiss();
                //start a new activity - takes us to the List View
                //                                     |-- from here --||--- to there ---|
                startActivity(new Intent(MainActivity.this,ListActivity.class));
            }
        },1000); // <- 1sec delay
    }


    // New method to bypass the "Add Items" screen if there is already a database
    public void byPassActivity() {
        // Checks if database if empty; if not, then we just go to ListActivity and show all added items
        if (db.getCount() > 0 ){
            startActivity(new Intent(MainActivity.this,ListActivity.class));
            finish(); // <- gets rid of the previous activity - the back button won't take you back to the main activity
        }
    }
}
