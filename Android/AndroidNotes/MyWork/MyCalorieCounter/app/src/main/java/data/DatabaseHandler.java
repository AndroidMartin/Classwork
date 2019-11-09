package data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.Food;

/*
             This file is what will contain your CRUD functions (Create, Read, Update, Delete)
 */




public class DatabaseHandler extends SQLiteOpenHelper {

    // CREATE INSTANCE VARIABLES
    private final ArrayList<Food> foodList = new ArrayList<>();

    //Constructor
    public DatabaseHandler(Context context){
        super(context,Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        /*
         *               CREATE YOUR TABLE - in SQL language [all caps]!!!
         * "CREATE TABLE tableName(keyCol type PRIMARY KEY, colName ColType, ColName ColType...);"
         *       the first line of executable code below would be translated to the following:
         * String CREATE_TABLE = CREATE TABLE food_tbl(id INTEGER PRIMARY KEY, name TEXT, calories INT, record_date LONG);
         */
        String CREATE_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + "(" + Constants.KEY_ID + " INTEGER PRIMARY KEY, " + Constants.FOOD_NAME + " TEXT, " +
                Constants.FOOD_CALORIES_NAME + " INT, " + Constants.DATE_NAME + " LONG);";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //delete old table
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TABLE_NAME);
        //create a new one
        onCreate(db);
    }


    /*
    ***      CRUD OPERATIONS GO HERE AND ARE CALLABLE THROUGHOUT THE APPLICATION
     */

    /*
             *** Step 1 - CREATE (Crud) ***
     */

    public void addFood(Food food){
        //instantiate the database as writable
        SQLiteDatabase dba = this.getWritableDatabase();
        //call "content values" type variable named 'values' and set to new "content values" method
        ContentValues values = new ContentValues();
        values.put(Constants.FOOD_NAME,food.getFoodName());
        values.put(Constants.FOOD_CALORIES_NAME,food.getCalories());
        values.put(Constants.DATE_NAME,System.currentTimeMillis());

        //insert this 'row' of data into our database, calling the variable we created above ('values') with all the content
        dba.insert(Constants.TABLE_NAME,null,values);
        Log.v("+Food Item+", "YES!!!");
        dba.close();
    }



    /*
              *** Step 2 - READ (cRud) ***
     */

    // GET TOTAL ITEMS SAVED
    public int getTotalItmes(){
        //instantiate local variable
        int totalItems = 0;
        //instantiate table as readable
        SQLiteDatabase dba = this.getReadableDatabase();
        //'highlight' whole table
        String query = "SELECT * FROM " + Constants.TABLE_NAME;
        Cursor cursor = dba.rawQuery(query, null);
        //count how many items are selected (all items)
        totalItems = cursor.getCount();
        //close-out your 'selection' and return what you found
        cursor.close();
        return totalItems;
    }

    // GET TOTAL CALORIES CONSUMED
    public int getTotalCalories(){
        int totalCalories = 0;
        SQLiteDatabase dba = this.getReadableDatabase();
        String query = "SELECT SUM(" + Constants.FOOD_CALORIES_NAME + ") FROM " + Constants.TABLE_NAME;
        //  ^- String query = "SELECT SUM(colCal) FROM tbl_name";
        Cursor cursor = dba.rawQuery(query,null);

        if (cursor.moveToFirst()) {
            totalCalories = cursor.getInt(0);
        }

        dba.close();
        return totalCalories;
    }

    // GET ALL ITEMS IN DATABASE
    public ArrayList<Food> getAllFoods(){
        //clear out any previous instance
        foodList.clear();
        //populate new list by creating a new DB variable containing our database, as a readable type
        SQLiteDatabase dba = this.getReadableDatabase();
        //select the whole table
        Cursor cursor = dba.query(Constants.TABLE_NAME, new String[]{Constants.KEY_ID,Constants.FOOD_NAME,Constants.FOOD_CALORIES_NAME,Constants.DATE_NAME},
                null,null,null,null,Constants.DATE_NAME + " DESC");
        //loop through...
        if (cursor.moveToFirst()) {
            do {
                //instantiate our object
                Food food = new Food();
                //populate fields
                food.setFoodID(cursor.getInt(cursor.getColumnIndex(Constants.KEY_ID)));
                food.setFoodName(cursor.getString(cursor.getColumnIndex(Constants.FOOD_NAME)));
                food.setCalories(cursor.getInt(cursor.getColumnIndex(Constants.FOOD_CALORIES_NAME)));
                //format date correctly
                DateFormat dateFormat = DateFormat.getDateInstance();
                String date = dateFormat.format(new Date(cursor.getLong(cursor.getColumnIndex(Constants.DATE_NAME))).getTime());
                food.setRecordDate(date);
                //pass in our food object
                foodList.add(food);
/*                   ^         ^- what we just created in the if->do statements
                     |- the first variable we created in this script                                */
            }while (cursor.moveToNext());
        }
        //close out your running processes
        cursor.close();
        dba.close();
        //send out our updated list to the GUI
        return foodList;
        //        ^- very first variable we created in this script
    }


    // GET INDIVIDUAL ITEM
    // TODO: code goes here



    /*
              *** Step 3 - UPDATE (crUd) ***
     */

    public void updateItem(){
        SQLiteDatabase dba = this.getWritableDatabase();
        // TODO: update a single item
    }



    /*
              *** Step 4 - DELETE (cruD) ***
     */
    public void deleteItem(int id){
        SQLiteDatabase dba = this.getWritableDatabase();
        dba.delete(Constants.TABLE_NAME,Constants.KEY_ID + "=?",
                new String[]{String.valueOf(id)});
        dba.close();
    }

}
