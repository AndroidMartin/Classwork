package com.armco.amarted.notes;

import java.util.Scanner;

public class IOinterface {

    public static void ioExecute(){

        //Create scanner object
        Scanner input = new Scanner(System.in);

        //Output the prompt
        System.out.println("Enter your name: ");

        //Wait for the user to enter something
        String line = input.nextLine();
        //could make it of any variable type
        // int value = input.nextInt();

        //Tell them what they entered
        System.out.println("You entered: "+line);


        //To check if specific text has been entered - SWITCH STATEMENT - I believe this has been depreciated
        Scanner sysCommand = new Scanner(System.in);
        System.out.println("Please enter a command: ");
        String text = sysCommand.nextLine();

        switch (text) {
            case "start":
                System.out.println("Machine started!");
                break;
            case "stop":
                System.out.println("Machine stopped.");
                break;
            default:
                System.out.println("Command not recognized");
                break;
        }

        // FOR MORE INFO SEE THE METHOD BELOW
        //     Homework.printMinAndMax();
    }
}
