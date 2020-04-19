import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CellListUtilization {
    public static void main(String[] arg) {
        //Welcome message
        System.out.println("* Welcome to Chelsie's CellListUtilization *");
        //Creating two empty list
        CellList list1 = new CellList();
        CellList list2;
        CellPhone cellPhone;
        long serialNum = 0;
        String brand = "";
        double price = 0.0;
        int year = 0;
        int count = 0;
        String key = "";

        //Opening file
        try {
            Scanner readFile = new Scanner(new FileInputStream("Assignment 4/Cell_Info.txt"));
            // Reading file line by line
            while (readFile.hasNextLine()) {
                serialNum = readFile.nextLong();
                brand = readFile.next();
                price = readFile.nextDouble();
                year = readFile.nextInt();
                // Removing duplicates
                if (list1.contains(serialNum)) {
                    continue;
                }
                cellPhone = new CellPhone(serialNum, brand, year, price);
                //Adding cellphone obj at the beginning of the list
                list1.addToStart(cellPhone);
            }
            //Displaying all contents of list
            list1.showContents();
            //Prompting user to enter few serial numbers
            Scanner userIn = new Scanner(System.in);
            System.out.println("Please enter the number of serial Number you wish to search: ");
            count = userIn.nextInt();
            for (int i = 0; i < count; i++) {
                System.out.println("Please enter the serial number you want to find: ");
                serialNum = userIn.nextLong();
                list1.find(serialNum);
            }
            //Cloning list
            System.out.println("\nCloning list 1 in list 2");
            System.out.println("========================");
            list2 = new CellList(list1);
            System.out.println("Displaying list 2:");
            list2.showContents();

            System.out.println("\nPress any key to view testing");
            key = userIn.next();
            //Testing equals method
            System.out.println("\nTesting equals method");
            System.out.println("=====================");
            if (list1.equals(list2)) {
                System.out.println("List 1 and 2 are equal.");
            } else {
                System.out.println("List 1 and 2 are not equal.");
            }

            //Testing insert method
            System.out.println("\nInsert [1234567: Apple 699.99$ 2019] at index 2");
            System.out.println("=================================================");
            list2.insertAtIndex(new CellPhone(1234567, "Apple", 2019, 699.99), 2);
            list2.showContents();

            //Testing delete method
            System.out.println("\nDelete [1234567: Apple 699.99$ 2019] from index 2");
            System.out.println("===================================================");
            list2.deleteFromIndex(2);
            list2.showContents();

            //Testing delete from start method
            System.out.println("\ndeleteFromStart method");
            System.out.println("========================");
            list2.deleteFromStart();
            list2.showContents();

            //Testing replace method
            System.out.println("\nReplace [1234567: Apple 699.99$ 2019] at index 2");
            System.out.println("==================================================");
            list2.replaceAtIndex(new CellPhone(1234567, "Apple", 2019, 699.99), 2);
            list2.showContents();

            //Testing insert method when index is 0
            System.out.println("\nInsert [1119000: SonyEricsson 347.94$ 2009] at index 0");
            System.out.println("========================================================");
            list2.insertAtIndex(new CellPhone(1119000, "SonyEricsson", 2009, 347.94), 0);
            list2.showContents();
            //Testing equal method (expected result: not equal)
            System.out.println("\nTesting equals method");
            System.out.println("=====================");
            if (list1.equals(list2)) {
                System.out.println("List 1 and 2 are equal.");
            } else {
                System.out.println("List 1 and 2 are not equal.");
            }

            System.out.println("\nTesting an empty list");
            System.out.println("=======================");
            //Creating an empty list
            CellList list3 = new CellList();
            //Testing insert method and index is 0
            list3.insertAtIndex(new CellPhone(1234567, "Apple", 2019, 699.99), 0);
            System.out.println("Insert at index 0: ");
            list3.showContents();
            //Testing replace method
            System.out.println("Replace at index 0:");
            list3.replaceAtIndex(new CellPhone(9876543, "Samsung", 2018, 399.99), 0);
            list3.showContents();
            //Testing delete method when head is not null and index is 0
            list3.deleteFromIndex(0);
            System.out.println("\nTesting delete method when index is 0:");
            list3.showContents();
            // list 3 is empty again
            //Testing insert method when index is not 0
            list3.insertAtIndex(new CellPhone(9876543, "Samsung", 2018, 399.99), 4);
            System.out.println("Testing insert method when list is empty and index is not 0:");
            list3.showContents();
            //Testing delete method when head is null
            list3.insertAtIndex(new CellPhone(9876543, "Samsung", 2018, 399.99), 4);
            System.out.println("Testing delete method when list is empty:");
            list3.showContents();
            //Testing delete from start when head is null
            list3.deleteFromStart();
            System.out.println("Testing delete from start method when list empty:");
            list3.showContents();
            //Testing replace when head is null
            list3.replaceAtIndex(new CellPhone(9876543, "Samsung", 2018, 399.99), 4);
            System.out.println("Testing replace method when list is empty:");
            list3.showContents();

            //Testing cellphone copy constructor
            CellPhone c1 = new CellPhone(9876543, "Samsung", 2018, 399.99);
            CellPhone c2 = new CellPhone(c1, 1234567);
            System.out.println("\nTesting cellphone copy constructor");
            System.out.println("====================================");
            System.out.println("c1: " + c1.toString());
            System.out.println("c2: " + c2.toString());
            //Closing message
            System.out.println("\nThank you for using Chelsie's CellListUtilization!");
            readFile.close();
            userIn.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error! Unable to read file. Program will now terminate!");
            System.exit(-1);
        }
    }
}
