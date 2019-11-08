package com.armco.amarted.notes.ClassesMethods;

import javax.xml.crypto.Data;

public class ClassesMethods {

/*   Methods are enclosed statements that perform an operation - found within classes

      --- IN A NUTSHELL ---

       Classes can contain:
        1. Data (Variables) - State
        2. Methods (Subroutines) - Behavior...

        Instance variables = data or "state"

        variables are called directly
            person2.name = "Joe Bloggs";
            person2.age = 37
        methods always require '()'
            person2.speak();   <---This would run everything in the 'method' "speak" - perhaps:   System.out.println("My name is " + name + ", and I am " + age + " years old.");
            person2.getOlder();   <---in this 'method' you could put:   age = age + 10;

            My name is Mike Power and I am 37 years old.
            [unseen, Mike would then become 47 years old because of the "getOlder" method adding 10 to his age]

Classes - Blueprint of objects (need properties - see Ball.java)
Methods - Enclosed statements that perform an operation (generally return a value)


         === Usage ===
    public static void myName() {}
   [access] [instance] [return type] [name]([parameters]) {[code block]}
 (PubProtPriv)         (int, string)        (variables)


 public static void main(String[] args)
   1     2     3    4      5      6
1) Access Permissions(public, private, or Protected) - See Ball.java
2) ????
3) Return Type (void= no return; examples: String, Char, Boolean - any variable type)
4) Name (user determines the name of the class or method)
5) Declaration of Variables (e.g. String firstName, boolean iTerm, etc)
6) Values to Pass On (e.g. a:4 b:5)
*** SEE MethodBasics FOR MORE EXAMPLES ***

 */

//       === Basic Method ===
    public static void calculateScore(){
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;
        if (gameOver){
            int finalScore = score + (levelCompleted *bonus);
            finalScore += 2000;
            System.out.println("Your final score was " + finalScore);
        }
    }
//      calculateScore2();  <--- Example of how it's called



//       === Passing Arguments ===
    //  Here we add parameters to the method by creating variables in the '()'
    //  When calling methods of this type, we must provide the values for the each.
    public static void calculateScore2(boolean gameOver, int score, int levelCompleted, int bonus){
        if (gameOver){
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            System.out.println("Your final score was " + finalScore);
        }
    }
//      calculateScore2(true, 800, 5, 100);  <--- Example of how it's called
//      calculateScore2(var1, var2, var3, var4);  <-- can use variables of same type or literal values



//       === Returning Arguments ===
    //  When needing your method to provide you data (or "return a value"), we change the "void"
    //  part in our previous examples to the type of variable being returned.  By combining
    //  "Returning Arguments" with "Passing Arguments," we can now input some data, manipulate
    //  it, and return a different value.
    public static int calculateScore3(boolean isGameOver, int lastScore, int highestLevelCompleted, int bonus){
        if (isGameOver){
            int finalScore = lastScore + (highestLevelCompleted * bonus);
            finalScore += 2000;
            System.out.println("Your final score was " + finalScore);
            return finalScore;
        }
        return -1;
    }
//      calculateScore3(true, 800, 5, 100);  <--- Example of how it's called
//      int newHighScore = calculateScore3(true, 800, 5, 100);    <-- Variables can be assigned the return value

/*      When using an IDE (IntelliJ or AndroidStudio), they will usually suggest which variable you are calling as
        you type.  They will denote the name with the following:
        p = Parameter
        f = Field (variable)
        m = Method
        c = Class
        i = ???
        lighteningBolt = ???

        If it has a lock next to it, it is showing if it is "private" (locked) or "public" (unlocked)
 */


//       === CONSTRUCTORS ===
/*
        Allow you to build your own objects and variable types.  See examples in the "Constructors" package directory.
 */
}
