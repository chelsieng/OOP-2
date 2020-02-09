package package2;

import package1.Airplane;

public class Helicopter extends Airplane {
    protected int numOfCylinders;
    protected int creationYear;
    protected int passengerCapacity;

    //Default Constructor
    public Helicopter() {
        super();
        numOfCylinders = 0;
        creationYear = 0;
        passengerCapacity = 0;
    }

    //Parameterized Constructor
    public Helicopter(String brand, double price, int horsePower, int numOfCylinders, int creationYear, int passengerCapacity) {
        super(brand, price, horsePower);
        this.numOfCylinders = numOfCylinders;
        this.creationYear = creationYear;
        this.passengerCapacity = passengerCapacity;
    }

    //Copy Constructor
    public Helicopter(Helicopter h) {
        this.brand = h.brand;
        this.price = h.price;
        this.horsePower = h.horsePower;
        this.numOfCylinders = h.numOfCylinders;
        this.creationYear = h.creationYear;
        this.passengerCapacity = h.passengerCapacity;
    }

    //Accessor Method
    public int getNumOfCylinders() {
        return numOfCylinders;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    //Mutator Method
    public void setNumOfCylinders(int numOfCylinders) {
        this.numOfCylinders = numOfCylinders;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    //Displaying description and information of helicopter
    public String toString() {
        return "This helicopter is manufactured by " + brand + " and was created in " + creationYear + ". It costs $" + price + "0 and has a horse power of " + horsePower + " watt. It has " + numOfCylinders + " cylinders and can hold up to " + passengerCapacity + " passengers.";
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() == object.getClass()) {
            Helicopter h = (Helicopter) object;
            if (this.brand.equals(h.brand)&& this.price == h.price && this.horsePower == h.horsePower && this.numOfCylinders == h.numOfCylinders && this.creationYear == h.creationYear && this.passengerCapacity == h.passengerCapacity) {
                return true;
            }
        }
        return false;
    }
}
