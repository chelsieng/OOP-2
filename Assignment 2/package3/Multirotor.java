// -----------------------------------------------------
// Part: 1
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------
package package3;

import package2.Helicopter;

/**
 * @author Chelsie Ng - 40071692
 * Multirotor Class which inherits from Helicopter
 */
public class Multirotor extends Helicopter {
    private int numOfRotors;

    /**
     * This is a default constructor
     */
    public Multirotor() {
        super();
        numOfRotors = 0;
    }

    /**
     * This is a constructor to initialize a Multirotor object
     *
     * @param brand             initial brand name
     * @param price             initial price
     * @param horsePower        initial horse power
     * @param numOfCylinders    initial number of cylinders
     * @param creationYear      initial year created
     * @param passengerCapacity initial passenger capacity
     * @param numOfRotors       initial number of rotors
     */
    public Multirotor(String brand, double price, int horsePower, int numOfCylinders, int creationYear, int passengerCapacity, int numOfRotors) {
        super(brand, price, horsePower, numOfCylinders, creationYear, passengerCapacity);
        this.numOfRotors = numOfRotors;
    }

    /**
     * This is a copy constructor
     *
     * @param m stores the other multirotor being copied
     */
    public Multirotor(Multirotor m) {
        this.brand = m.brand;
        this.price = m.price;
        this.horsePower = m.horsePower;
        this.numOfCylinders = m.numOfCylinders;
        this.creationYear = m.creationYear;
        this.passengerCapacity = m.passengerCapacity;
        this.numOfRotors = m.numOfRotors;
    }

    /**
     * get number of rotors of Multirotor
     *
     * @return number of rotors of Multirotor
     */
    public int getNumOfRotors() {
        return numOfRotors;
    }

    /**
     * set number of rotors of Multirotor
     *
     * @param numOfRotors new number of rotors of Multirotor
     */
    public void setNumOfRotors(int numOfRotors) {
        this.numOfRotors = numOfRotors;
    }

    /**
     * toString Method displaying all values of Multirotor
     *
     * @return String displaying all information about Multirotor
     */
    public String toString() {
        return "This multirotor is manufactured by " + brand + " and was created in " + creationYear + ". It costs $" + price + "0 and has " + horsePower + "hp. It has " + numOfCylinders + " set of cylinders, " + numOfRotors + " rotors and can hold up to " + passengerCapacity + " passengers.";
    }

    /**
     * equals Method comparing all multirotor attributes
     *
     * @param object stores other object being compared
     * @return boolean value true if two objects are equal and false otherwise
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            Multirotor m = (Multirotor) object;
            if (this.brand.equals(m.brand) && this.price == m.price && this.horsePower == m.horsePower && this.numOfCylinders == m.numOfCylinders && this.creationYear == m.creationYear && this.passengerCapacity == m.passengerCapacity && this.numOfRotors == m.numOfRotors) {
                return true;
            }
        }
        return false;
    }
}
