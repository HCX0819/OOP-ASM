import java.time.LocalDate;
import java.util.Scanner;

public class ReturnVehicle_Function {

    public static void returnVehicle() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("====================================");
        System.out.println("Return Vehicle");
        System.out.println("====================================");
    
        // Display rented vehicles first
        boolean anyRented = false;
        System.out.println("Currently Rented Vehicles:");
        for (Vehicle v : VehicleRentalSystem.vehicles) {
            if (!v.isAvailable()) {
                System.out.println("- Vehicle ID: " + v.getVehicleId() + ", " + v.getBrand() + " " + v.getModel());
                anyRented = true;
            }
        }
    
        if (!anyRented) {
            System.out.println("No vehicles are currently rented.");
            return;
        }
    
        System.out.println("------------------------------------");
    
        // Then ask for vehicle ID to return
        System.out.print("Enter the Vehicle ID to return: ");
        String vehicleId = scanner.nextLine();
        
        
        Vehicle selectedVehicle = null;
        
        // Step 2: Find the vehicle in the vehicles list
        for (Vehicle v : VehicleRentalSystem.vehicles) {
            if (v.getVehicleId().equalsIgnoreCase(vehicleId)) {
                selectedVehicle = v;
                break;
            }
        }
        
        if (selectedVehicle == null) {
            System.out.println("Vehicle ID not found.");
            return;
        }
        
        // Step 3: Check if the vehicle is currently rented (not available)
        if (selectedVehicle.isAvailable()) {
            System.out.println("This vehicle is already returned or never rented.");
            return;
        }

        // Step 4: Get the current date as return date
        LocalDate returnDate = LocalDate.now();
        System.out.println("Return Date: " + returnDate);

        // Step 5: Find the corresponding rental record
        RentalRecord rentalRecord = null;
        for (RentalRecord record : VehicleRentalSystem.rentalHistory) {
            if (record.getVehicle().equals(selectedVehicle) && record.getReturnDate() == null) { // Check if not yet returned
                rentalRecord = record;
                break;
            }
        }

        if (rentalRecord == null) {
            System.out.println("No active rental found for this vehicle.");
            return;
        }

        // Step 6: Calculate the rental duration (if needed)
        long rentalDays = java.time.temporal.ChronoUnit.DAYS.between(rentalRecord.getRentalDate(), returnDate);
        System.out.println("Total Rental Duration: " + rentalDays + " days.");
        
        // Step 7: Calculate late fees if return is after the agreed rental period
        int lateFee = 0;
        if (rentalDays > rentalRecord.getRentalDurationDays()) { // Assuming getRentalDurationDays() gives the expected rental period
            lateFee = (int)(rentalDays - rentalRecord.getRentalDurationDays()) * 10; // e.g., RM 10 per extra day
        }

        // Step 8: Mark the vehicle as available
        selectedVehicle.setAvailable(true);
        
        // Step 9: Update the rental record with return date and any fees
        rentalRecord.setReturnDate(returnDate); // Set return date
        rentalRecord.setLateFee(lateFee); // Record the late fee

        // Step 10: Display only the late fee
        if (lateFee > 0) {
            System.out.println("Late Fee: RM" + lateFee);
        } else {
            System.out.println("No late fee applied.");
        }
        
        System.out.println("Vehicle returned successfully.");
    }
}
