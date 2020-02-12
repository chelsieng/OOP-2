import package1.Airplane;
import package2.Helicopter;
import package2.Quadcopter;
import package3.Multirotor;
import package4.UAV;
import package5.AgriculturalDrone;
import package5.MAV;

public class Driver_A2 {
    public static void main(String[] args) {
        //Creating airplanes
        Airplane a1 = new Airplane("AirBus", 700500, 28);
        Airplane a2 = new Airplane("Bombardier", 700250, 25);
        Airplane a3 = new Airplane("Dassault", 700000, 20);

        //Displaying info about Airplanes
        System.out.println("----------Airplanes----------");
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());

        //Creating helicopters
        Helicopter h1 = new Helicopter("AirBus", 600250, 15, 2, 2015, 8);
        Helicopter h2 = new Helicopter("Corail", 600000, 10, 2, 2018, 6);

        //Displaying info about Helicopters
        System.out.println("\n----------Helicopters----------");
        System.out.println(h1.toString());
        System.out.println(h2.toString());

        //Creating Quadcopters
        Quadcopter q1 = new Quadcopter("Dromida", 500, 5, 4, 2014, 4, 30);
        Quadcopter q2 = new Quadcopter(q1);

        //Displaying info about Quadcopters
        System.out.println("\n----------Quadcopters----------");
        System.out.println(q1.toString());
        System.out.println(q2.toString());

        //Creating Multirotors
        Multirotor r1 = new Multirotor("Horizon", 375, 5, 3, 2012, 2, 4);
        Multirotor r2 = new Multirotor("Heliceo", 275, 5, 2, 2000, 2, 4);

        //Displaying info about Multirotors
        System.out.println("\n----------Multirotors----------");
        System.out.println(r1.toString());
        System.out.println(r2.toString());

        //Creating UAV
        UAV uav1 = new UAV(500, 3000);
        UAV uav2 = new UAV(400, 2500);

        //Displaying info about UAV
        System.out.println("\n----------UAVs----------");
        System.out.println(uav1.toString());
        System.out.println(uav2.toString());

        //Creating Agricultural Drones
        AgriculturalDrone ad1 = new AgriculturalDrone(340, 3000, "AgriDrones", 25);
        AgriculturalDrone ad2 = new AgriculturalDrone(250, 2000, "Drone Girl", 15);

        //Displaying info about Agricultural Drones
        System.out.println("\n----------Agricultural Drones----------");
        System.out.println(ad1.toString());
        System.out.println(ad2.toString());

        //Creating MAVs
        MAV mav1 = new MAV(100, 500, "Zipline", 3);
        MAV mav2 = new MAV(80, 400, "Flytrex", 1.5);

        //Displaying info about MAVs
        System.out.println("\n----------MAVs----------");
        System.out.println(mav1.toString());
        System.out.println(mav2.toString());

    }
}
