package com.armco.amarted.homework.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {

    private static Scanner scanner = new Scanner(System.in);

    private static int[] readIntegers(int count){
        int[] myArray = new int[count];
        System.out.println("Enter " + count + " integers");
        for(int i=0; i<count;i++){
            myArray[i] = scanner.nextInt();
        }

        System.out.println("You entered: " + Arrays.toString(myArray));
        findMin(myArray);
        return myArray;
    }

    private static int findMin(int[] array){
        int min = array[0];

        for(int i=0; i<array.length;i++){
//            System.out.println("test " + i);
            if(array[i] < min) {
                min = array[i];
            }
        }

        System.out.println("Minimum number is " + min);
        return min;
    }

    public static void minArray(int count){
        readIntegers(count);
    }
}
