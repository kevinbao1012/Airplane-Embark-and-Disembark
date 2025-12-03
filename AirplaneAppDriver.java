package LA5Q;

import java.util.Scanner;

//driver class
public class AirplaneAppDriver {
    //header
    public static void myHeader(int labNum){
        System.out.println("=======================================================");
        System.out.printf("Lab Exercise %d-Q1", labNum); //Lab # + Question #
        System.out.println("Prepared by: Kevin Bao"); //Name
        System.out.println("Student Number: 251410147"); //Student Number
        System.out.println("Brief Description: Building an airplane embark and disembark app using linear data structures"); //Description
        System.out.println("=======================================================");
    }

    //footer to place at the end of the program
    public static void myFooter(int labNum){
        System.out.println("=======================================================");
        System.out.printf("Completion of Lab Exercise %d is successful! \n", labNum);
        System.out.println("Signing off - Kevin Bao");
        System.out.println("=======================================================");
    }

    //driver
    public static void main(String[] args) {

        myHeader(5);
        //create the system
        AirplaneLogic system = new AirplaneLogic();

        //scanner type variable to collect inputs
        Scanner scanner = new Scanner(System.in);

        //initiate variable used to hold user input
        int choice = 0;

        System.out.println("   Kevin Bao's Airplane Boarding and Disembarking App  ");

        do {

            //menu with all the options for the user
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add Passenger to Boarding Line");
            System.out.println("2. Board Next Passenger");
            System.out.println("3. View Boarding Line");
            System.out.println("4. View Seated Passengers");
            System.out.println("5. Start Disembarking"); //creates the disembarking stack
            System.out.println("6. Disembark Next Passenger");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            //store user's choice
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // clear buffer

                // Range check
                if (choice < 1 || choice > 7) {
                    System.out.println("Please enter a number between 1 and 7.");
                    choice = -1;
                    continue;
                }

            } else {
                System.out.println("Invalid input! Please enter a NUMBER between 1 and 7.");
                scanner.nextLine(); // remove bad input
                continue;
            }

            switch (choice) {
                case 1 -> system.addPassenger(scanner);
                case 2 -> system.boardPassenger();
                case 3 -> system.viewBoardingLine();
                case 4 -> system.viewSeatedPassengers();
                case 5 -> system.prepareDisembark();
                case 6 -> system.disembarkPassenger();
                case 7 -> System.out.println("Thank you for using the application!");
                default -> System.out.println("Invalid choice, try again.");
            }
        //make sure loops until user calls to exit
        } while (choice != 7);

        myFooter(5);
    }
}

