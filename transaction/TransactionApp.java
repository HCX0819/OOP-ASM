package transaction;
import java.util.*;
import mainMenu.Vehicle;
import mainMenu.RentalRecord;
import mainMenu.VehicleRentalSystem;
import mainMenu.Car;
import assign.Start;

public class TransactionApp {
    public static void staffMenuDisplay() {
        Scanner sc = new Scanner(System.in);
        TransactionManager manager = new TransactionManager();
        int choice;

        do {
            System.out.println("\n==== Transaction Record Menu ====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Search Transactions by Username");
            System.out.println("4. Delete Transaction");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine(); // clear buffer

                switch (choice) {
                    case 1:
                        // Get username
                        String username;
                        while (true) {
                            System.out.print("Enter Username: ");
                            username = sc.nextLine().trim();
                            if (username.isEmpty()) {
                                System.out.println("[ERROR] Username cannot be empty.");
                            } else {
                                break;
                            }
                        }

                        // Get vehicle details
                        System.out.println("\nEnter Vehicle Details:");
                        System.out.print("Vehicle ID: ");
                        String vehicleId = sc.nextLine().trim();
                        System.out.print("Brand: ");
                        String brand = sc.nextLine().trim();
                        System.out.print("Model: ");
                        String model = sc.nextLine().trim();
                        System.out.print("Plate No: ");
                        String plateNo = sc.nextLine().trim();
                        System.out.print("Color: ");
                        String color = sc.nextLine().trim();
                        System.out.print("Year: ");
                        int year = Integer.parseInt(sc.nextLine().trim());
                        System.out.print("Price per day (RM): ");
                        double pricePerDay = Double.parseDouble(sc.nextLine().trim());

                        // Get rental duration
                        int duration = 0;
                        while (true) {
                            System.out.print("Enter Rental Duration (days): ");
                            try {
                                duration = Integer.parseInt(sc.nextLine().trim());
                                if (duration <= 0) {
                                    System.out.println("[ERROR] Duration must be positive.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("[ERROR] Please enter a valid number.");
                            }
                        }

                        // Create vehicle and rental record
                        Vehicle vehicle = new Car(vehicleId, brand, model, pricePerDay, plateNo, color, year, "Sedan");
                        RentalRecord record = new RentalRecord(vehicle, java.time.LocalDate.now(), duration, username);
                        
                        // Add to rental history
                        VehicleRentalSystem.rentalHistory.add(record);
                        System.out.println("[INFO] Transaction added successfully.");
                        break;

                    case 2:
                        manager.displayAll();
                        break;

                    case 3:
                        System.out.print("Enter Username to search: ");
                        String searchUsername = sc.nextLine();
                        manager.searchByUsername(searchUsername);
                        break;

                    case 4:
                        // First display all records
                        manager.displayAll();
                        
                        // Then ask for record number to delete
                        System.out.print("\nEnter Record Number to delete: ");
                        try {
                            int recordNum = Integer.parseInt(sc.nextLine().trim());
                            manager.deleteTransaction(recordNum);
                        } catch (NumberFormatException e) {
                            System.out.println("[ERROR] Please enter a valid record number.");
                        }
                        break;

                    case 0:
                        System.out.println("Returning to start page...");
                        Start.menu();
                        return;
                    
                    default:
                        System.out.println("[ERROR] Invalid choice. Please select 0-4.");
                }

            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Please enter a valid number.");
                sc.next(); // clear invalid input
                choice = -1; // continue loop
            }

        } while (choice != 0);
    }
}
