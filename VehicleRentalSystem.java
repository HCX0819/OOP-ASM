import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {

    public static List<Vehicle> vehicles = new ArrayList<>(); // Initialize the list

    private ViewAndRentVehicles_Function rentalFunction = new ViewAndRentVehicles_Function();

    public static List<RentalRecord> rentalHistory = new ArrayList<>();
    

    public void viewAndRentVehicles() {
        System.out.println("Displaying available vehicles...");
        
        ViewAndRentVehicles_Function.viewAndRentVehicles();
    }

    public void viewRentalHistory() {
        System.out.println("Displaying rental history...");
        ViewRentalHistory_Function.viewRentalHistory();
        System.out.println(" ");
    }

    public void updatePersonalInfo() {
        System.out.println("Updating personal information...");
        System.out.println(" ");
    }

    public void returnVehicle() {
        System.out.println("Returning a vehicle...");
        ReturnVehicle_Function.returnVehicle();
        System.out.println(" ");
    }


}



