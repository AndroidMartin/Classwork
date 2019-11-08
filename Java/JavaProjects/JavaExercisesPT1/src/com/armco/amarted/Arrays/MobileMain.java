package com.armco.amarted.Arrays;

import com.armco.amarted.Arrays.BankMy.Contact;

import java.util.Scanner;

public class MobileMain {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("741 555 1231");

    public static void mobileMain(){
        boolean quit = false;
        startPhone();
        printActions();
        while(!quit){
            System.out.println("\nEnter action: (6 to show available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("\nShutting Down...");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    searchContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void startPhone(){
        System.out.println("Starting phone...");
    }

    private static void printActions(){
        System.out.println("\nAvailable Actions:");
        System.out.println("0 - Quit Phone\n" +
                         "1 - Print Contacts\n" +
                         "2 - Add New Contact\n"+
                         "3 - Update Contact\n" +
                         "4 - Remove Existing Contact\n"+
                         "5 - Search for Contact\n" +
                         "6 - Print List of Available Actions"
        );
        System.out.println("Choose your action: ");
    }

    private static void addNewContact(){
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter phone number: ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name,number);
        if(mobilePhone.addNewContact(newContact)){
            System.out.println("New contact added: " + name + ", phone = " + number);
        } else {
            System.out.println("Cannot add, " + name +". Already on file.");
        }
    }

    private static void updateContact(){
        System.out.println("Enter contact you wish to change: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if(existingContact == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name:");
        String newName = scanner.nextLine();
        System.out.println("Enter new number:");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName,newName);
        if(mobilePhone.updateContact(existingContact,newContact)){
            System.out.println("Successfully updated record");
        } else {
            System.out.println("Error updating record, try adding it");
        }
    }

    private static void deleteContact() {
        System.out.println("Enter contact you wish to delete: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        } else {
            if (mobilePhone.removeContact(existingContact)) {
                System.out.println("Contact removed successfully");
            } else {
                System.out.println("Error deleting contact");
            }
        }
    }

    private static void searchContact() {
        System.out.println("Enter contact you wish to find: ");
        String name = scanner.nextLine();
        Contact existingContact = mobilePhone.queryContact(name);
        if (existingContact == null) {
            System.out.println("Contact not found.");
            return;
        } else {
            System.out.println("Name: " + existingContact.getName());
            System.out.println("Phone Number: " + existingContact.getPhone());
        }
    }
}
