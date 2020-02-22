// -----------------------------------------------------
// Part: 2
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------
package package1;

import package6.FlyingObject;

/**
 * @author Chelsie Ng - 40071692
 * Airplane Class which inherits from FlyingObject to stores brand, price and horsePower
 */

public class Airplane extends FlyingObject {
    protected String brand;
    protected double price;
    protected int horsePower;

    /**
     * This is a default constructor
     */
    public Airplane() {
        brand = "";
        price = 0.00;
        horsePower = 0;
    }

    /**
     * This is a constructor to initialize an Airplane object
     *
     * @param brand      initial brand name
     * @param price      initial price
     * @param horsePower initial horse power
     */
    public Airplane(String brand, double price, int horsePower) {
        this.brand = brand;
        this.price = price;
        this.horsePower = horsePower;
    }

    /**
     * This is a copy constructor
     *
     * @param a stores the other airplane being copied
     */
    public Airplane(Airplane a) {
        this.brand = a.brand;
        this.price = a.price;
        this.horsePower = a.horsePower;
    }

    /**
     * get brand of airplane
     *
     * @return brand of airplane
     */
    public String getBrand() {
        return brand;
    }

    /**
     * get price of airplane
     *
     * @return price of airplane
     */
    public double getPrice() {
        return price;
    }

    /**
     * get horse power of airplane
     *
     * @return horsepower of airplane
     */
    public int getHorsePower() {
        return horsePower;
    }

    /**
     * set brand of airplane
     *
     * @param brand new brand of airplane
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * set price of airplane
     *
     * @param price new price of airplane
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * set horse power of airplane
     *
     * @param horsePower new horse power of airplane
     */
    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    /**
     * toString Method displaying all values of Airplane
     *
     * @return String displaying all information about Airplane
     */
    public String toString() {
        return "This airplane is manufactured by " + brand + ". It costs $" + price + "0 and has " + horsePower + "hp.";
    }

    /**
     * equals Method comparing all airplane attributes
     *
     * @param object stores other object being compared
     * @return boolean value true if two objects are equal and false otherwise
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            Airplane a = (Airplane) object;
            if (this.brand.equals(a.brand) && this.price == a.price && this.horsePower == a.horsePower) {
                return true;
            }
        }
        return false;
    }
}
