package com.armco.amarted;

public class ParsingValues {

    public static boolean canPack(int bigCount, int smallCount, int goal){
        if (bigCount<0 || smallCount<0 || goal<0){
            return false;
        }
        //  big=5 small=1

        int bigBags = 0;
        int smallBags = 0;
        int sum = 0;

        while (goal > 0){



//            if (goal % 5 > 0){
//                bigBags = goal / 5;
//                goal -= bigBags * 5;
//                System.out.println("bigBags: " + bigBags + "   Goal is now " + goal + " kilos");
//            } else {
//                smallBags = goal;
//                goal -= 1;
//                System.out.println("smallBags is " + smallBags);
//            }
        }

//        bigBags = goal / 5;
//        smallBags = goal % 5;
//
//        if (bigBags > bigCount) {
//            sum = bigBags - bigCount;
//            System.out.println("Sum: " + sum);
//        }
//
//        System.out.println(bigBags + " / " + smallBags);

        return true;
    }

}
