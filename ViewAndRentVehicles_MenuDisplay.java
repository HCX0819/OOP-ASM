import java.util.List;
import java.util.Scanner;

public class ViewAndRentVehicles_MenuDisplay {
   
    

    public static void displayVehiclesByChoice(List<Vehicle> vehicles) {
        Scanner scanner = new Scanner(System.in);
        displayMainMenu();
        
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> displayCarMenu(vehicles);
            case 2 -> displayMotorcycleMenu(vehicles);
            default -> System.out.println("Invalid choice!");
        }
    }




    public static void displayMainMenu() {
        System.out.println("\n========== Vehicle Rental System ==========");
        System.out.println("1. View Cars");
        System.out.println("2. View Motorcycles");
        System.out.print("Please enter your choice: ");
    }

    public static void displayCarMenu(List<Vehicle> vehicles) {
        System.out.println("\n====================================================================================");
        System.out.printf("%55s", "View & Rent Vehicles (Car)");
        System.out.println("\n====================================================================================");
        System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-6s | %-8s%n", 
                          "Vehicle ID", "Brand", "Model", "Plate No", "Color", "Year", "Price/Day");
        System.out.println("------------------------------------------------------------------------------------");
    
        for (Vehicle v : vehicles) {
            if (v instanceof Car && v.isAvailable()) {
                Car car = (Car) v;
                System.out.printf("%-10s | %-10s | %-10s | %-10s | %-10s | %-6d | RM%-7.2f%n", 
                                  car.getVehicleId(), car.getBrand(), car.getModel(), 
                                  car.getPlateNo(), car.getColor(), car.getYear(), car.getPricePerDay());
            }
        }
    
        System.out.println("-------------------------------------------------------------------------------------");
    }
    
    

    public static void displayMotorcycleMenu(List<Vehicle> vehicles) {
        System.out.println("\n============================================================================================================");
        System.out.println("                          View & Rent Vehicles (Motorcycle)       ");
        System.out.println("============================================================================================================");
        System.out.println(Motorcycle.getHeader());
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    
        for (Vehicle v : vehicles) {
            if (v instanceof Motorcycle && v.isAvailable()) {
                System.out.println(v.toString());
            }
        }
    
        System.out.println("---------------------------------------------------------------------------------------------------------------");
    }

    
    
}
