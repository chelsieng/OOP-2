package package4;


import package6.FlyingObject;

public class UAV extends FlyingObject {
    protected double weight;
    protected double price;

    //Default Constructor
    public UAV() {
        weight = 0.00;
        price = 0.00;
    }

    //Parameterized Constructor
    public UAV(double weight, double price) {
        this.weight = weight;
        this.price = price;
    }

    //Copy Constructor
    public UAV(UAV uav) {
        this.weight = uav.weight;
        this.price = uav.price;
    }

    //Accessor Method
    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    //Mutator Method
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Displaying description and information of UAV
    public String toString() {
        return "This UAV weighs " + weight + " pounds, and costs $" + price + "0.";
    }

    public boolean equals(Object object){
        if (object==null){
            return false;
        }

        if (this.getClass() == object.getClass()){
            UAV uav = (UAV) object;
            if (this.weight == uav.weight && this.price == uav.price){
                return true;
            }
        }
        return false;
    }
}
