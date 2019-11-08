package com.armco.amarted.homework.Arrays;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

    private static Scanner scanner = new Scanner(System.in);

    public static void myArray(int count) {
        int[] myArray = new int[count];
        System.out.println("Enter " + count + " numbers");
        for(int i=0; i<myArray.length;i++){
            myArray[i] = scanner.nextInt();
        }
        System.out.println("Original Array: " + Arrays.toString(myArray));

        int[] myReversedArray = new int[myArray.length];
        int temp = myArray.length-1;
        for(int i=0; i<myReversedArray.length; i++){
            myReversedArray[i] = myArray[temp];
            temp--;
        }
        System.out.println("Reversed Array: " + Arrays.toString(myReversedArray));
    }


    private static void profReverse(int[] array){
        int maxIndex = array.length - 1;
        int halfLength = array.length / 2;
        for(int i=0; i<halfLength; i++){
            int temp = array[i];
            array[i] = array [maxIndex-i];
            array[maxIndex - i] = temp;
        }
    }

    public static void profMain(){
        int[] array = {1,5, 3, 7, 11, 9, 15};
        System.out.println("Professor's array: " + Arrays.toString(array));
        profReverse(array);
        System.out.println("Prof's reversed array: " + Arrays.toString(array));
    }
}
