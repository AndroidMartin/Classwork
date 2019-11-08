package com.armco.amarted.notes.Arrays;

import java.util.Scanner;

public class Arrays {

    /*
        Arrays are zero indexed: an array with n elements is indexed from 0 to n-1
        (for example, 10 elements are indexed from 0 to 9).  If we try to access an
        index that is out of range, Java will give us an "ArrayIndexOutOfBoundsException"
        which indicates that the index is out of range.
        To access array elements we use the square braces [ and ].
        Numeric arrays are initialized to 0, boolean elements are initialized to false,
        and string and other objects would be set to null.
        You can also initialize an array inline by using an array initializer block { and }.
        The values are separated by commas.  EXAMPLE:  int [] myNumbers = {5, 4, 3, 2, 1};
     */




    private static Scanner scanner = new Scanner(System.in);

    public static void myArrays(){
        int myVariable = 50; // <--regular variable
        int[] myIntArray = new int[10]; // <-- array declaration uses brackets
        myIntArray[5] = 50;

        double[] myDubArray = new double[10];
        // type     name            # of elements

        int[] myOtherIntArray = {1,2,3,4,5,6,7,8,9,10}; // <-- declare and assign

        System.out.println(myOtherIntArray[0]); // <-- Array positions always start at 0
        System.out.println(myOtherIntArray[6]); // <-- Prints the 7th position
        System.out.println(myOtherIntArray[8]);


        int[] myForArray = new int[20];
        //for(int i=0; i<10; i++){  // <-- manual set all 10 values
        for(int i=0; i<myForArray.length;i++){  // <-- Using method to populate
            myForArray[i] = i*10;
            System.out.println("Element " + i + ", value is " + myForArray[i]);
        }
    }


    public static void printArray(int[] array){
        for(int i=0; i<array.length;i++){  // <-- Using method to populate
            System.out.println("Element " + i + ", value is " + array[i]);
        }
        System.out.println("The average is " + getAverage(array));
    }



    public static void printVarArray() {
        int[] myNewArray = getIntegers(5);
        for(int i=0; i<myNewArray.length; i++){
            System.out.println("Element " + i + ", value is " + myNewArray[i]);
        }
        System.out.println("The average is " + getAverage(myNewArray));
    }

    public static int[] getIntegers(int elements){
        System.out.println("Enter " + elements + " integer values.\r");
        int[] values = new int[elements];


        for(int i=0; i<values.length; i++){
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static double getAverage(int[] array){
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum += array[i];
        }
        return (double) sum / (double)array.length;
    }


}
