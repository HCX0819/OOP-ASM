package mainMenu;
import java.util.Scanner;

public class TransactionApp {
    
    public static void staffMenuDisplay() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n==== Transaction Record Menu ====");
            System.out.println("1. Add Transaction");
            System.out.println("2. View Transactions");
            System.out.println("3. Update Payment Status");
            System.out.println("4. Search Transactions by User ID");
            System.out.println("5. Delete Transaction");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    addTransaction(scanner);
                    break;
                case 2:
                    ViewTransactionHistory_Function.viewAllTransactions();
                    break;
                case 3:
                    updatePaymentStatus(scanner);
                    break;
                case 4:
                    searchTransactionsByUser(scanner);
                    break;
                case 5:
                    deleteTransaction(scanner);
                    break;
                case 6:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }
    
    private static void addTransaction(Scanner scanner) {
        System.out.println("\n=== Add New Transaction ===");
        // Implementation for adding transaction
        System.out.println("Feature coming soon...");
    }
    
    private static void updatePaymentStatus(Scanner scanner) {
        System.out.println("\n=== Update Payment Status ===");
        // Implementation for updating payment status
        System.out.println("Feature coming soon...");
    }
    
    private static void searchTransactionsByUser(Scanner scanner) {
        System.out.println("\n=== Search Transactions ===");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        
        boolean found = false;
        for (RentalRecord record : VehicleRentalSystem.rentalHistory) {
            if (record.getUsername().equals(userId)) {
                if (!found) {
                    System.out.println("\nTransactions for User: " + userId);
                    System.out.println("------------------------------------");
                    found = true;
                }
                System.out.println("\nVehicle: " + record.getVehicle().getBrand() + " " + 
                                 record.getVehicle().getModel() + " (" + 
                                 record.getVehicle().getPlateNo() + ")");
                System.out.println("Rental Date: " + record.getRentalDate());
                System.out.println("Duration: " + record.getRentalDurationDays() + " days");
                
                if (record.getReturnDate() != null) {
                    System.out.println("Return Date: " + record.getReturnDate());
                    if (record.getLateFee() > 0) {
                        System.out.println("Late Fee: RM" + record.getLateFee());
                    }
                    System.out.println("Status: Returned");
                } else {
                    System.out.println("Status: Active Rental");
                }
                System.out.println("------------------------------------");
            }
        }
        
        if (!found) {
            System.out.println("No transactions found for User ID: " + userId);
        }
    }
    
    private static void deleteTransaction(Scanner scanner) {
        System.out.println("\n=== Delete Transaction ===");
        // Implementation for deleting transaction
        System.out.println("Feature coming soon...");
    }
} 