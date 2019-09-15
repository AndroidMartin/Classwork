package com.armco.amarted;

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
    }
}
