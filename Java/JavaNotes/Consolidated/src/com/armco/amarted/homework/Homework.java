package com.armco.amarted.homework;

import com.armco.amarted.notes.ClassesMethods.Constructors.BankAccount;

import java.util.Scanner;

public class Homework {


    // RE-CREATE AN EXPRESSION IN "LONG" FORMAT
    byte hwByte = 43;
    short hwShort = 4_937;
    int hwInt = 216_569;
    long hwFinalResult = 50000L + (10L * (hwByte + hwShort + hwInt));

    // CAST THE FLOAT VALUE OF 5.25 - MAKE IT ACCEPT IT: FIRST LINE IS BAD, SECOND IS CORRECT
    //float myFloatValueBAD = 5.25;   //<---Incorrect (uncomment to demonstrate)
    float myFloatValue = (float) 5.25;

    // CONVERT POUNDS TO KILOGRAMS
    public static void lbsToKilos() {
        System.out.println("Results from Pounds to Kilos Challenge");
        double myPounds = 200d;
        double multiplier = .45359237d;
        double myKilos = myPounds * multiplier;
        System.out.println("Covert " + myPounds + "lbs to kilograms");
        System.out.println("Kilos: " + myKilos + "\n");
    }

    // OPERATOR CHALLENGE
    public static void operatorChallenge() {
        System.out.println("Results from Operator Challenge");
        double first = 20.00d;
        double second = 80.00d;
        double finalVar = (first + second) * 100.00d;
        System.out.println("finalVar: " + finalVar);
        double remainderVar = finalVar % 40.00;
        System.out.println("remainderVar: " + remainderVar);
        boolean isNoRemainder = (remainderVar == 0) ? true : false;
        System.out.println("isNoRemainder value: " + isNoRemainder);
        if (!isNoRemainder) {
            System.out.println("Got some remainder\n");
        } else {
            System.out.println("No remainder present...\n");
        }
    }

    //  METHOD CHALLENGES
    public static void scoreChallenge(){
        boolean isGameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        if(isGameOver == true){
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
            score = 10000;
            levelCompleted = 8;
            bonus = 200;
            finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }

    public static void displayHighScorePosition (String userName, int position){
        System.out.println(userName + " managed to get into position " + position + " on the High Score Table");
    }
    public static int calculateHighScorePosition(int score){
        if (score >= 1000) {
            return 1;
        } else if (score >= 500) {
            return 2;
        } else if (score >= 100) {
            return 3;
        }
        return 4;
    }
//        Run the following two lines of code to call the methods above
//        int position = Homework.calculateHighScorePosition(1500);
//        Homework.displayHighScorePosition("Andrew", position);


    // OVERLOADING METHOD CHALLENGE
    public static double calcFeetAndInchesToCentimeters(double feet, double inches){
        if (feet<0 || (inches<0 || inches>12)) {
            return -1;
        }
        double centimeters = ((feet * 12) + inches) * 2.54;
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){
        if (inches<0){
            return -1;
        }
        double calcFeet = (int) inches / 12;
        double calcInches = (int) inches % 12;
        return calcFeetAndInchesToCentimeters(calcFeet,calcInches);
    }


    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";
    public static String getDurationString (int min, int sec) {
        if ((min < 0) || (sec < 0) || (sec > 59)) {
            return INVALID_VALUE_MESSAGE;
        }
        if (min > 60) {
            int hours = min / 60;
            min = min % 60;
            return hours + "h " + min + "m " + sec + "s";
        }
        return "0h " + min + "m " + sec + "s";
    }

    public static String getDurationString (int sec) {
        if (sec<0) {
            return INVALID_VALUE_MESSAGE;
        }

        int min = sec / 60;
        sec = sec % 60;
        return getDurationString(min,sec);
    }


    //  SWITCH STATEMENT CHALLENGE
    public static void printSwitchStatement(char a){
        System.out.println("Switch Statement Results:");
        String enteredMessage = "You entered ";
        switch (a){
            case 'A':
                System.out.println("You entered 'A'");
                break;
            case 'B':
                System.out.println(enteredMessage + "'B'");
                break;
            case 'C': case 'D': case 'E':
                System.out.println(enteredMessage + "'C'");
                break;
//            case 'D':
//                System.out.println(enteredMessage + "'D'");
//                break;
//            case 'E':
//                System.out.println(enteredMessage + "'E'");
//                break;
            default:
                System.out.println("You entered an invalid character");
                break;
        }
    }
    //      Day of the week challenge
    public static void printDayOfTheWeek(int day){
        switch (day){
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Invalid Day");
                break;
        }

        if (day == 0) {
            System.out.println("Sunday");
        } else if (day == 1) {
            System.out.println("Monday");
        } else if (day == 2){
            System.out.println("Tuesday");
        } else if (day == 3){
            System.out.println("Wednesday");
        } else if (day == 4){
            System.out.println("Thursday");
        } else if (day == 5){
            System.out.println("Friday");
        } else if (day == 6){
            System.out.println("Saturday");
        }else {
            System.out.println("Invalid Day");
        }
    }


    //  FOR STATEMENT CHALLENGE

    public static double calculateInterest (double amount, double interestRate){
        return (amount * (interestRate/100));
    }

    public static void printInterest (double amount) {
        for (int i = 2; i < 9; i++) {
            System.out.println(amount + " at " + i + "% interest = " + String.format("%.2f",calculateInterest(amount,i)));
            //                                                         |-------------------------| <-- formats to only 2 decimal places
        }
    }

    public static void print3and5(){
        int sum = 0;
        int count = 0;

        for (int i=1; i<=1000; i++){
            if ((i%3==0) && (i%5==0)){
                System.out.println(i + " is divisible by both 3 and 5");
                sum += i;
                count++;
            }
            if (count>4) {
                break;
            }
        }
        System.out.println("The summation of numbers found = " + sum);
    }


    // WHILE STATEMENT CHALLENGE
    public static boolean isEvenNumber(int number){
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void printEvenNumbers(int start,int end){
        while (start <= end) {
            start++;
            if (isEvenNumber(start)) {
                System.out.println("Even numbers are " + start);
            }
        }
    }
    public static void testEven(int start, int end){
        int count = 0;
        while (start <= end){
            if (!isEvenNumber(start)){
                start++;
                continue;
            }
            count++;
            if (count<=5) {
                System.out.println(start + " is even");
            }
            start++;
        }
        System.out.println("Found " + count + " even numbers!");
    }
    public static int sumDigits (int number){
        System.out.println("The sum of the digits in " + number + " is:");
        int sum = 0;
        if (number < 10) {
            return -1;
        }
        while (number > 0) {
            sum += (number % 10);
            number /= 10;  //<-- same as (number = number / 10)
        }
        return sum;
    }


    public static int mySumTenNumbers(){
        int sum = 0;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++){
            System.out.println("Testing 'for loop' " + (i+1) + " more times...");
            System.out.println("Enter number #" + (i+1) + ":");
            boolean hasNextInt = scanner.hasNextInt();
            if (!hasNextInt){
                System.out.println("Invalid Number");
//                scanner.nextLine();
            } else {
                sum += scanner.nextInt();
                scanner.nextLine();
                System.out.println("New Sum: " + sum);
            }
        }

        scanner.close();
        System.out.println("Sum is: " + sum);
        return sum;
    }

    public static int instructorSumTenNumbers(){
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int sum = 0;

        while (true) { // <--Endless loop
            int order = counter + 1;
            System.out.println("Enter number #" + order + ":");
            boolean isAnInt = scanner.hasNextInt();
            if (isAnInt){
                int number = scanner.nextInt();
                counter++;
                sum += number;
                if (counter==10){
                    break;
                }
            } else {
                System.out.println("Invalid Number");
            }

            scanner.nextLine();  // <-- handle end of line (enter key)
        }
        System.out.println("sum = " + sum);
        scanner.close();
        return sum;
    }


    public static void printMinAndMax(){
        int max = Integer.MIN_VALUE; // <--Makes sure the first input is counted
        int min = Integer.MAX_VALUE; // <--Makes sure the first input is counted
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Enter a number:");
            boolean isInt = scanner.hasNextInt();
            if (isInt) {
                int number = scanner.nextInt();
                if (number < min){
                    min = number;
                }
                if (number > max){
                    max = number;
                }

            } else {
                System.out.println("\nMinimum number is: " + min);
                System.out.println("Maximum number is: " + max);
                break;
            }
        }
        scanner.close(); // <--BE CAREFUL TO NOT FORGET
    }



    BankAccount myAccount = new BankAccount();

}
