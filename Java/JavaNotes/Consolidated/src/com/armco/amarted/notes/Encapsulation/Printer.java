package com.armco.amarted.notes.Encapsulation;

public class Printer {
    private boolean isDuplex;
    private Toner toner;
    private int totalPages = 0;
    private int tonerRate;

    public Printer(boolean isDuplex, int maxCapacity, int rate) {
        Toner iToner = new Toner(maxCapacity);
        this.isDuplex = isDuplex;
        this.toner = iToner;
        this.tonerRate =rate;
    }

    public void print(){
        System.out.println("Printing Page...");
        this.totalPages++;
        this.toner.setLevel(this.toner.getLevel()-1);
        System.out.println("Toner level is now: " + this.toner.getLevel());
    }

    public void print(int pages){
        System.out.println("Printing " + pages + " pages...");
        this.totalPages += pages;
        this.toner.setLevel(this.toner.getLevel() - (pages*this.tonerRate));
        System.out.println(this.totalPages + " total pages printed");
        System.out.println("Toner level is now: " + this.toner.getLevel());
    }

    public void addToner(int amt) {
        this.toner.fillToner(amt);
    }

    public int getToner() {
        return toner.getLevel();
    }

    public boolean isDuplex() {
        return isDuplex;
    }

}
