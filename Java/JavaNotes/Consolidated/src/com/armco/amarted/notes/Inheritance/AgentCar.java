package com.armco.amarted.notes.Inheritance;

public class AgentCar extends Car {
//    public boolean weaponsEnabled;
//    public String activeWeapon;
//
//
//    public BondCar(int speed, int currentGear, boolean weaponsEnabled, String activeWeapon) {
//        super(speed, currentGear);
//        this.weaponsEnabled = weaponsEnabled;
//        this.activeWeapon = activeWeapon;
//    }
//
//    public boolean isWeaponsEnabled() {
//        return weaponsEnabled;
//    }
//
//    public void setWeaponsEnabled(boolean weaponsEnabled) {
//        this.weaponsEnabled = weaponsEnabled;
//    }
//
//    public String getActiveWeapon() {
//        return activeWeapon;
//    }
//
//    public void setActiveWeapon(String activeWeapon) {
//        this.activeWeapon = activeWeapon;
//    }

    private String primaryWeapon;
    private boolean isWeaponsActive;

    public AgentCar(String primaryWeapon, boolean isWeaponsActive) {
        super("Secret Service Vehicle", "European", 4, 2, 6, false);
        this.primaryWeapon = primaryWeapon;
        this.isWeaponsActive = isWeaponsActive;
    }

    public void accelerate(int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity <= 0) {
            stop();
            changeGear(1);
        } else if (newVelocity > 0 && newVelocity <= 10) {
            changeGear(1);
        } else if (newVelocity > 10 && newVelocity <=20) {
            changeGear(2);
        } else if (newVelocity > 20 && newVelocity <= 30) {
            changeGear(3);
        } else if (newVelocity > 30 && newVelocity <= 40) {
            changeGear(4);
        } else if (newVelocity > 40 && newVelocity <= 50) {
            changeGear(5);
        } else {
            changeGear(6);
        }

        if (newVelocity > 0){
            changeVelocity(newVelocity,getCurrentDirection());
        }
    }

    public void activateWeapon(){
        this.isWeaponsActive = true;
        System.out.println(this.primaryWeapon + " now active!");
    }
}
