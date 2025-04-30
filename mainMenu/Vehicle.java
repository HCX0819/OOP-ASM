package mainMenu;
public class Vehicle {
    private String vehicleId;
    private String brand;
    private String model;
    private double pricePerDay;
    private String plateNo;
    private String color;
    private int year;
    private boolean available;

    public Vehicle(String vehicleId, String brand, String model, double pricePerDay, String plateNo, String color, int year) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.plateNo = plateNo;
        this.color = color;
        this.year = year;
        this.available = true; // Default to available
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDetails() {
        return String.format(
            "%-10s | %-10s | %-10s | RM%-8.2f | %-10s | %-10s | %-4d ",
            vehicleId, brand, model, pricePerDay, plateNo, color, year);
    }
    
}

