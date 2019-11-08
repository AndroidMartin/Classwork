package com.armco.amarted.notes.ClassesMethods.Constructors;

public class BankAccount {
    //  CREATE YOUR VARIABLES
    int accountNum;
    double balance;
    String name;
    String email;
    String phone;

    //  GENERATE GETTERS AND SETTERS
    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    //  USE CONSTRUCTORS TO EASILY SET THE PARAMETERS

    public BankAccount(){ // <--Constructors need to have the EXACT name as the class
        this(56789,2.50,"Default name", "Default email","Default phone");  // <--MUST be first line of constructor, if used
        //  ^--Special use of "this" - passes these defaults to the other constructor IF an empty constructor is called
        System.out.println("Empty constructor called...");
        System.out.println("Populating with default values.");
    }

    public BankAccount(String name, String email, String phone) {
        this(00000,1.0,name,email,phone);  // <--Set's default values for two parameters and passes info from constructor with 3 parameters
//        this.name = name;    --|
//        this.email = email;    |--- Don't need these because of the usage of "this()" above
//        this.phone = phone;  --|
    }

    public BankAccount(int number, double balance, String name, String email, String phone){
        System.out.println("Creating new account with parameters");
        this.accountNum = number;
        this.balance = balance;
        setName(name);  // <--Replaces "this.name = name;"
        setEmail(email);  // <--Possible use, if you had some validation in the "setEmail()" method
        this.phone = phone;  // <--Generally just better practice, could have issues with inheritance; guarantees they will be initialized
    }


    //  USE METHODS TO CREATE BEHAVIORS

    public void depositFunds(double amount){
        this.balance += amount;
        System.out.println("Deposit of $" + amount + " successful.");
        System.out.println("Your new balance is: $" + this.balance);
    }
    public void withdrawFunds(double amount){
        //if (amount>balance){
        if (this.balance-amount<0){
            System.out.println("Insufficient Funds Available!");
            System.out.println("Your balance is: $" + this.balance);
        } else {
            this.balance -= amount;
            System.out.println("Successful withdrawal of: $" + amount);
            System.out.println("Your new balance is: $" + this.balance);
        }
    }


}
