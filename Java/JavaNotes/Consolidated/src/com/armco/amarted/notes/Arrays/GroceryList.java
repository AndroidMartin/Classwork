package com.armco.amarted.notes.Arrays;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<>(); // <--defines new array list


    public void addGroceryItem(String item){
        groceryList.add(item);
    }

    public void printGroceryList(){
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i=0; i<groceryList.size(); i++){
            System.out.println((i+1) + ". " + groceryList.get(i));
        }
    }

    public void editGroceryItem(String currentItem, String newItem){
        int position = findItem(currentItem);
        if(position >= 0) {
            editGroceryItem(position,newItem);
        }
    }
    private void editGroceryItem(int position, String newItem){
        groceryList.set(position,newItem);
        System.out.println("Grocery item " + (position+1) + " has been modified.");
    }

    public void removeGroceryItem(String item){
        int position = findItem(item);
        if(position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position){
//        String theItem = groceryList.get(position);
        groceryList.remove(position);
//        System.out.println("Removed " + theItem);
    }

    private int findItem(String searchItem){
//        boolean exists = groceryList.contains(searchItem);
        return  groceryList.indexOf(searchItem);
//        int position = groceryList.indexOf(searchItem);
//        if(position >= 0){
//            return groceryList.get(position);
//        }
//        return null;
    }

    public boolean onFile(String searchItem){
        int position = findItem(searchItem);
        if(position >= 0) {
            return true;
        }
        return false;
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }
}
