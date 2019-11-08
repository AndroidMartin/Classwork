package com.amarted.alertdialog;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AlertDialog.Builder alertDialog;
    private Button showDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialog = (Button) findViewById(R.id.showDialogButton);

        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the actual dialog (alert dialog)
                alertDialog = new AlertDialog.Builder(MainActivity.this);

                /*set things up (build the dialog)

                Set the Title
                alertDialog.setTitle(R.string.dialog_title);
                ^^^^^-- Easiest method      Below is the BEST method
                */
                alertDialog.setTitle(getResources().getString(R.string.dialog_title));

                //set icon
                alertDialog.setIcon(android.R.drawable.star_big_on);

                //set message
                alertDialog.setMessage(getResources().getString(R.string.dialog_message));

                //set Cancelable (can the user cancel it?)
                alertDialog.setCancelable(true);

                //Set "positive" button
                alertDialog.setPositiveButton(getResources().getString(R.string.yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //this is where you put what happens when the user says 'yes'
                        MainActivity.this.finish();
                    }
                });

                //set "negative" button
                alertDialog.setNegativeButton(getResources().getString(R.string.no), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                //create dialog message
                AlertDialog dialog = alertDialog.create();

                //show the dialog
                dialog.show();
            }
        });

    }
}
