package com.armco.amarted.notes.ClassesMethods.OLD;

public class Cruncher {

    //   ------  DEFINE VARIABLES  ------
    private String uiName;
    private int uiAge;
    private int uiRetAge;
    private int uiDeath;
    private double uiSalary;
    private double uiInflation;


    //   ------  SET VARIABLE VALUES  ------

    //  Getters and Setters
    public String getUiName() {
        return uiName;
    }

    public void setUiName(String uiName) {
        this.uiName = uiName;
    }

    public int getUiAge() {
        return uiAge;
    }

    public void setUiAge(int uiAge) {
        this.uiAge = uiAge;
    }

    public int getUiRetAge() {
        return uiRetAge;
    }

    public void setUiRetAge(int uiRetAge) {
        this.uiRetAge = uiRetAge;
    }

    public int getUiDeath() {
        return uiDeath;
    }

    public void setUiDeath(int uiDeath) {
        this.uiDeath = uiDeath;
    }

    public double getUiSalary() {
        return uiSalary;
    }

    public void setUiSalary(double uiSalary) {
        this.uiSalary = uiSalary;
    }

    public double getUiInflation() {
        return uiInflation;
    }

    public void setUiInflation(double uiInflation) {
        this.uiInflation = uiInflation;
    }



    //   ------  SET BEHAVIORS  ------

    public int toDeath(int mDeath, int mAge){
        return mDeath - mAge;
    }

    public int ofRet(int mDeath, int mRetAge ){
        return mDeath - mRetAge;
    }

    public double intGrowth(double mInflation){
        double adjRate;
        adjRate = (getUiInflation()*100)+100;
        return adjRate;
    }

    public double newSalary(double mSalary, double mInflation){
        double adjSalary;
        adjSalary = getUiSalary() * (getUiInflation()+1);
        return adjSalary;
    }

    //Set PrintFunctions
    public void showDetails(){
        //  ---- Expected Manipulation of Printing Variables ----
        System.out.println("Name: " + uiName);
        System.out.println("Current Age: " + uiAge);
        System.out.println("Expected Age Upon Retiring: " + uiRetAge);
        System.out.println("Expected Age at Death: " + uiDeath);
        System.out.println();

        //  ---- Doing math with the variables ----
        System.out.println("Time Until Retirement: " + (uiRetAge - uiAge) + " years");
        //  ---- Using the methods I created below to calculate the math ----
        System.out.println("Time Until Death: " + toDeath(uiDeath,uiAge) + " years");
        System.out.println("Length of Retirement: " + ofRet(uiDeath,uiRetAge) + " years");
        System.out.println();

        //    ----------  Recap of all 3 types and a line-break  ----------
        System.out.println("Expected Yearly Income: $" + uiSalary);
        System.out.println("Projected Inflation Rate: " + (uiInflation*100) + "%");
        System.out.println("Adjusted Expected Income: $" + newSalary(uiSalary,uiInflation));
        System.out.println();

        //    ----------  More Complicated Function Calls  ----------
        System.out.println("Adjusted Expected Income: $" + newSalary(getUiSalary(),getUiInflation()));
        System.out.println("Total Savings Required: $" + (newSalary(getUiSalary(),getUiInflation())*ofRet(getUiDeath(),getUiRetAge())));
        System.out.println("Projected Inflation Growth: " + intGrowth(getUiInflation()) + "%");
    }


    //   ------  SET CONSTRUCTORS - NEED BLANK && ONE WITH VARIABLES  ------
    //Blank Instance
    public Cruncher(){

    }

    //All Variables Wanted ('Baseline'?)
    public Cruncher (String huiName, int huiAge, int huiRetAge, int huiDeath, double huiSalary, double huiInflation){
        uiName = huiName;
        uiAge = huiAge;
        uiRetAge = huiRetAge;
        uiDeath = huiDeath;
        uiSalary = huiSalary;
        uiInflation = huiInflation;

    }
}
