package mainMenu;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class ViewAndRentVehicles_Function {
    
    private static String currentUsername;
    private static boolean vehiclesLoaded = false;

    public static void setCurrentUsername(String username) {
        currentUsername = username;
    }

    // Remove constructor and use static initialization
    static {
        loadSampleVehicles();
    }

    public static void viewAndRentVehicles() {
        
        Scanner scanner = new Scanner(System.in);
        ViewAndRentVehicles_MenuDisplay.displayVehiclesByChoice(VehicleRentalSystem.vehicles);

        System.out.print("\nWould you like to rent a vehicle? (Y/N): ");
        String choice = scanner.nextLine().toUpperCase();

        if (!choice.equals("Y")) {
            System.out.println("Returning to main menu...\n");
            return;
        }

        System.out.print("Enter Vehicle ID to rent: ");
        String vehicleId = scanner.nextLine();
        Vehicle selectedVehicle = null;

        for (Vehicle v : VehicleRentalSystem.vehicles) {
            if (v.getVehicleId().equalsIgnoreCase(vehicleId) && v.isAvailable()) {
                selectedVehicle = v;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Invalid Vehicle ID or vehicle not available.\n");
            return;
        }

        System.out.print("Enter Rental Start Date (YYYY-MM-DD): ");
        String startDateInput = scanner.nextLine();
        System.out.print("Enter Return Date (YYYY-MM-DD): ");
        String returnDateInput = scanner.nextLine();

        // ✅ Calculate rental days dynamically
        LocalDate startDate = LocalDate.parse(startDateInput);
        LocalDate returnDate = LocalDate.parse(returnDateInput);
        int rentalDays = (int) ChronoUnit.DAYS.between(startDate, returnDate);

        if (rentalDays <= 0) {
            System.out.println("Return date must be after start date!\n");
            return;
        }

        double totalCost = selectedVehicle.getPricePerDay() * rentalDays;

        System.out.println("\n----------------------------------------");
        System.out.println("Rental Details:\n");
        System.out.println("Vehicle: " + selectedVehicle.getBrand() + " " + selectedVehicle.getModel());
        System.out.println("Rental Days: " + rentalDays);
        System.out.printf("Total Cost: RM%.2f%n", totalCost);
        System.out.println("----------------------------------------");

        System.out.print("\nConfirm Rental? (Y/N): ");
        String confirm = scanner.nextLine().toUpperCase();

        if (confirm.equals("Y")) {
            selectedVehicle.setAvailable(false);
            Payment.processPayment(scanner);

            // Add to rental history with username
            VehicleRentalSystem.rentalHistory.add(new RentalRecord(selectedVehicle, startDate, rentalDays, currentUsername));

            System.out.println("Rental confirmed and recorded!\n");
        } else {
            System.out.println("Rental cancelled.\n");
        }

        System.out.println("Returning to Main Menu...\n");
    }

    private static void loadSampleVehicles() {
        // Only load vehicles if they haven't been loaded yet
        if (!vehiclesLoaded) {
            VehicleRentalSystem.vehicles.add(new Car("C001", "Toyota", "Vios", 150.0, "PJD2353", "Red", 2006, "Sedan"));
            VehicleRentalSystem.vehicles.add(new Car("C002", "Honda", "City", 180.0, "JHG7766", "Black", 2021, "Sedan"));
            VehicleRentalSystem.vehicles.add(new Car("C003", "Perodua", "Myvi", 120.0, "ABC1234", "Blue", 2018, "Hatchback" ));

            VehicleRentalSystem.vehicles.add(new Motorcycle("M001", "Yamaha", "YZF-R3", 100.0, "KLM1234", "White", 2019, true));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M002", "Kawasaki", "Ninja 250", 120.0, "ABC5678", "Green", 2022, false));
            
            vehiclesLoaded = true;
        }
    }
}
