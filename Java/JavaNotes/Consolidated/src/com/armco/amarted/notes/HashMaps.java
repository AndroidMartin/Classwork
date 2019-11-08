package com.armco.amarted.notes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMaps {

    public static void myHashMap(){
        // Create new HashMap
        HashMap users = new HashMap();

        //Manually assign the types for HashMaps (Key=Integer, Value=String)
        HashMap<Integer, String> newUsers = new HashMap<>();
        newUsers.put(28, "Becky");
        // System.out.println(newUsers.set);  // <--"set" is not working when imported into this project

        // Add to the HashMap
        users.put("Sandra", 28);
        users.put("Andrew", 38);
        users.put("Jenn", 40);
        users.put("George",47);

        // Remove entry to the HashMap
        users.remove("Sandra");

        // Print Entries
        System.out.println(users.entrySet());
        System.out.println(users.get("Jenn"));

        // Iterator
        Iterator myIterator = users.entrySet().iterator();
        while (myIterator.hasNext()) {
            Map.Entry pair = (Map.Entry) myIterator.next();
            System.out.println("Key: " + pair.getKey() + " Value: " + pair.getValue());
        }


        // How to Specify HashMap Types - Best to preselect types if possible

        newUsers.put(28, "Becky");
        System.out.println();


        // *** LOOKUP HASHMAPS AND THEIR FULL USAGE ON YOUR OWN ***


        //Full Usage Example Below
        HashMap fullExample = new HashMap();
        fullExample.put("Leo", 27);
        fullExample.put("Mac", 24);
        fullExample.put("Sophia", 34);
        fullExample.remove("Sophia");

        System.out.println(fullExample.entrySet());
    }
}
