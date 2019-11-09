package com.amarted.grocerylist.Util;

/*
 *   This file holds all our constant variables so that we can call the variables in our scripts
 *   and have the ability to only have to change the values in one place, here!
 *   This is why it's important to make sure the variables are set to:
 *      public - allows it to be called from anywhere (Class.Variable) - e.g. Constant.KEY_QTY
 *      static - ?? means it will not be changed anywhere else (read-only)
 *      final - ? this allows it to be called out of class ?
 *      [type] - declare the type of variable (String, long, int, float, etc.)
 *      [variable name] - IN ALL CAPS BECAUSE IT'S GLOBAL ??
 *      [value] - set the value to what is appropriate
 */

public class Constants {

    // set the table properties
    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "groceryListDB";
    public static final String TABLE_NAME = "groceryTBL";

    // create table column headers
    public static final String KEY_ID = "id";
    public static final String KEY_GROCERY_ITEM = "Item";
    public static final String KEY_QTY = "Qty";
    public static final String KEY_DATE_NAME = "date_added";
}
