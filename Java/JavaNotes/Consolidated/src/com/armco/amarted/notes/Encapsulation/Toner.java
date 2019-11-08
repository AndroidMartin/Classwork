package com.armco.amarted.notes.Encapsulation;

public class Toner {
    private int level;
    private int capacity;

    public Toner(int maxLevel) {
        this.level = maxLevel;
        this.capacity = maxLevel;
    }

    public void fillToner(int amount){
        System.out.println("Added " + amount + " toner");
        if (amount + this.level > capacity) {
            int overFill = amount - (capacity - this.level);
            this.level = capacity;
            System.out.println("You OVER-filled the toner cartridge by " + overFill + "!!!");
        } else if (amount + this.level == capacity) {
            this.level = capacity;
            System.out.println("You filled the toner cartridge!");
        } else {
            this.level += amount;
        }
        System.out.println("Current level now " + this.level + "/" + this.capacity);
    }

    public int getLevel() {
        return level;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
