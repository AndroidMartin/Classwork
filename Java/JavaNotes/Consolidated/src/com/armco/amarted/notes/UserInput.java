package com.armco.amarted.notes;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class UserInput {

    public static void readingUserInput(){
        Scanner scanner = new Scanner(System.in);
//                                    ^--- opposite of System.out

        System.out.println("Enter your year of birth: ");
        boolean hasNextInt = scanner.hasNextInt(); // <--checks that the input is an 'int'

        if (hasNextInt){
            int yearOfBirth = scanner.nextInt();  // <--this way you don't have to "parse" the string to int
            scanner.nextLine();  // <--handles 'next line character (enter key) - w/o it will jump over the next input

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            int age = 2019 - yearOfBirth;
            if (age >= 0 && age <= 120){
                System.out.println(name + " is " + age + " years old");
            } else {
                System.out.println("Invalid year of birth!");
            }
        } else {
            System.out.println("Unable to parse year of birth...");
        }


        scanner.close();  // <--closes scanner and frees up memory

    }

}
