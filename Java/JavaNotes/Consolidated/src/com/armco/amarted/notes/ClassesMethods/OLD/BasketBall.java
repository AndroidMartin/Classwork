package com.armco.amarted.notes.ClassesMethods.OLD;

public class BasketBall extends Ball {

    //Properties (in addition to 'Ball' properties)
    public boolean isNBA;
    public int capacity;

    //Behaviors
    public boolean isNBA() {
        if (isNBA == true) {
            return true;
        }else {
            return false;
        }
    }

    //Override - overrides "bounce" command from 'Ball'
    public void bounce(){
        System.out.println("Basketball Bouncing");
    }

}
