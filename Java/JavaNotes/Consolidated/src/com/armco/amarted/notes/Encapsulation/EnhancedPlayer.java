package com.armco.amarted.notes.Encapsulation;

public class EnhancedPlayer {
    private String name;
    private int health = 100;
    private String weapon;

    public EnhancedPlayer(String name, int health, String weapon) {
        this.name = name;
        if (health > 0 && health <= 100){  // <-- Ensures that the health can not be assigned outside range 0-100
            this.health = health;
        }
        this.weapon = weapon;
    }

    public void loseHealth(int damage){
        this.health -= damage;
        if (this.health <= 0) {
            System.out.println("Player Knocked out");
            // Reduce number of lives remaining for the player
        } else {
            System.out.println(this.name + " took " + damage + " damage - " + this.health + " remaining!");
        }
    }

    public String getName() {
        return name;
    }

    public String getWeapon() {
        return weapon;
    }

    public int getHealth() {
        return health;
    }
}
