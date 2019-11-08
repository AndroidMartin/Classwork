package com.armco.amarted.notes.ClassesMethods;

public class CarMain {
    public static void callCarMain(){
        Car porsche = new Car();    // <--Defines and initializes new "Car" object called "porsche" - "Constructor"
        Car holden = new Car();    // <--"Holden" is a popular Aussie car brand - it's another "Car" object


        porsche.model = "Carrera";  // <--Because 'model' variable is 'public' we can call it directly [BAD PRACTICE]

        //  It's better to keep variables "private" and use methods to call them -> See method in Car.java
        porsche.setEngine("V8"); // <--calls the method we created in Car.java to "set" the variable
        porsche.setColor("Yellow");

        System.out.println("Engine is " + porsche.getEngine());  // <--"Gets" the info from Car object 'porsche' - (this.model)
        System.out.println("Color is " + porsche.getColor());

    }
}
