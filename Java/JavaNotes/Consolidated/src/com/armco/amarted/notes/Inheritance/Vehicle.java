package com.armco.amarted.notes.Inheritance;

public class Vehicle {

//    // MY SOLUTION
//    private int steeringType;
//    private int speed;
//
//    public Vehicle(int steeringType, int speed) {
//        this.steeringType = steeringType;
//        this.speed = speed;
//    }
//
//    public int getSteeringType() {
//        return steeringType;
//    }
//
//    public void setSteeringType(int steeringType) {
//        this.steeringType = steeringType;
//    }
//
//    public int getSpeed() {
//        return speed;
//    }
//
//    public void setSpeed(int speed) {
//        this.speed = speed;
//    }

    // INSTRUCTOR SOLUTION
    private String name;
    private String size;
    private int currentVelocity;
    private int currentDirection;

    public Vehicle(String name, String size){
        this.name = name;
        this.size = size;
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction){
        this.currentDirection += direction;
        System.out.println("Vehicle.steer(): Steering at " + currentDirection + " degrees.");
    }

    public void move(int velocity, int direction){
        this.currentVelocity = velocity;
        this.currentDirection = direction;
        System.out.println(this.name + " now heading " + direction + " degrees at a speed of " + velocity + "mph.");
        System.out.println("     [using Vehicle.move()]");
    }

    public void stop(){
        this.currentVelocity = 0;
        System.out.println("Vehicle.stop(): " + this.name + " has come to a stop.");
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}
