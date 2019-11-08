package com.armco.amarted.notes.Inheritance;

public class Car extends Vehicle{
//    public int currentGear;
//
//    public Car(int speed, int currentGear) {
//        super(1, speed);
//        this.currentGear = currentGear;
//    }
//
//    public void changeGear(int gear){
//        setCurrentGear(gear);
//    }
//
//    public int getCurrentGear() {
//        return currentGear;
//    }
//
//    public void setCurrentGear(int currentGear) {
//        this.currentGear = currentGear;
//    }

    private int wheels;
    private int doors;
    private int gears;
    private boolean isManual;
    private int currentGear;

    public Car(String name, String size, int wheels, int doors, int gears, boolean isManual) {
        super(name, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.isManual = isManual;
        this.currentGear = 1;
    }

    public void changeGear(int currentGear) {
        this.currentGear = currentGear;
        System.out.println("Car.setCurrentGear(): Changed to " + this.currentGear + " gear.");
    }

    public void changeVelocity(int speed, int direction){
        System.out.println("Car.changeVelocity(): Heading " + direction + " degrees at " + speed + "mph.");
        move(speed,direction);
    }



}
