package mainMenu;
import java.util.Scanner;

public class SystemMain {
    public static boolean custMenuDisplay() {
        Scanner scanner = new Scanner(System.in);
        VehicleRentalSystem rentalSystem = new VehicleRentalSystem();
        int choice;

        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 0 and 4.");
                scanner.next(); // Clear invalid input
                displayMenu();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    rentalSystem.viewAndRentVehicles();
                    break;
                case 2:
                    rentalSystem.viewRentalHistory();
                    break;
                case 3:
                    rentalSystem.updatePersonalInfo();
                    break;
                case 4:
                    rentalSystem.returnVehicle();
                    break;
                case 0:
                    System.out.println("Thank you for using Vehicle Rental System. Goodbye!");
                    return true; // Return true to indicate logout
                default:
                    System.out.println("Invalid choice! Please select a number between 0 and 4.");
            }
        } while (choice != 0);

        scanner.close();
        return false;
    }

    public static boolean staffMenuDisplay() {
        Scanner scanner = new Scanner(System.in);
        VehicleRentalSystem rentalSystem = new VehicleRentalSystem();
        int choice;

        do {
            displayStaffMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 0 and 4.");
                scanner.next(); // Clear invalid input
                displayStaffMenu();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    rentalSystem.viewAndRentVehicles();
                    break;
                case 2:
                    rentalSystem.viewAllTransactions();
                    break;
                case 3:
                    rentalSystem.updatePersonalInfo();
                    break;
                case 4:
                    rentalSystem.returnVehicle();
                    break;
                case 0:
                    System.out.println("Thank you for using Vehicle Rental System. Goodbye!");
                    return true; // Return true to indicate logout
                default:
                    System.out.println("Invalid choice! Please select a number between 0 and 4.");
            }
        } while (choice != 0);

        scanner.close();
        return false;
    }

    public static void displayStaffMenu() {     
        System.out.println("\n=================================");
        System.out.println("    Staff Management System     ");
        System.out.println("=================================");
        System.out.println("1. View & Rent Available Vehicles");
        System.out.println("2. View All Transactions");
        System.out.println("3. Update Personal Information");
        System.out.println("4. Return a Vehicle");
        System.out.println("0. Log Out");
        System.out.println("=================================");
        System.out.print("Enter your choice: ");
    }     

    public static void displayMenu() {     
        System.out.println("\n=================================");
        System.out.println("    Vehicle Rental System Menu   ");
        System.out.println("=================================");
        System.out.println("1. View & Rent Available Vehicles");
        System.out.println("2. View Rental History");
        System.out.println("3. Update Personal Information");
        System.out.println("4. Return a Vehicle");
        System.out.println("0. Log Out");
        System.out.println("=================================");
        System.out.print("Enter your choice: ");
    }     
}