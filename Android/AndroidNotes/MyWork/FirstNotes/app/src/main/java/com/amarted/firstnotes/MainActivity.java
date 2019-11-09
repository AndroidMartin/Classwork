package com.amarted.firstnotes;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

/* GENERAL NOTES
  An "Activity" is simply a user's view (what's displayed on the screen)
*/

//Declare Variables
    private Button mButton;
    private TextView mTextView;
    private EditText mEditText;
    //Change Text


    //Set other variables
    boolean textChanger = false;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare your variables and connect to objects in Activity
        mButton = (Button) findViewById(R.id.mButton);
        mTextView = (TextView) findViewById(R.id.mTextView);
        mEditText = (EditText) findViewById(R.id.editText);

        //change title of the button
        mButton.setText(R.string.button_name);
        //Change visibility of text
        mTextView.setVisibility(1);


        //Attach a listener for the button
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String enteredText;
                //the .toString() tells the script to parse the value into a string
                enteredText = mEditText.getText().toString();

                mTextView.setVisibility(View.VISIBLE);
                //To display the text, you can use two formats
                //This makes the string value from the strings.xml page
                mTextView.setText(R.string.show_text);
                //this makes the string be the entered text from the text box
                mTextView.setText(enteredText);
                //change other properties
                mTextView.setTextColor();
            }
        });





    }
/*
    public void ShowMe(View view){
        mTextView.setVisibility(View.VISIBLE);
        mTextView.setText(R.string.show_text);


        boolean textChanger = false;

        if (textChanger = true) {
            mTextView.setText(R.string.show_text);
            textChanger = false;
        } else {
            mTextView.setText(R.string.noShow_text);
            textChanger = true;
        }
    }
    */
}
