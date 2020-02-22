// -----------------------------------------------------
// Part: 2
// Written by: Chelsie Ng Man King ID: 40071692
// -----------------------------------------------------
package package5;

import package4.UAV;

/**
 * @author Chelsie Ng - 40071692
 * MAV Class which inherits from UAV
 */
public class MAV extends UAV {
    private String model;
    private double size;

    /**
     * This is a default constructor
     */
    public MAV() {
        super();
        model = "";
        size = 0.00;
    }

    /**
     * This is a constructor to initialize a MAV object
     *
     * @param weight initial weight
     * @param price  initial price
     * @param model  initial model
     * @param size   initial size
     */
    public MAV(double weight, double price, String model, double size) {
        super(weight, price);
        this.model = model;
        this.size = size;
    }

    /**
     * This is a copy constructor
     *
     * @param mav stores the other MAV being copied
     */
    public MAV(MAV mav) {
        this.weight = mav.weight;
        this.price = mav.price;
        this.model = mav.model;
        this.size = mav.size;
    }

    /**
     * get model of MAV
     *
     * @return model of MAV
     */
    public String getModel() {
        return model;
    }

    /**
     * get size of MAV
     *
     * @return size of MAV
     */
    public double getSize() {
        return size;
    }

    /**
     * set model of MAV
     *
     * @param model new model of MAV
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * set size of MAV
     *
     * @param size new size of MAV
     */
    public void setSize(double size) {
        this.size = size;
    }

    /**
     * toString Method displaying all values of MAV
     *
     * @return string displaying all information about MAV
     */
    public String toString() {
        return "This MAV is a " + model + " model. It weighs " + weight + " pounds, and costs $" + price + "0. Its size is " + size + " m.";
    }

    /**
     * equals Method comparing all MAV attributes
     *
     * @param object stores other object being compared
     * @return boolean value true if two objects are equal and false otherwise
     */
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (this.getClass() == object.getClass()) {
            MAV mav = (MAV) object;
            if (this.weight == mav.weight && this.price == mav.price && this.model.equals(mav.model) && this.size == mav.size) {
                return true;
            }
        }
        return false;
    }
}
