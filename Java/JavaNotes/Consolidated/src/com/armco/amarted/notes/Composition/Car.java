package com.armco.amarted.notes.Composition;

public class Car extends Vehicle {
    private int doors;
    private int engineCapacity;

    public Car(String name, int doors, int engineCapacity) {
        super(name);
        this.doors = doors;
        this.engineCapacity = engineCapacity;
    }

    /*  Above is an example of inheritance.  A "Car" is a Vehicle, it inherits everything from car and every
        every "Car" is a type of Vehicle.  This is an example of IS-A relationship (x IS-A y).

        Composition possesses a HAS-A relationship.  A computer HAS-A motherboard, case, and monitor.  But those
        things are NOT a computer.  Likewise, a monitor has a resolution, but the resolution isn't the monitor.
        A case has dimensions, but dimensions are not cases.  Noticing the pattern?!
     */
}
