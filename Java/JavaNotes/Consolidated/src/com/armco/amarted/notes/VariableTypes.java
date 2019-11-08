package com.armco.amarted.notes;

public class VariableTypes {

    // NOTE: You can use underscore as a place separator: 3_483_861


//      ===== VARIABLE TYPES =====

    //String - USE DOUBLE QUOTES
    String myName = "Andrew";
    String lastName = "Martin";

    //Integers - Whole numbers (max value is 2,147,483,648 - 32 bits)
    int myAge = 36;

    //Byte - Very small type (max value 127 - 8 bits)
    byte myByte = 127;

    //Short - 2x Byte [or is it squared?]
    short myShort = 128;

    //Long - Very big numbers (max value is 9,223,372,036,854,775,807 - 64 bits) - MUST USE THE "L" AFTER THE NUMBER
    long myLong = 3000000L;

    //Float - Decimal {1.34, 3.14,...) - MUST USE THE "f" AFTER THE NUMBER
    float piNum = 3.14f;

    //Double - Bigger than 'Decimal' - Best for currency and math
    double myDouble = 23.89;

    //Char = Character {e.g. &, $, @, ., etc.} - USE SINGLE QUOTES
    char myChar = 'j';

    //Boolean - True or False, 1 or 0
    boolean myBool = false;

    public void varBasicExample() {
        System.out.println("My age is "+ myAge + " (" + myBool + ")");
    }


    /*     ===== CASTING =====
     *   Java by default uses integers and doubles (whole numbers and decimals), so if you are using "literal values"
     *   you must tell the system that you are certain that the result will be of that type.  That is when casting
     *   comes into play.  In the examples below, the number '2' in the expression is treated as an integer by default,
     *   so you use Casting (by putting the type in parentheses before the expression) to alert the compiler that
     *   the integer will be converted into that type by the end of the expression.
     */
    byte myNewByteValue = (byte)(Byte.MIN_VALUE/2);   // <--Need to "Cast" because '2' is an integer, not a byte
    short myNewShortValue = (short)(Short.MAX_VALUE/2);



    //  EXTRA INFORMATION - used to output variable info by calling displayVariableInfo Method

    static String text1 = "   Size: ";
    static String text2 = " bits   Range: ";
    static String text3 = " -TO- ";
    static String text4 = "   Example Value: ";
    static String text5 = "   USAGE: ";


    public static void booleanStats() {
        String name = "BOOLEAN";
        boolean max = Boolean.TRUE;
        boolean min = Boolean.FALSE;
        byte size = 1;
        boolean value = Boolean.FALSE;
        boolean i = true;
        String example = "boolean isMale = " + i;
        System.out.println(name + text1 + size + text2 + min + text3 + max + text4 + value + text5 + example);
    }


    public static void byteStats() {
        String name = "BYTE";
        byte max = Byte.MAX_VALUE;
        byte min = Byte.MIN_VALUE;
        byte size = 8;
        byte value = (byte)(max/2);
        byte i = 123;
        String example = "byte myByte = " + i;
        System.out.println(name + text1 + size + text2 + min + text3 + max + text4 + value + text5 + example);
    }


    public static void shortStats() {
        String name = "SHORT";
        short max = Short.MAX_VALUE;
        short min = Short.MIN_VALUE;
        byte size = 16;
        short value = (short)(max/2);
        short i = 21605;
        String example = "short myShort = " + i;
        System.out.println(name + text1 + size + text2 + min + text3 + max + text4 + value + text5 + example);
    }

    public static void intStats() {
        String name = "INT";
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        byte size = 32;
        int value = max/2;
        int i = 1_764_223_456;
        String example = "int myInt = 1_764_223_456";
        System.out.println(name + text1 + size + text2 + min + text3 + max + text4 + value + text5 + example);
    }

    public static void longStats() {
        String name = "LONG";
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        byte size = 64;
        long value = max/2;
        long i = 2_165_697_462L;
        String example = "long myLong = 2_165_697_462L";
        System.out.println(name + text1 + size + text2 + min + text3 + max + text4 + value + text5 + example);
    }

    public static void floatStats() {
        String name = "FLOAT";
        float max = Float.MAX_VALUE;
        float min = Float.MIN_VALUE;
        byte size = 32;
        float value = max/2;
        float myFloat = 1.3468521674f;
        String example = "float myFloat = 1.3468521674f";
        String notes = "Not generally recommended to use";
        System.out.println(name + text1 + size + text2 + min + text3 + max + text4 + value + text5 + example);
    }

    public static void doubleStats() {
        String name = "DOUBLE";
        double max = Double.MAX_VALUE;
        double min = Double.MIN_VALUE;
        byte size = 64;
        double value = max/2;
        double myDouble = Math.PI;
        String example = "double myDouble = Math.PI   : " + myDouble;
        String notes = "Considered the default decimal type due to it's accuracy";
        System.out.println(name + text1 + size + text2 + min + text3 + max + text4 + value + text5 + example);
    }




    // non-numerical types
    public static void charStats() {
        String name = "CHAR";
        byte sizeChar = 16;
        String exChar = "$";
//    the reason Java allows 16 bits is so that all characters in all languages can be represented
    }

    public static void stringStats() {
        String name = "STRING";
        byte sizeString = 32;
        String exString = "This is an example of a String...";
//     Strings are actually a method, not a variable.
//     It's limited by memory or the MAX_VALUE of int, which is 2.14 Billion characters.
    }


    public static void displayVariableInfo(){
    // TODO: Make this method work and call the information above
        booleanStats();
        byteStats();
        shortStats();
        intStats();
        longStats();
        floatStats();
        doubleStats();
        MemoryAllocation.decimalExamples();

    }

}
