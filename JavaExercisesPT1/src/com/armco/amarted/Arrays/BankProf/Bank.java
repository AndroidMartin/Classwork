package com.armco.amarted.Arrays.BankProf;


import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Bank tdBank = new Bank("TD Bank");
        tdBank.addBranch("Boston");
        tdBank.addBranch("Cambridge");
        tdBank.addCustomer("Boston","Jeff",250);
        tdBank.addCustomer("Boston","Rebecca",500);
        tdBank.addCustomer("Cambridge","Zoe",200);
        tdBank.addTransaction("Boston","Rebecca",-25.37);
        Bank bofa = new Bank("Bank of America");
        bofa.addBranch("Boston");
        bofa.addBranch("Newton");
        bofa.addCustomer("Newton","Jerry",2037.48);
        bofa.addCustomer("Newton","Esta",1067.89);
        bofa.addCustomer("Boston","Mike",251.55);
        bofa.addTransaction("Boston","Mike",-100);
        Scanner scanner = new Scanner(System.in);

        tdBank.listCustomers("Boston",true);
    }
}






public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String name){
        if(findBranch(name) == null) {
            branches.add(new Branch(name));
            return true;
        }
        return false;
    }

    public boolean addCustomer (String branchName, String customerName, double initialDeposit){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.newCustomer(customerName,initialDeposit);
        }
        return false;
    }

    public boolean addTransaction (String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if(branch != null) {
            return branch.addTransaction(customerName, amount);
        }
        System.out.println("Error adding transaction");
        return false;
    }

    private Branch findBranch(String name){
        for(int i=0; i<this.branches.size(); i++){
            Branch searchBranch = this.branches.get(i);
            if(searchBranch.getName().equals(name)) {
                return searchBranch;
            }
        }
        return null;
    }


    boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if(branch != null){
            System.out.println("Customers for branch " + branch.getName() + ":");
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for(int i=0; i<branchCustomers.size(); i++){
                Customer currentCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + currentCustomer.getName() + " [" + i + "]");
                if(showTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> listTransactions = currentCustomer.getTransactions();
                    for(int j=0; j<listTransactions.size(); j++){
                        System.out.println("[ " + (j+1) + "] \t" + listTransactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }
}
