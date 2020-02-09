package package5;

import package4.UAV;

public class MAV extends UAV {
    private String model;
    private double size;

    //Default Constructor
    public MAV() {
        super();
        model = "";
        size = 0.00;
    }

    //Parameterized Constructor
    public MAV(double weight, double price, String model, double size) {
        super(weight, price);
        this.model = model;
        this.size = size;
    }

    //Copy Constructor
    public MAV(MAV mav) {
        this.weight = mav.weight;
        this.price = mav.price;
        this.model = mav.model;
        this.size = mav.size;
    }

    //Accessor Method
    public String getModel() {
        return model;
    }

    public double getSize() {
        return size;
    }

    //Mutator Method
    public void setModel(String model) {
        this.model = model;
    }

    public void setSize(double size) {
        this.size = size;
    }

    ////Displaying description and information of MAV
    public String toString() {
        return "This MAV is a " + model + " model. It weighs " + weight + " pounds, and costs $" + price + "0. Its size is " + size + " cm.";
    }

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
