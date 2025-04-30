package mainMenu;
public class ViewRentalHistory_Function {

    private static String currentUsername; // Add static field for current user

    public static void setCurrentUsername(String username) {
        currentUsername = username;
    }

    public static void viewRentalHistory() {
        System.out.println("=".repeat(50));
        System.out.printf("%25s%n", "View Rental History");
        System.out.println("=".repeat(50));
    
        if (VehicleRentalSystem.rentalHistory.isEmpty()) {
            System.out.println("No vehicles have been rented yet...");
        } else {
            int count = 1;
            boolean hasUserRentals = false;
            
            for (RentalRecord record : VehicleRentalSystem.rentalHistory) {
                if (record.getUsername().equals(currentUsername)) {
                    System.out.println(count + ". " + record);
                    count++;
                    hasUserRentals = true;
                }
            }
            
            if (!hasUserRentals) {
                System.out.println("You have no rental history yet.");
            }
        }
    
        System.out.println("-".repeat(50));
    }
    
}
