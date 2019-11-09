package com.amarted.grocerylist.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.amarted.grocerylist.Model.Grocery;
import com.amarted.grocerylist.Util.Constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/*
 *   Database Handler will contain all the scripts to handle our database.
 *   First, it extends the SQLite Helper into this .java file.
 *   Then it creates the database and sets up future upgrades.
 *   We then add all the CRUD functions (create, read, update, delete).
 *   You can call any of these commands using
 */


public class DatabaseHandler extends SQLiteOpenHelper {
    private Context ctx;
    public DatabaseHandler(Context context) {
        super(context, Constants.DB_NAME,null,Constants.DB_VERSION);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {

        // Create actual DB - written in SQL
        String CREATE_GROCERY_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY," + Constants.KEY_GROCERY_ITEM + " TEXT,"
                + Constants.KEY_QTY + " TEXT,"
                + Constants.KEY_DATE_NAME + " LONG);";
        // ^- "CREATE TABLE table_name(key_id INTEGER PRIMARY KEY,key_grocery_item TEXT,key_qty TEXT,key_date_name LONG);"

        myDB.execSQL(CREATE_GROCERY_TABLE);
    }

    // To allow upgrades made to the table
    @Override
    public void onUpgrade(SQLiteDatabase myDB, int oldVersion, int newVersion) {

        myDB.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        onCreate(myDB);
    }



    /*
     *  CRUD OPERATIONS: Create, Read, Update, Delete Methods
     */

    // Add Grocery - CREATE
    public void addGrocery (Grocery grocery) {
        // setup database instance - Writable
        SQLiteDatabase myDB = this.getWritableDatabase();

        // content values - hash-map pairs
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_GROCERY_ITEM,grocery.getName());
        values.put(Constants.KEY_QTY,grocery.getQuantity());
        values.put(Constants.KEY_DATE_NAME,java.lang.System.currentTimeMillis());

        // Insert the Row
        myDB.insert(Constants.TABLE_NAME,null,values);
        Log.d("Saved", "Saved to DB!!!");
    }

    // Get a Grocery Item - READ
    public Grocery getGrocery (int id) {
        // setup database instance - Writable
        SQLiteDatabase myDB = this.getWritableDatabase();

        Cursor cursor = myDB.query(Constants.TABLE_NAME,
                new String[] {Constants.KEY_ID, Constants.KEY_GROCERY_ITEM, Constants.KEY_QTY, Constants.KEY_DATE_NAME},
                Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
            Grocery grocery = new Grocery();
            grocery.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
            grocery.setName(cursor.getString(cursor.getColumnIndex(Constants.KEY_GROCERY_ITEM)));
            grocery.setQuantity(cursor.getString(cursor.getColumnIndex(Constants.KEY_QTY)));

            //convert the system time stamp to date/time format
            java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
            String formattedDate = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.KEY_DATE_NAME))).getTime());
            grocery.setDateItemAdded(formattedDate);

        return grocery;
    }

    //Get all Groceries - READ
    public List<Grocery> getAllGroceries(){
        // setup database instance - Readable
        SQLiteDatabase myDB = this.getReadableDatabase();
        List<Grocery> groceryList = new ArrayList<>();

        // create cursor
        Cursor cursor = myDB.query(Constants.TABLE_NAME, new String[] {
                        Constants.KEY_ID,Constants.KEY_GROCERY_ITEM,Constants.KEY_QTY,Constants.KEY_DATE_NAME},
                null,null,null,null,Constants.KEY_DATE_NAME + " DESC"); // <- "DESC" = 'Descending'
        // ^ QUERY(table_name,columns to select, selection?, selection arguments?, groupBy Column, having?, orderBy Column)

        if (cursor.moveToFirst()){  // <- if there's data in the first row...
            do {
                // create another grocery object
                Grocery grocery = new Grocery();
                grocery.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(Constants.KEY_ID))));
                grocery.setName(cursor.getString(cursor.getColumnIndex(Constants.KEY_GROCERY_ITEM)));
                grocery.setQuantity(cursor.getString(cursor.getColumnIndex(Constants.KEY_QTY)));
                //convert timestamp to something readable
                java.text.DateFormat dateFormat = java.text.DateFormat.getDateInstance();
                String formatedDate = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.KEY_DATE_NAME))).getTime());
                grocery.setDateItemAdded(formatedDate);
                //add to the groceryList
                groceryList.add(grocery);
            }while (cursor.moveToNext());  // <- there is data in the next line
        }

        return groceryList;
    }

    //Update Grocery Item - UPDATE
    public int updateGrocery(Grocery grocery){
        // get the DB and make sure it's writable
        SQLiteDatabase myDB = this.getWritableDatabase();
        //populate values of grocery item
        ContentValues values = new ContentValues();
        values.put(Constants.KEY_GROCERY_ITEM,grocery.getName());
        values.put(Constants.KEY_QTY,grocery.getQuantity());
        values.put(Constants.KEY_DATE_NAME,java.lang.System.currentTimeMillis());
        //update row with new values
        return myDB.update(Constants.TABLE_NAME,values,Constants.KEY_ID + "=?",new String[]{String.valueOf(grocery.getId())});
    }

    //Delete Grocery Item - DELETE
    public void deleteGrocery(int id) {
        // setup database instance - Writable
        SQLiteDatabase myDB = this.getWritableDatabase();
        myDB.delete(Constants.TABLE_NAME,Constants.KEY_ID + "=?",
                new String[] {String.valueOf(id)});
        myDB.close();
    }

    //Get List Length
    public int getCount() {
        // create string variable to pass SQL query on
        String countQuery = "SELECT * FROM " + Constants.TABLE_NAME;
        // setup database instance - Readable
        SQLiteDatabase myDB = this.getReadableDatabase();
        // select data to be counted
        Cursor cursor = myDB.rawQuery(countQuery,null);
                           // ^- rawQuery(SELECT * FROM table_name,null)
        // return count of selection ("cusor")
        return cursor.getCount();
    }
}
