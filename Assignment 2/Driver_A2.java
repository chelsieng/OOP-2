import package1.Airplane;
import package2.Helicopter;
import package2.Quadcopter;
import package3.Multirotor;
import package4.UAV;
import package5.AgriculturalDrone;
import package5.MAV;
import package6.FlyingObject;

public class Driver_A2 {
    public static void main(String[] args) {
        //Creating airplanes
        FlyingObject a1 = new Airplane("AirBus", 700500, 28);
        FlyingObject a2 = new Airplane("Bombardier", 700250, 25);
        FlyingObject a3 = new Airplane("Dassault", 700000, 20);

        //Displaying info about Airplanes
        System.out.println("----------Airplanes----------");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());

        //Creating helicopters
        FlyingObject h1 = new Helicopter("AirBus", 600250, 15, 2, 2015, 8);
        FlyingObject h2 = new Helicopter("Corail", 600000, 10, 2, 2018, 6);

        //Displaying info about Helicopters
        System.out.println("\n----------Helicopters----------");
        System.out.println(h1.toString());
        System.out.println(h2.toString());

        //Creating Quadcopters
        FlyingObject q1 = new Quadcopter("Dromida", 500, 5, 4, 2014, 4, 30);
        FlyingObject q2 = new Quadcopter ("Dromida", 500, 5, 4, 2014, 4, 30);

        //Displaying info about Quadcopters
        System.out.println("\n----------Quadcopters----------");
        System.out.println(q1.toString());
        System.out.println(q2.toString());

        //Creating Multirotors
        FlyingObject r1 = new Multirotor("Horizon", 375, 5, 3, 2012, 2, 4);
        FlyingObject r2 = new Multirotor("Heliceo", 275, 5, 2, 2000, 2, 4);

        //Displaying info about Multirotors
        System.out.println("\n----------Multirotors----------");
        System.out.println(r1.toString());
        System.out.println(r2.toString());

        //Creating UAV
        FlyingObject uav1 = new UAV(500, 3000);
        FlyingObject uav2 = new UAV(400, 2500);

        //Displaying info about UAV
        System.out.println("\n----------UAVs----------");
        System.out.println(uav1.toString());
        System.out.println(uav2.toString());

        //Creating Agricultural Drones
        FlyingObject ad1 = new AgriculturalDrone(340, 3000, "AgriDrones", 25);
        FlyingObject ad2 = new AgriculturalDrone(250, 2000, "Drone Girl", 15);

        //Displaying info about Agricultural Drones
        System.out.println("\n----------Agricultural Drones----------");
        System.out.println(ad1.toString());
        System.out.println(ad2.toString());

        //Creating MAVs
        FlyingObject mav1 = new MAV(100, 500, "Zipline", 3);
        FlyingObject mav2 = new MAV(80, 400, "Flytrex", 1.5);

        //Displaying info about MAVs
        System.out.println("\n----------MAVs----------");
        System.out.println(mav1.toString());
        System.out.println(mav2.toString());

        //Testing equals() method
        //Comparing q1 and q2
        System.out.println("\n----------Testing equals() method----------");
        Boolean equal = q1.equals(q2);
        System.out.print("Are flying object q1 and q2 the same? ");
        if (equal == true){
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }

        //Comparing a1 and a2
        equal = a1.equals(a2);
        System.out.print("\nAre flying object a1 and a2 the same? ");
        if (equal == true){
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }

        //Comparing a3 and uva1
        equal = a3.equals(uav1);
        System.out.print("\nAre flying object a3 and UAV uav1 the same? ");
        if (equal == true){
            System.out.print("Yes");
        }
        else {
            System.out.print("No");
        }

        //Creating an array of flying objects
        FlyingObject [] array = new FlyingObject[15];
        // Storing airplanes
        array [0] = a1;
        array [1] = a2;
        array [2] = a3;
        // Storing helicopters
        array [3] = h1;
        array [4] = h2;
        //Storing Quadcopters
        array [5] = q1;
        array [6] = q2;
        //Storing Multirotors
        array [7] = r1;
        array [8] = r2;
        //Storing UAV
        array [9] = uav1;
        array [10] = uav2;
        //Storing Agricultural Drone
        array [11] = ad1;
        array [12] = ad2;
        //Storing MAV
        array [13] = mav1;
        array [14] = mav2;


    }
}
