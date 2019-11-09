package com.amarted.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyAdapter;
import Model.ListItem;

public class MainActivity extends AppCompatActivity {

    // Define the RecylcerView types
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    // Create the list
    private List<ListItem> listItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewID);
        // Set properties
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Instantiate the list array
        listItems = new ArrayList<>();

        ListItem item1 = new ListItem("Movie 1","It's about someone crazy...","Great");
        ListItem item2 = new ListItem("Movie 2","It's about teenage angst.","Excellent!");
        ListItem item3 = new ListItem("Movie 3","It's about love outside marriage.","Poor");
        ListItem item4 = new ListItem("Movie 4","It's a kids' cartoon about zebras.","Poor");


        //create a loop to add things into the list
        for (int k = 0; k<1; k++) {
            // Create an actual object - created from ListItem.java
            //    Compile the virtual list
            //ListItem item = new ListItem("Item"+(k+1),"description","Excellent");
            //    Feed into list object via the adapter
            listItems.add(item1);
            listItems.add(item2);
            listItems.add(item3);
            listItems.add(item4);
        }

        // Call our Adapter
        adapter = new MyAdapter(this,listItems);
        recyclerView.setAdapter(adapter);
    }
}
