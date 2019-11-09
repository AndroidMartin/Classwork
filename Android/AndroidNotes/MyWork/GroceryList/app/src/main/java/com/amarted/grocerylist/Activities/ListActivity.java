package com.amarted.grocerylist.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.amarted.grocerylist.Data.DatabaseHandler;
import com.amarted.grocerylist.Model.Grocery;
import com.amarted.grocerylist.R;
import com.amarted.grocerylist.UI.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

/*
     *      This file populates the list view so we can see all entries
     */


public class ListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private List<Grocery> groceryList;
    private List<Grocery> listItems;
    private DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

            }
        });

        // INSTANTIATE ALL OUR OBJECTS
        db = new DatabaseHandler(this);  // <-- database
        recyclerView = findViewById(R.id.recyclerViewID);  // <-- actual object view
        recyclerView.setHasFixedSize(true);  // <-- adjusts size
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        groceryList = new ArrayList<>();
        listItems = new ArrayList<>();

        // Get items from Database
        groceryList = db.getAllGroceries();

        // create ___
        for (Grocery c : groceryList) {
            Grocery grocery = new Grocery();
            grocery.setName(c.getName());
            grocery.setQuantity("Qty: " + c.getQuantity());
            grocery.setId(c.getId());
            grocery.setDateItemAdded("Added on: " + c.getDateItemAdded());

            listItems.add(grocery);
        }

        recyclerViewAdapter = new RecyclerViewAdapter(this,listItems);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged(); // <-- tells system that a change was made and it should refresh
    }

}
