package com.amarted.databaseintro;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import Data.DatabaseHandler;
import Model.Contact;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // INSTANTIATE DATABASE HANDLER CLASS FROM "DatabaseHandler.java"
        DatabaseHandler db = new DatabaseHandler(this);

        // INSERT CONTACTS
        Log.d("Insert: ", "Inserting...");
        db.addContact(new Contact("Drew","857-222-6495"));
        db.addContact(new Contact("Jenn","617-913-1585"));
        db.addContact(new Contact("Leo","???"));
        db.addContact(new Contact("Bella", "???"));


        // READ THEM BACK
        Log.d("Reading: ","Reading all contacts...");
        List<Contact> contactList = db.getAllContacts();
              // Get 1 contact - third one
        Contact oneContact = db.getContact(3);

        // UPDATE CONTAACTS
        int newContact = db.updateContact(oneContact);


        Log.d("One Contact", "("+oneContact.getId()+") Name: "+oneContact.getName()+" | "+oneContact.getPhoneNumber());
             // Get ALL contacts
        for (Contact c : contactList) {
            String log = "ID: " + c.getId() + ", Name: " + c.getName() + ", Phone Number: " + c.getPhoneNumber();
            Log.d("Contact", log);
        }
    }

}
