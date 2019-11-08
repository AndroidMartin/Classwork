package com.armco.amarted.notes.ClassesMethods.Constructors;

public class VipCustomer {
    private String name;
    private double creditLimit;
    private String email;

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }

    public VipCustomer(){
        this("Unknown Name",500.0,"Unknown email");
    }

    public VipCustomer(String name, String email){
        this(name,500.0,email);
    }

    public VipCustomer(String name, double limit, String email){
        this.name = name;
        this.creditLimit = limit;
        this.email = email;
    }
}
