package com.armco.amarted.Arrays.BankMy;

import javax.swing.*;
import java.util.ArrayList;

public class Branches {
    private String name;
    private ArrayList<Customer> customers;

    public Branches(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }


    public boolean addNewCustomer(Customer newCustomer){
        if(findCustomer(newCustomer.getName()) >=0){
            System.out.println("Contact is already on file");
            return false;
        }
        customers.add(newCustomer);
        return true;
    }

    public Customer addNewCustomer(String name){
        if(findCustomer(name) >= 0){
            System.out.println("Customer already exists");
        }
        ArrayList<Double> newArray = new ArrayList<>();
        return new Customer(name,newArray);
    }

    public boolean updateCustomer(Customer oldCustomer, Customer newCustomer) {
        int foundPosition = findCustomer(name);
        if(foundPosition >= 0) {
            this.customers.set(foundPosition,newCustomer);
            System.out.println("Updated customer");
            return true;
        }
        System.out.println("Did not find customer");
        return false;
    }

    public boolean deleteCustomer(Customer customer){
        if(findCustomer(customer) >=0){
            this.customers.remove(findCustomer(customer));
            System.out.println("Customer deleted");
            return true;
        }
        System.out.println("Customer not found");
        return false;
    }


    private int findCustomer(Customer customer){
        return this.customers.indexOf(customer);
    }

    public int findCustomer(String name){
        for(int i=0; i<=this.customers.size(); i++){
            Customer dbCustomer = this.customers.get(i);
            if(dbCustomer.getName().equals(name)){
                System.out.println("Customer found");
                return i;
            }
        }
        return -1;
    }


}
