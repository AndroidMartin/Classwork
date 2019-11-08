package com.armco.amarted.notes.ClassesMethods.OLD;

public class ExBall_Main {
    //public static void main(String[] args) {
    public static void exBallMain(){
        // write your code here

///*

        //INPUT

        Ball orgBall = new Ball("blue","Original Ball",12,45);
        //Manually Set ^   (can't do bottom example, must pass variables into that class)
        Ball myBall = new Ball("Green","Bocce");
        //Manually Set w/ Different Constructor ^
        /* Equivalent to:
        Ball myOtherBall = new Ball();
        myBall.color = "blue";
        myBall.name = "racquetball";
          ^ Doesn't work because variables are 'private' - but idea is the same
        */

        //Set Dynamically
        Ball foosball = new Ball();

        foosball.setName("Foosball");
        foosball.setColor("White");
        foosball.setCapacity(4);
        foosball.setBounceRate(2);

        //Child Class
        BasketBall basketBall = new BasketBall();
        basketBall.setColor("Red");


        //Outputs
        foosball.inflate();
        foosball.bounce();
        foosball.deflate();
        System.out.println("");

        orgBall.showStats();
        System.out.println("");
        myBall.showStats();
        System.out.println("");
        foosball.showStats();
        System.out.println(foosball.getName() + ", " + foosball.getColor() + ", " + foosball.getCapacity() + ", " + foosball.getBounceRate());
//*/
/*

     **** STRINGBUILDER COMMAND - A BETTER WAY TO BUILD OUTPUT STRINGS AND SUCH
     * Put in Main.java:

        StringBuilder sampleString = new StringBuilder();
        sampleString.append("Life");
        sampleString.append(" is great");
        sampleString.append(" when you are happy!");

        sampleString.delete(1,2);

        System.out.println(sampleString);
        System.out.println("The above string is " + sampleString.capacity() + "characters long");

        LOOK UP OTHER COMMANDS BY SEARCHING FOR THE "JAVA CLASS LIBRARY"
*/

    }
}
