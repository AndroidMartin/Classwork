package com.armco.amarted.notes;

public class ParsingValues {

    public static void parseStringToNumber(int a){
        String numberAsString = "2018";
        System.out.println("numberAsString = " + numberAsString);

        int number = Integer.parseInt(numberAsString);

        numberAsString += 1;
        number += 1;

        System.out.println(numberAsString + " / " + number);


        double numberDub = Double.parseDouble(numberAsString);
        numberDub += .125;
        numberAsString += .125;
    }

}
