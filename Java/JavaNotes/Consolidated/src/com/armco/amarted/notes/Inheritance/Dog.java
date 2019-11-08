package com.armco.amarted.notes.Inheritance;

import jdk.swing.interop.SwingInterOpUtils;

public class Dog extends Animal {  // <--Use keyword "extends" to add additional fields
    // Unique characteristics of 'Dogs' in addition to animals
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;


    // CONSTRUCTORS UNIQUE TO DOGS
//    public Dog(String name, int brain, int body, int size, int weight) {
//        super(name, brain, body, size, weight);  // <--Keyword "super" means to call the constructor from the class we are extending (inheriting) from
//    }

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
        super(name, 1, 1, size, weight);  // <--By 'hardcoding' the brain and body we make it so the person inputting info doesn't have to enter this (we know dogs have those)
        this.eyes = eyes;
        this.legs = teeth;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
        //  ^-- We then initialize the additional parameters we created for Dogs
    }

    // METHODS (or behaviors) THAT ARE UNIQUE TO DOGS
    private void chew(){
        System.out.println("Dog.chew() called...");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat() called...");  // <-- lets us know this specific version of "eat" was called
        chew();  // <-- calls the private "chew" method we created above
        super.eat();  // <-- calls the "eat" method from the super-class (Animal.java)
    }


    public void walk(){
        System.out.println("Dog.walk() called...");
        move(4);
    }

    public void run(){
        System.out.println("Dog.run() called...");
        move(8);
    }
}
