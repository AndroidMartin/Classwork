package com.amarted.grocerylist.Model;

/*
 *   This file is what we use to create each 'grocery item' as an object.
 *   It provides all the necessary code to generate the data required to populate our database.
 */


public class Grocery {
    // DECLARE ALL THE VARIABLES (each column in our database)
    private String name;
    private String quantity;
    private String dateItemAdded;
    private int id;

    // CREATE AN EMPTY CONSTRUCTOR
    public Grocery() {
    }

    // CREATE REAL CONSTRUCTOR - Right Click -> Generate...  |  (alt+insert)
    public Grocery(String name, String quantity, String dateItemAdded, int id) {
        this.name = name;
        this.quantity = quantity;
        this.dateItemAdded = dateItemAdded;
        this.id = id;
    }

    // CREATE GETTERS & SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDateItemAdded() {
        return dateItemAdded;
    }

    public void setDateItemAdded(String dateItemAdded) {
        this.dateItemAdded = dateItemAdded;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
