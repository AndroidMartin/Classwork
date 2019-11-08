package com.armco.amarted.Arrays;

import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Array1 {

    private static Scanner scanner = new Scanner(System.in);

    public static int[] getIntegers(int elements){
        System.out.println("Enter " + elements + " integers");
        int[] values = new int[elements];
        for(int i=0; i<values.length;i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static void printArray(){
        int[] myArray = getIntegers(5);
        System.out.println("You entered: " + myArray[0] + ", " + myArray[1] + ", " + myArray[2] + ", " + myArray[3] + ", " + myArray[4]);
        sortIntegers(myArray);
    }

    public static int[] sortIntegers(int[] array){
        int[] sortedArray = Arrays.copyOf(array,array.length);

        for(int i=0; i<array.length; i++){

        }


        System.out.println("Descending: " + sortedArray[0] + ", " + sortedArray[1] + ", " + sortedArray[2] + ", " + sortedArray[3] + ", " + sortedArray[4]);
        return sortedArray;
    }

}
