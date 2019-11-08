package com.armco.amarted.notes;

import com.armco.amarted.homework.Homework;

import java.util.Scanner;

public class IfForWhile {

   //   === IF-STATEMENTS ===
    public static void ifStatement() {
        int score = 6000;
        if (score >= 5000) {
            System.out.println("Your score was above 5000");
        }else if (score < 1000 && score >= 500) {
            System.out.println("Your score was between 500 and 1000");
        } else {
            System.out.println("Your score was < 500");
        }
    }

    //  Don't forget you can also use logical operators (e.g. "and, or, not")
    public static void ifLogicalOperators() {
        int age = 38;
        int sex = 2;
        if ((age > 35 && sex != 0) || ((sex == 2) && ((age >= 18) && (age <= 40)))) {
            //       "and"  "not" "or"           "and"           "and"
            System.out.println("It's a match!");
        }
    }


    //    You want to limit the number of return statements, so look at how the first example
    //    is refactored into the second.

    public static int badReturnStatements(){
        int playerScore = 1300;
        if (playerScore >= 100){
            return 1;
        } else if (playerScore >= 500) {
            return 2;
        } else if (playerScore>=100) {
            return 3;
        }
        return 4;
    }

    public static int goodReturnStatements(){
        int playerScore = 1300;
        int position = 4;  // assuming position 4 will be returned - if none of the other conditions are met it won't change
        if(playerScore >= 100){
            position = 1;
        } else if (playerScore >= 500) {
            position = 2;
        } else if (playerScore>=100) {
            position = 3;
        }
        return position;  // Now there is only one "return" call
    }


   //   === TERNARY OPERATIONS - EXPRESS IF-STATEMENTS ===
    public static void ternaryExample() {
        int ageOfClient = 20;
        boolean isEighteenOrOver = (ageOfClient >= 18) ? true : false;
/*         <variableToBeAssigned> = <condition> ? <valueIfTrue> : <valueIfFalse>;

    The ternary operator is a shortcut to assigning one of two values to a variable depending on a given condition.
    Essentially, it's a shortcut of the if-then-else statement
 */
    }



   //   === 'FOR'-'WHILE'-'DO' LOOPS ===

    // For Loop - cycles through while a condition is met
    public static void forLoop() {
        System.out.println("For Loop:");

    //  for ([initialization]; [termination]; [increment])  <-- how to format expression
        for (int i = 1; i <= 40; i++) {
           if (i % 4 == 0) {
                 System.out.println(" " + i + " is a multiple of 4");
           }
        }
    }


    // While Loop - cycles through until a condition changes
    public static void whileLoop() {
        System.out.println("While Loop:");
        int p = 1;
        while (p < 6) {
            System.out.println(" Counting... " + p);
            p++;
        }
    }

    public static void whileTrue(){
        int count = 1;
        while(true) {   // <-- creates "endless loop" until a "break" expression is executed
            if (count == 6) {
                break;
            }
            System.out.println("Count value is " + count);
            count++;
        }
    }

    public static void whileContinue(int start, int end){
        while (start <= end) {
            start++;
            if(!Homework.isEvenNumber(start)){  // <-- if the number is not even, then start again
                continue;
            /*    ^--similar to "break" - however, it makes the while loop start again.
                  "break" would exit the while loop and continue to code after the loop.
                  "continue" brings us back to the start of the loop.
                  Small, but important differences!                                       */
            }
            System.out.println(start + " is an even number");
        }
    }

    //Do While Loop - "I believe the 'While Loop' now takes care of this" -Paul Dechone
    //   Main difference is where the test condition lives: while -> top, do -> bottom
    public static void doLoop(){
        int count = 1;
        do {             // <-- This part will always run, at least once, until 'while' condition
            System.out.println("Count value was " + count);
            count++;
        } while(count != 6);  // <--If count started above 6, it will cause an infinite loop - needs a break statement
        //                 ^-- notice it needs a ";"                            TODO: NOT SURE WHY
    }

    public static void doLoopPaul() {
        Scanner scanner = new Scanner(System.in);
        int value;
        //above lines just set some stuff up so that the following doesn't show errors
        do {
            System.out.println("Enter a number: ");
            value = scanner.nextInt();
        } while (value != 5);
        System.out.println("Got 5!");

        System.out.println("fin");
    }


    //   === SWITCH STATEMENT ===
/*      Similar to an "if-statement," but can check one value against multiple criteria.
 *      Important to note that unlike in an "if-statement," the keyword "break" is needed
 *      in order to break out of the switch-statement.  In addition, in place of the "else"
 *      criteria, we now use "default:" to designate what to do if no cases are true.
 */

    public static void switchStatement(){
        int switchValue = 2;
        switch(switchValue){
            case 1:
                System.out.println("Value was 1");
                break;
            case 2:
                System.out.println("Value was 2");
                break;
            case 3: case 4: case 5:    // <--Grouping multiple cases
                System.out.println("Your number was a 3, 4, or 5");
                System.out.println("Actually it was a " + switchValue);
                break;
            default:
                System.out.println("This is the equivalent of 'else'");
                break;  // <--technically don't NEED one here, but it's good practice
        }

        String month = "January";
        switch (month.toLowerCase()) {  // <-- *.toLowerCase() allows us to compare strings (otherwise it's case sensitive)
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
        }
    }
}