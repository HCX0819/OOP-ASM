
public class ViewRentalHistory_Function {

   

    public static void viewRentalHistory() {

        

        System.out.println("=".repeat(50));
        System.out.printf("%25s%n", "View Rental History");
        System.out.println("=".repeat(50));
    
        if (VehicleRentalSystem.rentalHistory.isEmpty()) {
            System.out.println("No vehicles have been rented yet...");
        } else {
            int count = 1;
            for (RentalRecord record : VehicleRentalSystem.rentalHistory) {
                System.out.println(count + ". " + record);
                count++;
            }
        }
    
        System.out.println("-".repeat(50));
    }
    
}
