package com.armco.amarted.Arrays.BankMy;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<>();

    // Constructors
    public Customer(String name, ArrayList<Double> transactions) {
        this.name = name;
        this.transactions = transactions;
    }

    // Public methods
    public void addTransaction(double amount){
        this.transactions.add(amount);
        System.out.println("Transaction successfully completed!");
    }

    public static Customer addCustomer(String name, double amount){
        ArrayList<Double> iniDeposit = new ArrayList<>();
        iniDeposit.add(amount);
        return new Customer(name,iniDeposit);
    }




    //  Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

}
