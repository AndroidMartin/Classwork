package com.armco.amarted.notes.Arrays.LinkedLists;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();

//        // original way to add, if we didn't write the alphabetizing method
//        placesToVisit.add("Sydney");
//        placesToVisit.add("Melbourne");
//        placesToVisit.add("Brisbane");
//        placesToVisit.add("Perth");
//        placesToVisit.add("Camberra");
//        placesToVisit.add("Adelaide");
//        placesToVisit.add("Darwin");

        addInOrder(placesToVisit,"Sydney");
        addInOrder(placesToVisit,"Melbourne");
        addInOrder(placesToVisit,"Brisbane");
        addInOrder(placesToVisit,"Perth");
        addInOrder(placesToVisit,"Camberra");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Darwin");

        printList(placesToVisit);

        addInOrder(placesToVisit,"Alice Springs");
        addInOrder(placesToVisit,"Darwin");
        //    ^-- should throw error because it's already been added
        printList(placesToVisit);

        placesToVisit.remove(4-1);
        printList(placesToVisit);

        visit(placesToVisit);
    }



    private static void printList(LinkedList<String> linkedList){
        int j = 0;
        Iterator<String> i = linkedList.iterator();  // <-- similar to the for loop we used in arrays
        while (i.hasNext()) {
            j++;
            System.out.println(j +". Now visiting " + i.next());
        }
        System.out.println("=======================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList,String newCity){
        ListIterator<String> stringListIterator = linkedList.listIterator();
        //   ^^^--- is only an iterator, still doesn't have value <needs next()>
        while(stringListIterator.hasNext()){
            int comparison = stringListIterator.next().compareTo(newCity);
            if(comparison == 0) {
                // equal, do not add
                System.out.println(newCity + " is already included.");
                return false;
            } else if(comparison > 0) {
                //  new city should appear before this one
                //  Brisbane -> Adelaide
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if(comparison < 0) {
                // move on to next city
            }
        }
        // new city belongs at end of list
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        //  ^- need to remember our direction in the list to prevent duplicate result
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()){
            System.out.println("No Cities Entered");
            return;
        } else {
            System.out.println("Now Visiting " +listIterator.next());
            printMenu();
        }

        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Vacation over");
                    quit = true;
                    break;
                case 1:  //  MOVE FORWARD
                    // if we aren't going forward, we need to start
                    if(!goingForward) {
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    // then we implement our next code (move+)
                    if(listIterator.hasNext()) {
                        System.out.println("Now Visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached end of list");
                        goingForward = false;
                    }
                    break;
                case 2:  //  MOVE BACKWARDS
                    // if we're not going backward, we start heading that way
                    if(goingForward) {
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    // then we implement our next code (move-)
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available Actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - display menu options");
    }

}
