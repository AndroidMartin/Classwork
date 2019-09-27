package com.armco.amarted;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // SpeedConverter.java
        System.out.println("\nSpeed Converter:");
        SpeedConverter.printConversion(1.5);
        SpeedConverter.printConversion(10.25);
        SpeedConverter.printConversion(-5.6);

        // MegaBytesConverter.java
        System.out.println("\nMegaBytes Converter:");
        MegaBytesConverter.printMegaBytesAndKiloBytes(2500);
        MegaBytesConverter.printMegaBytesAndKiloBytes(-2500);
        MegaBytesConverter.printMegaBytesAndKiloBytes(5000);

        System.out.println("\nShould we wake up:");
        System.out.println(BarkingDog.shouldWakeUp(true,1));
        System.out.println(BarkingDog.shouldWakeUp(false,2));
        System.out.println(BarkingDog.shouldWakeUp(true,8));
        System.out.println(BarkingDog.shouldWakeUp(true,26));
        System.out.println();

        System.out.println("isLeapYear = " + LeapYear.isLeapYear(1924));

        System.out.println("decimals to 3 places: " + DecimalComparator.areEqualByThreeDecimalPlaces(3.148,3.1456));

        System.out.println("\na + b = c: " + EqualSumChecker.hasEqualSum(1,-1,0));

        System.out.println("\nTeen Number Checker:");
        TeenNumberChecker.showTeenNumberChecker(43,28,77,13);

        System.out.println(("\nArea Calculator:"));
        System.out.println("The area is " + AreaCalculator.area(5,3));

        MinutesToYearsAndDays.printYearsAndDays(561600);

        IntEqualityPrinter.printEqual(1,2,4);

        System.out.println(PlayingCat.isCatPlaying(false,35));

        NumberOfDaysInMonth.printNumberOfDaysInMonth(10,2017);

        System.out.println("\nSum Odd Ranges:\n" + SumOddRange.sumOdd(100,1000));

        System.out.println("\nIs the number a palindrome?\n" + ControlFlowStatements.isPalindrome(-717));

        System.out.println("\nSum of first and last digit is: " + ControlFlowStatements.sumFirstAndLastDigit(7353));
        System.out.println("Sum of the even digits is: " + ControlFlowStatements.getEvenDigitSum(123456789));
        System.out.println("Has shared digit: " + ControlFlowStatements.hasSharedDigit(12,13));
        System.out.println("Has same last digit: " + ControlFlowStatements.hasSameLastDigit(426,874,126));

        System.out.println("\nGreatest Common Denominator is: " + ControlFlowStatements.getGreatestCommonDivisor(81,153));

        System.out.println("\nFactors of number are: ");
        ControlFlowStatements.printFactors(32);

        System.out.println("Is it a perfect number:");
        System.out.println(ControlFlowStatements.isPerfectNumber(5));

        System.out.println("\nNumber to Words: ");
        ControlFlowStatements.numberToWords(1234);

        System.out.println("\nCan make package: " + ControlFlowStatements.canPack(2,10,18));

//        System.out.println();
//        InputOutputExercises.inputThenPrintSumAndAverage();

        System.out.println("\nBuckets Needed: " + InputOutputExercises.getBucketCount(2.75,3.25,2.5,1));


    }
}
