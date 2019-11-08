package com.amarted.myhoneydolist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        private Button saveButton;
        private EditText enterMessage;

        saveButton = findViewById(R.id.saveButtonID);
        enterMessage = findViewById(R.id.listID);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // make sure input is not empty
                if (enterMessage.getText().toString().equals("")) {

                    String message = enterMessage.getText().toString();
                    writeToFile(message);
                }else {
                    //do nothing for now
                }
            }
        });

        try {
            if (readFromFile() != null) {
                enterMessage.setText(readFromFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    // CREATING CLASSES TO WRITE & READ FROM A TEXT FILE

    // SAVING TO A TEXT FILE
    private void writeToFile(String message) {
        // using "try" & "catch" in-case of errors
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("todolist.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(message);
            outputStreamWriter.close();  // ALWAYS close your streams!!!! <- it free's up system memory

            // In case of errors, it will run the following code
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    // READING FROM A TEXT FILE
    //                               replaces "try & catch" system from above
    //private String readFromFile() throws FileNotFoundException {
    private String readFromFile() throws IOException {
        // create a string to populate
        String result = "";
        // open up the stream - create "inputStream" variable to hold contents
        InputStream inputStream = openFileInput("todolist.txt");
        // if the stream is NOT null, then populate "inputStream"
        if (inputStream != null) {
            // create new stream reader and variable to hold it
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            // buffer reader - creates a bucket for all the bits and to read more effeciently
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // create another temporary variable to build the string
            String tempString = "";
            // start building the string
            StringBuilder stringBuilder = new StringBuilder();
            //  get each line from the reader and put into "tempString"
            while ((tempString = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempString);
            }
            // close everything up
            inputStream.close();//  <= ALWAYS close your streams!!!
            result = stringBuilder.toString();
        }
        return result;
    }
}