package mainMenu;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import payment.RunInvoice;

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
        LocalDate startDate = null;
        while (startDate == null) {
            try {
                String startDateInput = scanner.nextLine();
                startDate = LocalDate.parse(startDateInput);
            } catch (Exception e) {
                System.out.println("Invalid date format! Please enter date in YYYY-MM-DD format.");
                System.out.print("Enter Rental Start Date (YYYY-MM-DD): ");
            }
        }

        System.out.print("Enter Return Date (YYYY-MM-DD): ");
        LocalDate returnDate = null;
        while (returnDate == null) {
            try {
                String returnDateInput = scanner.nextLine();
                returnDate = LocalDate.parse(returnDateInput);
                
                // Check if return date is after start date
                if (!returnDate.isAfter(startDate)) {
                    System.out.println("Return date must be after start date!");
                    System.out.print("Enter Return Date (YYYY-MM-DD): ");
                    returnDate = null;
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid date format! Please enter date in YYYY-MM-DD format.");
                System.out.print("Enter Return Date (YYYY-MM-DD): ");
            }
        }

        int rentalDays = (int) ChronoUnit.DAYS.between(startDate, returnDate);

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
            boolean paymentSuccessful = RunInvoice.paymentMenu();
            
            if (paymentSuccessful) {
                // Add to rental history with username
                VehicleRentalSystem.rentalHistory.add(new RentalRecord(selectedVehicle, startDate, rentalDays, currentUsername));
                System.out.println("Rental confirmed and recorded!\n");
            } else {
                // If payment was not successful, make the vehicle available again
                selectedVehicle.setAvailable(true);
                System.out.println("Rental cancelled due to incomplete payment.\n");
            }
        } else {
            System.out.println("Rental cancelled.\n");
        }

        System.out.println("Returning to Main Menu...\n");
    }

    private static void loadSampleVehicles() {
        if (!vehiclesLoaded) {
            
            VehicleRentalSystem.vehicles.add(new Car("C001", "Toyota", "Vios", 150.0, "PJD2353", "Red", 2006, "Sedan"));
            VehicleRentalSystem.vehicles.add(new Car("C002", "Honda", "City", 180.0, "JHG7766", "Black", 2021, "Sedan"));
            VehicleRentalSystem.vehicles.add(new Car("C003", "Perodua", "Myvi", 120.0, "ABC1234", "Blue", 2018, "Hatchback"));
            VehicleRentalSystem.vehicles.add(new Car("C004", "Proton", "Saga", 110.0, "WXY2345", "Silver", 2015, "Sedan"));
            VehicleRentalSystem.vehicles.add(new Car("C005", "BMW", "320i", 300.0, "BMW1234", "White", 2020, "Sedan"));
            VehicleRentalSystem.vehicles.add(new Car("C006", "Mercedes", "C200", 350.0, "MRC4567", "Black", 2019, "Sedan"));
            VehicleRentalSystem.vehicles.add(new Car("C007", "Mazda", "CX-5", 250.0, "MAZ8899", "Grey", 2022, "SUV"));
            VehicleRentalSystem.vehicles.add(new Car("C008", "Kia", "Cerato", 200.0, "KIA1122", "Red", 2018, "Sedan"));
            VehicleRentalSystem.vehicles.add(new Car("C009", "Ford", "Focus", 190.0, "FRD3344", "Blue", 2017, "Hatchback"));
            VehicleRentalSystem.vehicles.add(new Car("C010", "Hyundai", "Elantra", 210.0, "HYU5566", "White", 2021, "Sedan"));
    
            
            VehicleRentalSystem.vehicles.add(new Motorcycle("M001", "Yamaha", "YZF-R3", 100.0, "KLM1234", "White", 2019, true));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M002", "Kawasaki", "Ninja 250", 120.0, "V1P5678", "Green", 2022, false));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M003", "Honda", "CBR500R", 130.0, "HON6789", "Red", 2020, true));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M004", "Suzuki", "GSX250R", 110.0, "JHF3456", "Blue", 2021, false));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M005", "Ducati", "Monster", 180.0, "DUC1111", "Black", 2018, true));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M006", "KTM", "RC 200", 140.0, "PJG2222", "Orange", 2022, true));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M007", "Benelli", "302R", 120.0, "BEN3333", "Yellow", 2019, false));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M008", "Aprilia", "RS 660", 200.0, "APR4444", "Grey", 2023, true));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M009", "BMW", "G 310 R", 160.0, "P5555", "White", 2020, false));
            VehicleRentalSystem.vehicles.add(new Motorcycle("M010", "Kawasaki", "Ninja 750", 220.0, "HD6666", "Black", 2017, true));
    
            vehiclesLoaded = true;
        }
    }
    
}
