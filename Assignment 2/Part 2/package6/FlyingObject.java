// -----------------------------------------------------
// Part: 2
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------
package package6;

/**
 * @author Chelsie Ng - 40071692
 * FlyingObject Class
 */
public class FlyingObject {
    protected double price;

    /**
     * This is a default constructor
     */
    public FlyingObject() {
        price = 0.0;
    }

    /**
     * This is a constructor to initialize a flyingobject object
     * @param price initial price
     */
    public FlyingObject(double price) {
        this.price = price;
    }

    /**
     * This is a copy constructor
     * @param flyingObject stores the other flying object being copied
     */
    public FlyingObject(FlyingObject flyingObject) {
        this.price = flyingObject.price;
    }

    /**
     * get price of flying object
     * @return price of flying object
     */
    public double getPrice() {
        return price;
    }

    /**
     * toString Method displaying information about flying object
     * @return string displaying information about flying object
     */
    public String toString(){
        return "This flying object costs $" + price + "0.";
    }

}

