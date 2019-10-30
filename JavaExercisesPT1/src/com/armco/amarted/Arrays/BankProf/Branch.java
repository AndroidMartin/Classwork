package com.armco.amarted.Arrays.BankProf;

import java.sql.Array;
import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }


    public String getName() {
        return name;
    }

    public boolean newCustomer(String name, Double amount){
        if(findCustomer(name) == null) {
            this.customers.add(new Customer(name,amount));
            return true;

        }
        System.out.println("Customer already exists");
        return false;
    }

    public boolean addTransaction(String name,double amount){
        Customer existingCustomer = findCustomer(name);
        if(existingCustomer != null){
            existingCustomer.addTransaction(amount);
            System.out.println("Transaction Added");
            return true;
        }
        System.out.println("Customer not found");
        return false;
    }

    private Customer findCustomer(String name) {
        for(int i=0; i<customers.size(); i++){
            Customer existingCustomer = this.customers.get(i);
            if(existingCustomer.getName().equals(name)) {
                return existingCustomer;
            }
        }
        return null;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
