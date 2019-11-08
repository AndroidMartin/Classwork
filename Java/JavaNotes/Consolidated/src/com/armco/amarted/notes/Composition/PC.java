package com.armco.amarted.notes.Composition;

public class PC {
    private Case theCase;  // <-- "case" is a reserved keyword, so it cannot be used here, MUST use a variant like "theCase"
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp(){
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo(){
        //Fancy splash screen graphics
        monitor.drawPixelAt(1200,50,"yellow");
    }






//    private Case getTheCase() {
//        return theCase;
//    }
//
//    private Monitor getMonitor() {
//        return monitor;
//    }
//
//    private Motherboard getMotherboard() {
//        return motherboard;
//    }
}
