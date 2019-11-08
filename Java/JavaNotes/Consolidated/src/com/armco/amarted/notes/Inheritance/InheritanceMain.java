package com.armco.amarted.notes.Inheritance;

public class InheritanceMain {

    public static void callMain(){

    Animal myAnimal = new Animal("Animal",1,1,5,5);  // <-- Creating a base animal

    Dog myDog = new Dog("Yorkie",8,20,2,4,1,20,"long silky");
    myDog.eat();
    myDog.walk();
    myDog.run();



    }
}
