package com.armco.amarted.notes.Inheritance;

public class Animal {
    // The things ALL animals have
    private String name;
    private int brain;
    private int body;
    private int size;
    private int weight;


    // Constructors to make new objects of type Animal
    public Animal() {
        this("Unknown",-1,-1,-1,-1);
    }

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name = name;
        this.brain = brain;
        this.body = body;
        this.size = size;
        this.weight = weight;
    }

    // Methods to create behaviors that ALL animals have
    public void eat(){
        // add code here to make behavior
        System.out.println("The animal is enjoying a feast");
    }

    public void move(int speed){
        // add code here to make behavior
        System.out.println("Animal.move() called...");
        System.out.println("Animal is moving at " + speed + "mph");
    }



    // GETTERS FOR THE PROPERTIES (variables)
    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
}
