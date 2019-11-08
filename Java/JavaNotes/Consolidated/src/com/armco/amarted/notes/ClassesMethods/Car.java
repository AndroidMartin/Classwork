package com.armco.amarted.notes.ClassesMethods;

public class Car {

    // Define your variables
    private int doors;
    private int wheels;
    public String model;  // <--NOTE: this is public and can be accessed directly from CarMain.java
    private String engine;  // <--The usage of "this" as described below relates to THIS variable
    private String color;

    // Method to create "Car Object" - update the blueprint/model - SETTERS AND GETTERS
    public void setModel(String model){  // (calls on "public" variable - not good practice)
        this.model = model;  // <--"this" is used to denote the variable in the class, not the parameter
    }
    public void setEngine(String engine){  // (calls on "private" variable, but allows access through this method)
        this.engine = engine;  // <--"this" is used to denote the variable in the class, not the parameter
    }

    public String getEngine(){  // <--how to "recall" the information after it has been set
        return this.engine;
    }

    // Setting Validation
    public void setColor(String color){
        String validColor = color.toLowerCase();  // <--Validation of sorts; converts whatever is entered to lowercase
        if(validColor.equals("blue") || validColor.equals("red")){  // <--does something if the color is red or blue
            this.color = color;
        } else {
            this.color = "Unknown";
        }
    }
    public String getColor(){
        return this.color;
    }

}
