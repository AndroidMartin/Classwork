package com.armco.amarted.notes.ClassesMethods.OLD;

    //  ****  SEE exBall_Main.java FOR THE Main.java THAT GOES WITH THIS SCRIPT  ****

 /*
Classes are cookie-cutters for objects - creates the blueprint for creating objects

Public - anyone can access
Private - Only accessed within the class
Protected - can be used in the same package or derived class
 */

    // EVERY CLASS NEEDS INSTANCE VARIABLES, BEHAVIORS, & CONSTRUCTORS - GOOD TO SET ALL 4 SECTIONS
    public class Ball {

        // Properties or "Instance Variables" - "What can properties does a ball have?"
        private String color;
        private String name;
        private int capacity;
        private int bounceRate;


        //Getters & Setters - Right Click + Generate (highlight variables above then right click)
        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

        public int getBounceRate() {
            return bounceRate;
        }

        public void setBounceRate(int bounceRate) {
            this.bounceRate = bounceRate;
        }


        //Behaviors - What can the object do - Can be called from other script

        public void inflate() {
            System.out.println("Pumping up the ball...");
        }

        public void bounce() {
            System.out.println("Throwing and bouncing...");
        }

        public void deflate() {
            System.out.println("Deflating...");
        }

        public void showStats() {
            System.out.println(getName());  // can use getColor in other scripts because it is "public"
            System.out.println(getColor());  // can use any of the 'get' properties elsewhere
            System.out.println(capacity);  // can call these because we're in the same class
            System.out.println(bounceRate);// but can't call them outside of here
            //  Note the differences in colors above and the description ^^^^
        }


        //Constructors - Allows us to construct a proper object - Right Click + Generate (highlight instance variables)

        public Ball() {
        }
        // ^ Default Constructor - allows multiple instances of "Ball" for some reason

        public Ball(String mColor, String mName, int mCapacity, int mBounceRate) {
            color = mColor;
            name = mName;
            capacity = mCapacity;
            bounceRate = mBounceRate;

            //IMPORTANT: the variables being passed in (the ones in parenthesis MUST be different than the instance variables, hence the "m" before)
        }

        public Ball(String mColor, String mName) {
            color = mColor;
            name = mName;
        }
        //  ^ Can call in another instance of the same name ONLY because it has a different number of parameters/variables (only color and name)



    /* EVERY CLASS THEN GETS CALLED IN THE MAIN.JAVA SCRIPT

    IN MAIN (ORIGINAL):
        public static void main(String[] args) {
            Ball myBall = new Ball();

            myBall.color = "Blue"'
            myBall.name = "Basketball"
            myBall.capacity = 40
            myBall.bounceRate = 2
    The code eventually get's cleaned up to what is currently in exBall_Main.java
     */
    }
