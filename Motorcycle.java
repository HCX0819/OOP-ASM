public class Motorcycle extends Vehicle {
    private boolean hasHelmet;

    public Motorcycle(String vehicleId, String brand, String model, double pricePerDay, String plateNo, String color, int year,
                      boolean hasHelmet) {
        super(vehicleId, brand, model, pricePerDay, plateNo, color, year);
        this.hasHelmet = hasHelmet;


    }
    

    public boolean isHasHelmet() {
        return hasHelmet;
    }
    public void setHasHelmet(boolean hasHelmet) {
        this.hasHelmet = hasHelmet;
    }

    @Override
    public String toString() {
         return super.getDetails() + String.format("| %-10s | %-10s |", (hasHelmet ? "Yes" : "No"), (isAvailable() ? "Available" : "Rented"));
    }

    public static String getHeader() {
        return String.format(
            "%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-4s | %-10s | %-10s |",
            "VehicleID", "Brand", "Model", "Price/Day", "Plate No", "Color", "Year", "Helmet", "Status"
        );
    }
    


    public double calculateRentalCost(int days) {
        double cost = getPricePerDay() * days;
        if (hasHelmet) {
            cost += 5; // helmet rental fee
        }
        return cost;
    }



   
}
