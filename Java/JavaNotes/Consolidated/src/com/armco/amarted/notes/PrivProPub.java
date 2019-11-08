package com.armco.amarted.notes;

public class PrivProPub {

//        ===== PUBLIC, PROTECTED, and PRIVATE USAGES =====

/*
 *     Public can be accessed anywhere in your project.
 *     However, it is bad practice to make all your variables public, as it could cause problems.
 *     Instead, it's better to encapsulate them within your methods.
 */
    public String name;

    /*
     *      Public can be accessed anywhere in your project - but only with read privileges.
     *      Making something "final" and/or "static" is acceptable practice, because that variable
     *      cannot be manipulated elsewhere, only through the method.
     */
    public final static int ID = 8;

    /*
     *      Protected variables can be accessed within the class AND child classes.
     *      Can also be accessed within the same package.  However, it is not accessible globally.
     */
    protected String size;

    /*
     *      Private can ONLY be accessed within the same class.
     */
    private String type;

    /*
     *      If nothing is specified, the variable is accessible ONLY within the same package.
     *      Regardless if another class extends (is a child class), it must be in the same package to see it.
     */
    int height;


    // EXAMPLE USE CASES (using variables declared above)

    public void Plant(){
        name = "Peter";
        // ID = 7; //<-- Not working because it is "final" - meaning it cannot be reassigned
        //TODO: Uncomment the above line to see error ^^^^
        this.size = "large";
        type = "Tree";  //<-- Only working because we're in the same class as the declared variable
        height = 10;
    }

    /*
     *      public --- from anywhere
     *      protected --- same class, subclass, and package
     *      private --- only within same class
     *      no modifier --- same package only
     *
     *      Only one "Public" class can be in each java file and must have the same name as the file
     *          e.g. In Plant.java you can have 'public class Plant (){}' but not any more public classes OR
     *               you couldn't make it 'private class Plant (){}'.  But you can choose to use no modifier.
     */

}
