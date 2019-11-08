package com.amarted.grocerylist.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.amarted.grocerylist.R;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {
    // Declare instance variables
    private TextView itemName;
    private TextView itemQty;
    private TextView itemDate;
    private TextView itemDetails;
    private int itemID;
    private Button editButton;
    private Button deleteButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Instantiate your variables
        itemName = findViewById(R.id.itemNameDetailsID);
        itemQty = findViewById(R.id.itemQtyDetailsID);
        itemDate = findViewById(R.id.itemDateAddedDetailsID);
        itemDetails = findViewById(R.id.itemExtraDetailsID);
        editButton = findViewById(R.id.editButtonDetailsID);
        deleteButton = findViewById(R.id.deleteButtonID);

        // Fetch Database information
        Bundle bundle = getIntent().getExtras(); // <- Extras are added in RecyclerViewAdapter.java
        if (bundle != null) {
            itemName.setText(bundle.getString("name")); // <- comes from RecyclerViewAdapter.java
            itemQty.setText(bundle.getString("qty"));
            itemDate.setText(bundle.getString("date"));
            itemID = bundle.getInt("id");
        }
    }
}
