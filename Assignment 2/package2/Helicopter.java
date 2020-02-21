// -----------------------------------------------------
// Part: 1
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------
package package2;

import package1.Airplane;

/**
 * @author Chelsie Ng - 40071692
 * Helicopter Class which inherits from Airplane
 */
public class Helicopter extends Airplane {
    protected int numOfCylinders;
    protected int creationYear;
    protected int passengerCapacity;

    /**
     * This is a default constructor
     */
    public Helicopter() {
        super();
        numOfCylinders = 0;
        creationYear = 0;
        passengerCapacity = 0;
    }

    /**
     * This is a constructor to initialize a Helicopter object
     *
     * @param brand             initial brand name
     * @param price             initial price
     * @param horsePower        initial horse power
     * @param numOfCylinders    initial number of cylinders
     * @param creationYear      initial  year created
     * @param passengerCapacity initial passenger capacity
     */
    public Helicopter(String brand, double price, int horsePower, int numOfCylinders, int creationYear, int passengerCapacity) {
        super(brand, price, horsePower);
        this.numOfCylinders = numOfCylinders;
        this.creationYear = creationYear;
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * This is a copy constructor
     *
     * @param h stores the other helicopter being copied
     */
    public Helicopter(Helicopter h) {
        this.brand = h.brand;
        this.price = h.price;
        this.horsePower = h.horsePower;
        this.numOfCylinders = h.numOfCylinders;
        this.creationYear = h.creationYear;
        this.passengerCapacity = h.passengerCapacity;
    }

    /**
     * get number of cylinders of Helicopter
     *
     * @return number of cylinders of Helicopter
     */
    public int getNumOfCylinders() {
        return numOfCylinders;
    }

    /**
     * get creation year of Helicopter
     *
     * @return creation year of Helicopter
     */
    public int getCreationYear() {
        return creationYear;
    }

    /**
     * get passenger capacity of Helicopter
     *
     * @return passenger capacity of Helicopter
     */
    public int getPassengerCapacity() {
        return passengerCapacity;
    }


    /**
     * set number of cylinders of Helicopter
     *
     * @param numOfCylinders new number of cylinders of Helicopter
     */
    public void setNumOfCylinders(int numOfCylinders) {
        this.numOfCylinders = numOfCylinders;
    }

    /**
     * set creation year of Helicopter
     *
     * @param creationYear new creation year of Helicopter
     */
    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    /**
     * set passenger capacity of Helicopter
     *
     * @param passengerCapacity new passenger capacity of Helicopter
     */
    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * toString Method displaying all values of Helicopter
     *
     * @return String displaying all information about Helicopter
     */
    public String toString() {
        return "This helicopter is manufactured by " + brand + " and was created in " + creationYear + ". It costs $" + price + "0 and has " + horsePower + "hp. It has " + numOfCylinders + " sets of cylinders and can hold up to " + passengerCapacity + " passengers.";
    }

    /**
     * equals Method comparing all helicopter attributes
     *
     * @param object stores other object being compared
     * @return boolean value true if two objects are equal and false otherwise
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            Helicopter h = (Helicopter) object;
            if (this.brand.equals(h.brand) && this.price == h.price && this.horsePower == h.horsePower && this.numOfCylinders == h.numOfCylinders && this.creationYear == h.creationYear && this.passengerCapacity == h.passengerCapacity) {
                return true;
            }
        }
        return false;
    }
}
