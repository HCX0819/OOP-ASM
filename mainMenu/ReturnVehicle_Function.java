package mainMenu;
import java.time.LocalDate;
import java.util.Scanner;

public class ReturnVehicle_Function {
    
    private static String currentUsername;

    public static void setCurrentUsername(String username) {
        currentUsername = username;
    }

    public static void returnVehicle() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("====================================");
        System.out.println("Return Vehicle");
        System.out.println("====================================");
    
        // Display only vehicles rented by current user
        boolean anyRented = false;
        System.out.println("Your Currently Rented Vehicles:");
        
        // First find rental records for current user
        for (RentalRecord record : VehicleRentalSystem.rentalHistory) {
            if (record.getUsername().equals(currentUsername) && record.getReturnDate() == null) {
                Vehicle v = record.getVehicle();
                System.out.println("- Vehicle ID: " + v.getVehicleId() + ", " + v.getBrand() + " " + v.getModel());
                anyRented = true;
            }
        }
    
        if (!anyRented) {
            System.out.println("You have no vehicles currently rented.");
            return;
        }
    
        System.out.println("------------------------------------");
    
        // Then ask for vehicle ID to return
        System.out.print("Enter the Vehicle ID to return: ");
        String vehicleId = scanner.nextLine();
        
        Vehicle selectedVehicle = null;
        RentalRecord selectedRecord = null;
        
        // Find the vehicle and rental record together
        for (RentalRecord record : VehicleRentalSystem.rentalHistory) {
            if (record.getUsername().equals(currentUsername) && 
                record.getVehicle().getVehicleId().equalsIgnoreCase(vehicleId) && 
                record.getReturnDate() == null) {
                selectedVehicle = record.getVehicle();
                selectedRecord = record;
                break;
            }
        }
        
        if (selectedVehicle == null || selectedRecord == null) {
            System.out.println("Vehicle ID not found or not rented by you.");
            return;
        }

        // Get the current date as return date
        LocalDate returnDate = LocalDate.now();
        System.out.println("Return Date: " + returnDate);

        // Calculate the rental duration
        long rentalDays = java.time.temporal.ChronoUnit.DAYS.between(selectedRecord.getRentalDate(), returnDate);
        System.out.println("Total Rental Duration: " + rentalDays + " days.");
        
        // Calculate late fees if return is after the agreed rental period
        int lateFee = 0;
        if (rentalDays > selectedRecord.getRentalDurationDays()) {
            lateFee = (int)(rentalDays - selectedRecord.getRentalDurationDays()) * 10; // RM 10 per extra day
        }

        // Mark the vehicle as available
        selectedVehicle.setAvailable(true);
        
        // Update the rental record
        selectedRecord.setReturnDate(returnDate);
        selectedRecord.setLateFee(lateFee);

        // Display fee information
        if (lateFee > 0) {
            System.out.println("Late Fee: RM" + lateFee);
        } else {
            System.out.println("No late fee applied.");
        }
        
        System.out.println("Vehicle returned successfully.");
    }
}
