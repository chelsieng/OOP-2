// -----------------------------------------------------
// Part: 2
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------
package package4;

import package6.FlyingObject;

/**
 * @author Chelsie Ng - 40071692
 * UAV Class which inherits from FlyingObject to store weight and price
 */

public class UAV extends FlyingObject {
    protected double weight;
    protected double price;

    /**
     * This is a default constructor
     */
    public UAV() {
        weight = 0.00;
        price = 0.00;
    }

    /**
     * This is a constructor to initialize a UAV object
     *
     * @param weight initial weight
     * @param price  initial price
     */
    public UAV(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    /**
     * This is a copy constructor
     *
     * @param uav stores the other uav being copied
     */
    public UAV(UAV uav) {
        this.weight = uav.weight;
        this.price = uav.price;
    }

    /**
     * get weight of UAV
     *
     * @return weight of UAV
     */
    public double getWeight() {
        return weight;
    }

    /**
     * get price of UAV
     *
     * @return price of UAV
     */
    public double getPrice() {
        return price;
    }

    /**
     * set weight of UAV
     *
     * @param weight new weight of UAV
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * set price of UAV
     *
     * @param price new price of UAV
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * toString Method displaying all values of UAV
     *
     * @return String displaying all information about UAV
     */
    public String toString() {
        return "This UAV weighs " + weight + " pounds, and costs $" + price + "0.";
    }

    /**
     * equals Method comparing all UAV attributes
     *
     * @param object stores other object being compared
     * @return boolean value true if two objects are equal and false otherwise
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (this.getClass() == object.getClass()) {
            UAV uav = (UAV) object;
            if (this.weight == uav.weight && this.price == uav.price) {
                return true;
            }
        }
        return false;
    }
}
