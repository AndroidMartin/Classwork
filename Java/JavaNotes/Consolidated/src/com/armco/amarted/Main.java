package com.armco.amarted;

import com.armco.amarted.notes.Arrays.ArrayLists;
import com.armco.amarted.homework.Arrays.MinimumElement;
import com.armco.amarted.homework.Arrays.ReverseArray;
import com.armco.amarted.homework.Homework;
import com.armco.amarted.homework.Room.*;
import com.armco.amarted.notes.*;
import com.armco.amarted.notes.Arrays.Arrays;
import com.armco.amarted.notes.ClassesMethods.CarMain;
import com.armco.amarted.notes.ClassesMethods.Constructors.BankAccount;
import com.armco.amarted.notes.ClassesMethods.Constructors.VipCustomer;
import com.armco.amarted.notes.Composition.*;
import com.armco.amarted.notes.Encapsulation.*;
import com.armco.amarted.notes.Inheritance.AgentCar;
import com.armco.amarted.notes.Inheritance.Car;
import com.armco.amarted.notes.Inheritance.InheritanceMain;
import com.armco.amarted.notes.Inheritance.Vehicle;
import com.armco.amarted.notes.Polymorphism.PolymorphMain;

public class Main {

    public static void main(String[] args) {
/*
 *                *** GENERAL NOTES ***
 *  public static void main(String[] args) {}
 *     1     2     3    4      5      6     7
 *
 *   1) Access Permissions(public, private, or Protected) - See Ball.java
 *   2)
 *   3) Return Type (void= no return; examples: String, Char, Boolean - any variable type)
 *   4) Name (user determines the name of the class or method)
 *   5) Declaration of Variables (e.g. String firstName, boolean iTerm, etc)
 *   6) Values to Pass On (e.g. a:4 b:5)
 *   7) Code Block - where your code goes
 *   *** SEE MethodBasics FOR MORE EXAMPLES ***
 *
 *   Classes - Blueprint of objects (need properties - see Ball.java)
 *   Methods - Enclosed statements that perform an operation (generally return a value)
 */

/*      When using an IDE (IntelliJ or AndroidStudio), they will usually suggest which variable you are calling as
        you type.  They will denote the name with the following:
        p = Parameter
        f = Field (variable)
        m = Method
        c = Class
        i = ???
        lighteningBolt = ???

        If it has a lock next to it, it is showing if it is "private" (locked) or "public" (unlocked)
 */


//      ***  DECIDE WHAT TO OUTPUT HERE  ***
        System.out.println();
        //  ^---- keep above line for formatting purposes


        System.out.println("         ----- DISPLAYING VARIABLE TYPE INFORMATION -----");
        VariableTypes.displayVariableInfo();
        System.out.println();
        MemoryAllocation.decimalExamples();
        System.out.println("         ----- DEMONSTRATING FIRST USE OF OPERATORS -----");
        Homework.lbsToKilos();
        Homework.operatorChallenge();
        Homework.scoreChallenge();
        System.out.println("\n         ----- FIRST METHODS BEING CALLED -----");
        int position = Homework.calculateHighScorePosition(1500);
        Homework.displayHighScorePosition("Andrew", position);
        position = Homework.calculateHighScorePosition(900);
        Homework.displayHighScorePosition("Billy", position);
        position = Homework.calculateHighScorePosition(400);
        Homework.displayHighScorePosition("Chris", position);
        position = Homework.calculateHighScorePosition(50);
        Homework.displayHighScorePosition("Nikki", position);
        System.out.println("\nHOMEWORK CALCULATIONS");
        System.out.println(Homework.calcFeetAndInchesToCentimeters(8));
        System.out.println(Homework.calcFeetAndInchesToCentimeters(7,5));
        System.out.println(Homework.getDurationString(420,42));
        System.out.println(Homework.getDurationString(-3945));
        Homework.printSwitchStatement('B');
        Homework.printDayOfTheWeek(2);
        System.out.println("\nCALCULATING INTEREST RATES");
        Homework.printInterest(10000);
        System.out.println("PRINTING MULTIPLES OF 15");
        Homework.print3and5();
        System.out.println("\n         ----- RUNNING IF,FOR,WHILE LOOPS -----");
        IfForWhile.doLoop();
        System.out.println("-CALCULATING VALUES BETWEEN 4 AND 20-");
        Homework.printEvenNumbers(4,20);
        IfForWhile.whileContinue(4,20);
        Homework.testEven(4,20);
        System.out.println("-ADDING DIGITS OF FIGURES-");
        System.out.println(Homework.sumDigits(125));
        System.out.println(Homework.sumDigits(-125));
        System.out.println(Homework.sumDigits(4));
        System.out.println(Homework.sumDigits(32123));
        System.out.println("-PARSING A STRING TO A NUMBER-");
        ParsingValues.parseStringToNumber(2018);
        System.out.println("\n         ----- USER INPUT REQUIRED-----");
        System.out.println("      Comment/Uncomment method calls to activate");
        System.out.println("        (it's annoying to enter info each time)");
//        UserInput.readingUserInput();
        /* ToDo: fix the input settings on the following
        Homework.mySumTenNumbers();
        Homework.instructorSumTenNumbers();
        Homework.printMinAndMax(); */
        System.out.println("\n         ----- CALLING MULTIPLE CLASSES-----");
        CarMain.callCarMain();

        // Creating and using constructors with the BankAccount.java
        System.out.println("\n         ----- CONSTRUCTOR USAGE-----");
        System.out.println("USING BLANK CONSTRUCTOR");
        BankAccount lindasAccount = new BankAccount();
        System.out.println("Linda's phone number: " + lindasAccount.getPhone());
        System.out.println("Linda's Balance: " + lindasAccount.getBalance());
        System.out.println("\nUSING CONSTRUCTOR WITH PARAMETERS");
        BankAccount bobsAccount = new BankAccount(12345,0.0,"Bob Brown","bobbyBrown@gmail.com","857-555-2020");
        bobsAccount.withdrawFunds(100.00);  // <--Balance is 0, so insufficient funds
        bobsAccount.depositFunds(250.00);
        bobsAccount.withdrawFunds(100.00);
        System.out.println("Bob's Account #: "+bobsAccount.getAccountNum());
        System.out.println("Bob's Email: "+bobsAccount.getEmail());

        // USE VipCustomer TO DEMONSTRATE CONSTRUCTORS
        System.out.println("\n-DEMONSTRATE MULTIPLE CONSTRUCTORS-");
        VipCustomer person1 = new VipCustomer();
        System.out.println(person1.getName());
        System.out.println(person1.getCreditLimit());
        VipCustomer person2 = new VipCustomer("Beth","beth@email.com");
        System.out.println(person2.getName());
        System.out.println(person2.getCreditLimit());
        VipCustomer person3 = new VipCustomer("Tim",250000.0,"tim@gmail.com");
        System.out.println(person3.getName());
        System.out.println(person3.getCreditLimit());

        System.out.println("\n         ----- INHERITANCE AND USING 'EXTENDS'-----");
        System.out.println("*** ACTIVATING ANIMALS ***");
        InheritanceMain.callMain();


        System.out.println("\nCALLING UPON VEHICLE INHERITANCES");
//        Vehicle monorail = new Vehicle(0,110);
//        Car toyotaSedan = new Car(40,1);
//        BondCar agent007 = new BondCar(80,-1,false,"Mini-Rockets");
//        System.out.println("Monorail Speed: " + monorail.getSpeed());
//        System.out.println("Sedan Speed: " + toyotaSedan.getSpeed());
//        System.out.println("Bond's Speed: " + agent007.getSpeed());
//        agent007.setSpeed(90);
//        System.out.println("Bond's NEW Speed: " + agent007.getSpeed());
        Vehicle excellaTrain = new Vehicle("ExcellaTrain","Modular");
        Car honda = new Car("Accord","Asian",4,4,5,true);
        AgentCar agent007 = new AgentCar("Mini-Rockets",false);
//        excellaTrain.stop();
//        honda.stop();
//        agent007.stop();
//        honda.changeVelocity(5,90);
        agent007.activateWeapon();
        agent007.steer(45);
        agent007.accelerate(12);
        agent007.accelerate(23);
        agent007.accelerate(-30);

        System.out.println("\n         ----- COMPOSITION over INHERITANCE-----");
        // Composition Example
        System.out.println("\n- SHOWING EXAMPLE OF COMPOSITION -");
        Dimensions myDimensions = new Dimensions(20, 20, 5);
        Case myCase = new Case("220B", "Dell", "240", myDimensions);
        Monitor myMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));
        //                           create an instance of a class without making a variable ---^   by 'passing' a "new" in the parameters
        Motherboard myMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePC = new PC(myCase,myMonitor,myMotherboard);
//        thePC.getTheCase().pressPowerButton();
//        thePC.getMotherboard().loadProgram("Start OS: Ubuntu 18.04");
//        thePC.getMonitor().drawPixelAt(1500,1200,"red");
        thePC.powerUp();

        System.out.println("\nMaking a bedroom");
        Wall wall1 = new Wall("North");
        Wall wall2 = new Wall("East");
        Wall wall3 = new Wall("South");
        Wall wall4 = new Wall("West");
        Ceiling ceiling = new Ceiling(8,5);
        Bed bed = new Bed("Murphy",2,36,1000,2);
        Lamp myLamp = new Lamp("Gooseneck",false,60);
        Bedroom bedRoom = new Bedroom("Tim's",wall1,wall2,wall3,wall4,ceiling,bed,myLamp);
        bedRoom.getLamp().turnOn();
        bedRoom.makeBed();

        System.out.println("\n         ----- EXAMPLE(S) OF ENCAPSULATION-----");
        // ENCAPSULATION
        System.out.println("\nEXAMPLE(S) OF ENCAPSULATION");
        Player player1 = new Player();
        player1.name = "Tim";
        player1.health = 20;
        player1.weapon = "Sword";
        int damage = 10;
        player1.loseHealth(damage);
        System.out.println(player1.name + " took " + damage + " damage\nRemaining Health = " + player1.healthRemaining());
        damage = 11;
        player1.loseHealth(damage);
        System.out.println(player1.name + " took " + damage + " damage\nRemaining Health = " + player1.healthRemaining());
        // Proper Usage of Encapsulation Below
        EnhancedPlayer player2 = new EnhancedPlayer("Tom",150,"Bow");
        System.out.println("Initial health for " + player2.getName() + " is " + player2.getHealth());
        player2.loseHealth(30);
        // My 'Homework' on Encapsulation
        System.out.println("- PRINTER HOMEWORK -");
        Toner myToner = new Toner(100);
        Printer printer1 = new Printer(true,300,5);
        printer1.print();
        printer1.print(4);
        printer1.print(25);
        printer1.addToner(40);
        Printer printer2 = new Printer(false,500,1);
        printer2.print(125);
        printer2.addToner(50);
        System.out.println(printer2.getToner());
        System.out.println(printer1.isDuplex());
        System.out.println(printer2.isDuplex());

        System.out.println("\n         ----- POLYMORPHISM-----");
        System.out.println("*** RUNNING MOVIES ***");
        PolymorphMain.grabMovie();

        System.out.println("\n         ----- ARRAYS-----");
        Arrays.myArrays();
        int[] array = {200,220,240,260,280};
//        Arrays.printArray(array);
//        Arrays.printVarArray();
//        MinimumElement.minArray(5);
//        ReverseArray.myArray(5);
//        ReverseArray.profMain();

        ArrayLists.myGroceryList();


    }
}
