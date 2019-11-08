package com.armco.amarted.notes;

import java.util.Scanner;

public class Operators {
/*
    ===== Basic Operators =====
        + : Addition
        - : Subtraction
        * : Multiplication
        / : Division
        % : Remainder

    ===== Relational Operators =====
       == : Equal To
       != : NOT Equal To
        > : Greater Than
        < : Less Than
       >= : Greater Than or Equal To
       <= : Lesser Than or Equal To

    ===== Logical Operators =====
       && : AND == both "sides" need to be TRUE in order for the whole expression to return true
       || : OR (dual-pipes)
        ! : NOT

    ===== Incremental Operators =====
       ++ : Increases by 1
       -- : Reduces by 1
       += : Increases by value
       -= : Decreases by value
       *= : Multiplied by value
       /= : Divided by value

    ===== Generalities =====
       SYMBOL     NAME      PRIMARY USE
         { }     Braces     Blocks of code, Method Signatures
          ;    Semicolon    Code statements, End of line
         ( )  Parenthesis   Parameters, Calling a method
         [ ]    Brackets    Data objects, Data position
      = ! & +  Operators    Reference assignment and logic

    ===== Logical Operators =====
        camelCase  - used most often, generally for variables and methods [methods are followed with "()"]
        PascalCase - used to define classes
        snake_case - used in xml files (android only)
         ALL CAPS  - SQL language (android only)
*/



    /*
    ===== Basic Operations (+,-,*,/,%) =====
    */
    public static void basicOperations() {
        double firstNum = 10;
        double secondNum = 3;
        double theResult;

        // Addition = "+"
        double myAdd = (firstNum + secondNum);
        // Subtraction = "-"
        double mySub = (firstNum - secondNum);
        // Multiplication = "*"
        double myMulti = (firstNum * secondNum);
        // Division = "/"
        double myDiv = (firstNum / secondNum);
        // Remainder = "%"  |  what remains (e.g. 4%3=1) || 4 divided by 3 is 1 with a remainder of 1
        double myRem = (firstNum % secondNum);
        System.out.println("Add = " + myAdd + "; Sub = " + mySub + "; Multi = " + myMulti + "; Div = " + myDiv + "; Rem = " + myRem);

        theResult = firstNum % secondNum;  //theResult = the remainder of firstNum DIVIDED by secondNum
        System.out.println(" My remainder is: " + theResult);
        //Could also do the math in the print line: System.out.println("My remainder is: " + (firstNum % secondNum))

    }

     /*
    ===== Relational and Logical Operators =====
    */
     // These operators are used most commonly used in if-statements.  For that reason,
    //  examples of their usage can be found in the IfForWhile.java file.



    /*
    ===== Incremental Operations (increasing the value of a single variable) =====
    */
    public static void incrementalOperators() {
        int myResult = 3;
        myResult = myResult + 1;  //<-- CAN BE REWRITTEN IN THE FOLLOWING WAYS BELOW
        myResult++;  //<--Increments by 1  | exactly the same as above statement
        myResult--;  //<--Reduces by 1  | result = result -1
        myResult += 2;  //<--Increments by 2  | result = result +2
        myResult -= 3;  //<--Reduces by 3  | result = result -3
        myResult *= 10;  //<--Multiplies by 10  | result = result * 10
        myResult /= 4;  //<--Divides by 4  | result = result / 4
        System.out.println(myResult);

    }
}