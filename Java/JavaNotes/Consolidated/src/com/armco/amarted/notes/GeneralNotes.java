package com.armco.amarted.notes;

public class GeneralNotes {

    /*
                        *** REFERENCE vs OBJECT vs INSTANCE vs CLASS ***
            A CLASS is basically a blueprint for a house, using the blueprint (plans) we can
            build as many houses as we like based on those plans.
            Each house you build (in other words, instantiate using the 'new' operator)
            is an OBJECT also known as an INSTANCE.
            Each house you build has an address (a physical location).  In other words,
            if you want to tell someone where you live, you give them your address
            (perhaps written on a piece of paper). This is known as a REFERENCE.
            You can copy that REFERENCE as many times as you like, but there is still just
            one house. In other words, we are copying the paper that has the address on it,
            not the house itself.
            * We can pass REFERENCES as PARAMETERS to CONSTRUCTORS and METHODS.
     */

    /*
                       *** THIS vs SUPER and Their Uses ***
            SUPER is used to access/call the parent class members (variables and methods).
            THIS is used to call the current class members (variables and methods).
            THIS is required when we have a parameter with the same name as an instance variable (field).

            NOTE: We can use both of them anywhere in a class except STATIC areas (the static block
            or a static method). Any attempt to do so will lead to compile-time errors.

            THIS is commonly used with CONSTRUCTORS and SETTERS, and optionally in getters (easier for beginners).
            SUPER is commonly used with METHOD OVERRIDING, when we call a method with the same name from the parent class.

            In Java we have the 'this()' call and the 'super()' call.
            Notice the braces - it is known as a call since it looks like a regular method call.

            Use 'this()' to call a constructor from another overloaded constructor in the same class.
            It can be used ONLY in a constructor and it MUST be the first statement in a constructor.
            It is used with constructor chaining. In other words, when one constructor calls another constructor - helps reduce duplicated code.

            The ONLY way to call a parent constructor is by calling 'super()'.
            The Java Compiler puts a default call to 'super()' if we don't add it, and it is always the no-args super
            which is inserted by compiler (constructor without arguments).
            The 'super()' MUST be the first statement in each constructor.
            Even Abstract Classes have constructors, although you can never instantiate an abstract class using the 'new' keyword.
            An Abstract Class is still a SUPER class, so its constructors run when someone makes an instance of a concrete subclass.

            NOTE: A constructor can have a call to 'super()' or 'this()' but NEVER both!
     */

    /*
                       *** OVERLOADING vs OVERRIDING ***
            Method OVERLOADING means providing two or more separate methods in a class with the same NAME but different PARAMETERS.
            Method return type may, or may not, be different and that allows us to reuse the same method name.
            OVERLOADING is very handy, as it reduces duplicated code and we don't have to remember multiple method names.
            It does not have anything to do with POLYMORPHISM, but Java developers often refer to overloading as "Compile Time Polymorphism."
            In other words, the compiler decided which method is going to be called based on the method name, return type, and argument list.
            We can overload STATIC and INSTANCE methods. It usually happens inside a single class, but a method can also be treated
            as overloaded in the subclass of that class. That is because a subclass INHERITS one version of the method from the parent class
            and then the subclass can have another overloaded version of that method.

            NOTE: Methods must have the same method name and different parameters!
                  They may (or not) have different return types, access modifiers, or throw different checked or unchecked exceptions.


            Method OVERRIDING means defining a method in a child class that already exists in the parent class with the same signature (name & arguments).
            By extending the parent class, the child class gets all the methods defined in the parent class (those methods are known as DERIVED METHODS).
            Method overriding is also known as "Runtime Polymorphism" and "Dynamic Method Dispatch," because the method that is going to be called is decided at runtime by the JVM.

            When we OVERRIDE a method it's recommended to put "@override" immediately above the method definition. This is an annotation that the compiler reads and
            will then show us an error if we don't follow overriding rules correctly.
            We CANNOT override STATIC methods, only INSTANCE methods.
            A method will be considered overridden if we follow these rules:
               It must have the same name and same arguments
               Return type can be a subclass of the return type in the parent class
               It can't have a lower access modifier. (e.g. If the parent method is PROTECTED, we cannot use PRIVATE, but PUBLIC is okay)
            There are also some important notes about method overriding to keep in mind:
               Only inherited methods can be overridden - methods can be overridden ONLY in child classes
               CONSTRUCTORS and PRIVATE methods CANNOT be overridden
               Methods that are FINAL cannot be overridden
               A subclass can use "super.methodName()" to call the superclass version of an overridden method
     */

    /*

            STATIC METHODS are declared using a "static" modifier.
            They can't access instance methods and instance variables directly.
            They are usually used for operations that don't require any data from an instance of the class (from 'this').
            Whenever you see a method that does not use instance variables, it should be declared as a STATIC METHOD.
            For example, "main" is a static method and it is called by the JVM when it starts an application.

            INSTANCE METHODS belong to a specific instance of a class. To use an instance method we have to
            instantiate the class first, usually by using the "new" keyword.
            They can access other INSTANCE methods and variables and STATIC ones.

            NOTE: If a method uses any fields (instance variables) or instance methods, it should also be an INSTANCE METHOD
                  If not, then it should probably be a STATIC METHOD.

            STATIC VARIABLES are also known as "static member variables" and are declared with the "static" keyword.
            Every instance of that class shares the same static variable. If changes are made to that variable,
            all other instances will see the effect of the change.
            STATIC variables are not used very often, but can sometimes ve very useful. For example, when reading
            user input using SCANNER we will declare scanner as a static variable. That way ALL static methods can access it directly.


            INSTANCE VARIABLES don't use the "static" keyword.
            They are also known as fields or member variables and belong to an instance of a class.
            Each instance has it's own copy of an instance variable with different values (state).
            Instance variables represent the state of an instance.
     */

    /*
                        *** REFERENCE TYPES vs VALUE TYPES ***

     */
}
