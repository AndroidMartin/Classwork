package com.amarted.mycaloriecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import data.CustomListviewAdapter;
import data.DatabaseHandler;
import model.Food;
import util.Utils;

public class DisplayFoodsActivity extends AppCompatActivity {

    private DatabaseHandler dba;
    private ArrayList<Food> dbFoods = new ArrayList<>();
    private CustomListviewAdapter foodAdapter;
    private ListView listView;
    private Food myFood;
    private TextView totalCals, totalFoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_foods);

        listView = findViewById(R.id.list); // <- the listView we created in activity_display_foods.xml
        totalCals = findViewById(R.id.totalAmountTextView);
        totalFoods = findViewById(R.id.totalItemsTextView);

        refreshData();

    }

    private void refreshData() {
        dbFoods.clear();
        dba = new DatabaseHandler(getApplicationContext());

        ArrayList<Food> foodsFromDB = dba.getAllFoods();

        int calsValue = dba.getTotalCalories();
        int totalItems = dba.getTotalItmes();

        String formattedCals = Utils.formatNumber(calsValue);
        String formattedItems = Utils.formatNumber(totalItems);

        totalCals.setText("Total Calories:" + "\n" + formattedCals);
        totalFoods.setText("Total Items Consumed:" + "\n" + formattedItems);
//TODO: set above text using R.id.strings.food_items_num

        for (int i=0; i<foodsFromDB.size();i++){
            String name = foodsFromDB.get(i).getFoodName();
            String dateText = foodsFromDB.get(i).getRecordDate();
            int calories = foodsFromDB.get(i).getCalories();
            int foodID = foodsFromDB.get(i).getFoodID();

            Log.v("FOOD IDS",String.valueOf(foodID));

            myFood = new Food();
            myFood.setFoodName(name);
            myFood.setCalories(calories);
            myFood.setRecordDate(dateText);
            myFood.setFoodID(foodID);

            dbFoods.add(myFood);
        }

        dba.close();

        // SET-UP ADAPTER
        foodAdapter = new CustomListviewAdapter(DisplayFoodsActivity.this,R.layout.list_row,dbFoods);
/*           |                                             |                         |             ^- data (dbFoods that we created above)
             |                                             |                         |- resource (xml file we want to inflate)
             |                                             |- activity we need to pass in
             |- instance variable we created at the top of this file
 */
        listView.setAdapter(foodAdapter);
        foodAdapter.notifyDataSetChanged();
    }
}
