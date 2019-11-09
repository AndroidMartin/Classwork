package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.Contact;
import Utils.Util;

public class DatabaseHandler extends SQLiteOpenHelper {

    // CREATE CONSTRUCTORS

 // public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {   <--original line
    public DatabaseHandler(Context context) {
        super(context, Util.DATABASE_NAME,null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SQL - Structured Query Language  <- not cap sensitive, but best in caps for organization
        String CREATE_CONTACT_TABLE = "CREATE TABLE " + Util.TABLE_NAME + "("
                + Util.KEY_ID + " INTEGER PRIMARY KEY," + Util.KEY_NAME + " TEXT,"
                + Util.KEY_PHONE_NUMBER + " TEXT" + ")";
        // Final SQL command: "CREATE TABLE [table_name]([key_id] INTEGER PRIMARY KEY,[key_name] TEXT,[key_phone_number] TEXT)"
        //                    "CREATE TABLE CONTACTS(id INTEGER PRIMARY KEY, name TEXT, phone_number TEXT)"
        //                    "CREATE TABLE table_name(col1 [type], col2 [type], col3 [type], ...)"

        // EXECUTE THE SQL SCRIPT
        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // DELETE OLD TABLE
        db.execSQL("DROP TABLE IF EXISTS "+ Util.TABLE_NAME);
        // CREATE TABLE AGAIN
        onCreate(db);
    }

    /*
     *  CRUD Operations - Create, Read, Update, Delete
     */

    //Add a Contact - addContact Method
    public void addContact(Contact contact) {
        //give permissions to write to database
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues value = new ContentValues();
        value.put(Util.KEY_NAME, contact.getName());
        value.put(Util.KEY_PHONE_NUMBER, contact.getPhoneNumber());
        // ID column is automatically generated (like row numbers in a spreadsheet)

        //Insert to row
        db.insert(Util.TABLE_NAME,null,value);
        db.close(); //close db connection
    }

    //Get a Contact - getContact Method
    public Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        //Cursor (what to select) [variable] = db.query(TABLE,COL+,ROW'=?'ID,GROUPby,HAVING?,ORDERby,LIMIT?) <-Don't forget the "=?" to determine ID column
        Cursor myCursor = db.query(Util.TABLE_NAME, new String[]{Util.KEY_ID,Util.KEY_NAME,Util.KEY_PHONE_NUMBER},
                Util.KEY_ID + "=?", new String[]{String.valueOf(id)},null,null,null,null);

        if (myCursor != null) {
            myCursor.moveToFirst();
        }

        //create instance of a contact, an actual contact object
        Contact myContact = new Contact(Integer.parseInt(myCursor.getString(0)),myCursor.getString(1),myCursor.getString(2));
        return myContact;
    }

    //Get all contacts
    public List<Contact> getAllContacts(){
        SQLiteDatabase db = this.getReadableDatabase();

        //Create an Array list
        List<Contact> contactList = new ArrayList<>();

        //Create query to select all contacts - in SQL Code
        String selectAll = "SELECT * FROM " + Util.TABLE_NAME;
        Cursor myCursor = db.rawQuery(selectAll,null);

        //Loop through our contacts
        if (myCursor.moveToFirst()){
            do {
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(myCursor.getString(0)));
                contact.setName(myCursor.getString(1));
                contact.setPhoneNumber(myCursor.getString(2));

                //add contact object to our contact list
                contactList.add(contact);

            }while (myCursor.moveToNext());
        }

        //Return selection as final action of getAllContacts Method
        return contactList;
    }

    //Update Contacts
    public int updateContact (Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_NAME,contact.getName());
        values.put(Util.KEY_PHONE_NUMBER,contact.getPhoneNumber());

        //update row
        return db.update(Util.TABLE_NAME,values,Util.KEY_ID+"=?",
                new String[] {String.valueOf(contact.getId())});
    }

    //Delete single Contact
    public int deleteContact (Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME,Util.KEY_ID+"=?",
                new String[] {String.valueOf(contact.getId())});
        db.close();
    }

}
