package com.amarted.mycaloriecounter;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import data.DatabaseHandler;
import model.Food;

public class FoodItemDetailsActivity extends AppCompatActivity {
    private TextView foodName, calories, dateTaken;
    private Button buttonShare;
    private int localFoodID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_details);

        foodName = findViewById(R.id.detsFoodName);
        calories = findViewById(R.id.detsCaloriesValues);
        dateTaken = findViewById(R.id.detsDateText);
        buttonShare = findViewById(R.id.buttonShare);

        //import "frozen" object from ???
        Food frozenFood = (Food) getIntent().getSerializableExtra("userObj");
        //                                                           ^- from CustomListViewAdapter.java
        foodName.setText(frozenFood.getFoodName());
        calories.setText(String.valueOf(frozenFood.getCalories()));
        dateTaken.setText(frozenFood.getRecordDate());
        localFoodID = frozenFood.getFoodID();

        //set physical properties via code
        calories.setTextSize(34.9f);
        calories.setTextColor(Color.RED);

        buttonShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the method at the bottom to share the info
                shareCals();
            }
        });
    }

    //For the "Share" button
    public void shareCals() {
        StringBuilder dataString = new StringBuilder();

        String name = foodName.getText().toString();
        String cals = calories.getText().toString();
        String date = dateTaken.getText().toString();

        dataString.append("Food: " + name + "\n");
        dataString.append("Calories: " + cals + "\n");
        dataString.append("Eaten on: " + date);

        //Send email to someone
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822"); // <- tells the android system to minimize the number of sending options
        i.putExtra(Intent.EXTRA_SUBJECT, "My Caloric Intake");
        i.putExtra(Intent.EXTRA_EMAIL,"dogjunkme@gmail.com");
        i.putExtra(Intent.EXTRA_TEXT, dataString.toString());
        // TODO: Make a pop-up to ask for the recipient

        // Send the email...
        try{
            //allow user to select email client (gmail, yahoo, samsungMail, etc.)
            startActivity(Intent.createChooser(i,"Send mail..."));
        //in the event the user doesn't have a proper client installed
        }catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(),"Please install email client before sending", Toast.LENGTH_LONG).show();
        }
    }


    //

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar, if present.
        getMenuInflater().inflate(R.menu.menu_food_item_details,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemsSelected(MenuItem item) {
        /*   Handle action bar item clicks here. The action bar will
         *   automatically handle clicks on the Home/Up button, so long
         *   as you specify a parent activity in AndroidManifest.xml.
         */
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.deleteItem) {

            AlertDialog.Builder alert = new AlertDialog.Builder(FoodItemDetailsActivity.this);
            alert.setTitle("Delete?");
            alert.setMessage("Are you sure you want to delete this item?");
            alert.setNegativeButton("No",null);
            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    DatabaseHandler dba = new DatabaseHandler(getApplicationContext());
                    dba.deleteItem(localFoodID);

                    Toast.makeText(getApplicationContext(),"Food Item Deleted!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FoodItemDetailsActivity.this,DisplayFoodsActivity.class));

                    //remove activity from activity stack
                    FoodItemDetailsActivity.this.finish();
                }
            });
            alert.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
