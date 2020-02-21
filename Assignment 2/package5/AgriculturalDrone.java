// -----------------------------------------------------
// Part: 1
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------
package package5;

import package4.UAV;
/**
 * @author Chelsie Ng - 40071692
 * AgriculturalDrone Class which inherits from UAV
 */
public class AgriculturalDrone extends UAV {
    private String brand;
    private int carryCapacity;

    /**
     * This is a default constructor
     */
    public AgriculturalDrone() {
        super();
        brand = "";
        carryCapacity = 0;
    }

    /**
     * This is a constructor to initialize an AgriculturalDrone object
     * @param weight initial weight
     * @param price initial price
     * @param brand initial brand name
     * @param carryCapacity initial passenger capacity
     */
    public AgriculturalDrone(double weight, double price, String brand, int carryCapacity) {
        super(weight, price);
        this.brand = brand;
        this.carryCapacity = carryCapacity;
    }

    /**
     * This is a copy constructor
     * @param a stores the other agricultural drone being copied
     */
    public AgriculturalDrone(AgriculturalDrone a) {
        this.weight = a.weight;
        this.price = a.price;
        this.brand = a.brand;
        this.carryCapacity = a.carryCapacity;
    }

    /**
     * get brand of Agricultural Drone
     * @return brand of Agricultural Drone
     */
    public String getBrand() {
        return brand;
    }

    /**
     * get carrying capacity of Agricultural Drone
     * @return carrying capacity of Agricultural Drone
     */
    public int getCarryCapacity() {
        return carryCapacity;
    }

    /**
     * set brand of Agricultural Drone
     * @param brand new brand of Agricultural Drone
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * set carrying capacity of Agricultural Drone
     * @param carryCapacity new carrying capacity of Agricultural Drone
     */
    public void setCarryCapacity(int carryCapacity) {
        this.carryCapacity = carryCapacity;
    }

    /**
     * toString Method displaying all values of Agricultural Drone
     * @return string displaying all information about Agricultural Drone
     */
    public String toString() {
        return "This Agricultural Drone is manufactured by " + brand + ". It weighs " + weight + " pounds, and costs $" + price + "0. It can carry up to " + carryCapacity + "kg.";
    }

    /**
     * equals Method comparing all Agricultural Drone attributes
     * @param object stores other object being compared
     * @return boolean value true if two objects are equal and false otherwise
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (this.getClass() == object.getClass()) {
            AgriculturalDrone agrDrone = (AgriculturalDrone) object;
            if (this.weight == agrDrone.weight && this.price == agrDrone.price && this.brand.equals(agrDrone.brand) && this.carryCapacity == agrDrone.carryCapacity) {
                return true;
            }
        }
        return false;
    }
}
