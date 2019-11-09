package com.amarted.petbio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BioActivity extends AppCompatActivity {
    private ImageView petImageView;
    private TextView petName;
    private TextView petBio;
    private Bundle extras;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);

    /*  THE FOLLOWING WAS AUTO-GENERATED AND I'M NOT SURE IT SHOULD HAVE BEEN

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    */
        petImageView = findViewById(R.id.petImageViewID);
        petName = findViewById(R.id.nameID);
        petBio = findViewById(R.id.bioTextID);

        extras = getIntent().getExtras();
        if (extras !=null) {
            String name = extras.getString("name");
            String bio = extras.getString("bio");

            setUp(name,bio);
        }
    }

    public void setUp(String name, String bio) {
        if (name.equals("Rogue")) {
            //Show dog stuff
            petImageView.setImageDrawable(getResources().getDrawable(R.drawable.dog_rogue));
            petName.setText(name);
            petBio.setText(bio);
        } else if (name.equals("Jarvis")) {
            //Show cat Stuff
            petImageView.setImageDrawable(getResources().getDrawable(R.drawable.cat_girl));
            petName.setText(name);
            petBio.setText(bio);

        }

    }
}
