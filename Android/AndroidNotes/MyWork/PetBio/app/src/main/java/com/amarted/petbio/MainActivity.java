package com.amarted.petbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

//NOTE: There is a change in the next line in order to call a global onClickListener
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView dogView;
    private ImageView catView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogView = findViewById(R.id.dogImageView);
        catView = findViewById(R.id.catImageViewID);

        /* OLD WAY OF SETTING LISTENERS - NEW WAY INCLUDES THE CHANGE IN THE FIRST LINE
        dogView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Dog Selected", Toast.LENGTH_SHORT).show();
            }
        });

        catView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Cat Touched", Toast.LENGTH_SHORT).show();
            }
        });
*/
        catView.setOnClickListener(this);
        dogView.setOnClickListener(this);

    }

    // This is what is generated from the code in the first line - after "implementing method" from lightbulb
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.catImageViewID:
                //go to second activity
                Intent catIntent = new Intent(MainActivity.this,BioActivity.class);
                catIntent.putExtra("name", "Jarvis");
                catIntent.putExtra("bio","Great cat. Loves people. Meows a LOT!");
                startActivity(catIntent);
            //    Toast.makeText(MainActivity.this,"Cat Touched", Toast.LENGTH_SHORT).show();
                break;

            case R.id.dogImageView:
                //go to second activity
                Intent dogIntent = new Intent(MainActivity.this,BioActivity.class);
                dogIntent.putExtra("name", "Rogue");
                dogIntent.putExtra("bio","Gentle dog. Great around strangers. Enjoys giving kisses! Sometimes bleeds on your sheets...");
                startActivity(dogIntent);
            //    Toast.makeText(MainActivity.this, "Dog Selected", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
