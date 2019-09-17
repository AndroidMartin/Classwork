package com.armco.amarted;

public class DigitSums {

    public static boolean isPalindrome(int number) {

        if (number < 0) {
            number *= -1;
        }

        int org = number;
        int inverse = 0;
        int calc = 0;

        while (number > 0) {
            calc = number % 10;
            inverse *= 10;
            inverse += calc;
            number /= 10;
        }

        if (inverse == org) {
            return true;
        }
        return false;
    }

    public static int sumFirstAndLastDigit (int number){
        int firstDigit = 0;
        int lastDigit = 0;

        if (number < 10) {
            if (number < 0){
                return -1;
            }
            return number + number;
        }

        lastDigit = number % 10;

        while (number >= 10){
            number /= 10;
        }
        return lastDigit + number;
    }

    public static int getEvenDigitSum (int number){
        int digit = number;
        int sum = 0;

        if (number < 0){
            return -1;
        }

        // 123456789
        while (number > 0) {
            digit = number % 10;
            number /= 10;
            if (digit % 2 == 0){
                sum += digit;
            }
        }

        return sum;
    }

    public static boolean hasSharedDigit (int a, int b){
        if (a<10 || a>99 || b<10 || b>99){
            return false;
        }

        int check = 0;
        int against = 0;
        int orgB = b;

        while (a>0){
            check = a % 10;
            a /= 10;
            b = orgB;  // <-- reset's b after each digit of a is checked
//            System.out.println("check: " + check + "   a: " + a);
            while (b>0){
                against = b % 10;
                b /= 10;
//                System.out.println("against: " + against + "   b: " + b);
                if (check == against){
                    return true;
                }
            }
        }
        return false;

    }

    public static boolean hasSameLastDigit (int a, int b, int c){
        if (a<10 || b<10 || c<10 || a>1000 || b>1000 || c>1000){
            return false;
        }

        a %= 10;
        b %= 10;
        c %= 10;

        if (a==b || b==c || c==a){
            return true;
        }
        return false;
    }
    public static boolean isValid (int i) {
        if (i<10 || i>1000) {
            return false;
        }
        return true;
    }

}
