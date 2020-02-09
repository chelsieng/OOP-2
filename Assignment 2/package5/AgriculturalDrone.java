package package5;

import package4.UAV;

public class AgriculturalDrone extends UAV {
    private String brand;
    private int carryCapacity;

    //Default Constructor
    public AgriculturalDrone() {
        super();
        brand = "";
        carryCapacity = 0;
    }

    //Parameterized Constructor
    public AgriculturalDrone(double weight, double price, String brand, int carryCapacity) {
        super(weight, price);
        this.brand = brand;
        this.carryCapacity = carryCapacity;
    }

    //Copy Constructor
    public AgriculturalDrone(AgriculturalDrone a) {
        this.weight = a.weight;
        this.price = a.price;
        this.brand = a.brand;
        this.carryCapacity = a.carryCapacity;
    }

    //Accessor Method
    public String getBrand() {
        return brand;
    }

    public int getCarryCapacity() {
        return carryCapacity;
    }

    //Mutator Method
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCarryCapacity(int carryCapacity) {
        this.carryCapacity = carryCapacity;
    }

    //Displaying description and information of Agricultural drone
    public String toString() {
        return "This Agricultural Drone is manufactured by " + brand + ". It weighs " + weight + " pounds, and costs $" + price + "0. It can carry up to " + carryCapacity + " kg.";
    }

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
