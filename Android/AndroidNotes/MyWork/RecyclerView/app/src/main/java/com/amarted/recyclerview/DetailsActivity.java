package com.amarted.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    // Declare multiple variables of the same type
    private TextView name, description, rating;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        //Instantiate Variables

        extras = getIntent().getExtras();

        name = findViewById(R.id.dNameID);
        description = findViewById(R.id.dDescriptionID);
        rating = findViewById(R.id.dRatingID);

        if (extras != null) {
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
            rating.setText(extras.getString("rating"));
        }
    }
}
