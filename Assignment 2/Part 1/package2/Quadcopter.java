// -----------------------------------------------------
// Part: 1
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------
package package2;

/**
 * @author Chelsie Ng - 40071692
 * Quadcopter Class which inherits from Helicopter
 */
public class Quadcopter extends Helicopter {
    private int maxFlyingSpeed;

    /**
     * This is a default constructor
     */
    public Quadcopter() {
        super();
        maxFlyingSpeed = 0;
    }

    /**
     * This is a constructor to initialize a Quadcopter object
     *
     * @param brand             initial brand name
     * @param price             initial price
     * @param horsePower        initial horse power
     * @param numOfCylinders    initial number of cylinders
     * @param creationYear      initial year created
     * @param passengerCapacity initial passenger capacity
     * @param maxFlyingSpeed    initial maximum flying speed
     */
    public Quadcopter(String brand, double price, int horsePower, int numOfCylinders, int creationYear, int passengerCapacity, int maxFlyingSpeed) {
        super(brand, price, horsePower, numOfCylinders, creationYear, passengerCapacity);
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    /**
     * This is a copy  constructor
     *
     * @param q stores the other quadcopter being copied
     */
    public Quadcopter(Quadcopter q) {
        this.brand = q.brand;
        this.price = q.price;
        this.horsePower = q.horsePower;
        this.numOfCylinders = q.numOfCylinders;
        this.creationYear = q.creationYear;
        this.passengerCapacity = q.passengerCapacity;
        this.maxFlyingSpeed = q.maxFlyingSpeed;
    }

    /**
     * get maximum flying speed of Quadcopter
     *
     * @return maximum flying speed of Quadcopter
     */
    public int getMaxFlyingSpeed() {
        return maxFlyingSpeed;
    }

    /**
     * set maximum flying speed of Quadcopter
     *
     * @param maxFlyingSpeed new maximum flying speed of Quadcopter
     */
    public void setMaxFlyingSpeed(int maxFlyingSpeed) {
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    /**
     * toString Method displaying all values of Quadcopter
     *
     * @return String displaying all information about Quadcopter
     */
    public String toString() {
        return "This quadcopter is manufactured by " + brand + " and was created in " + creationYear + ". It costs $" + price + "0. It has " + horsePower + "hp and a maximum flying speed of " + maxFlyingSpeed + " miles per hour. It has " + numOfCylinders + " sets of cylinders and can hold up to " + passengerCapacity + " passengers.";
    }

    /**
     * equals Method comparing all Quadcopter attributes
     *
     * @param object stores other object being compared
     * @return boolean value true if two objects are equal and false otherwise
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            Quadcopter q = (Quadcopter) object;
            if (this.brand.equals(q.brand) && this.price == q.price && this.horsePower == q.horsePower && this.numOfCylinders == q.numOfCylinders && this.creationYear == q.creationYear && this.passengerCapacity == q.passengerCapacity && this.maxFlyingSpeed == q.maxFlyingSpeed) {
                return true;
            }
        }
        return false;
    }
}
