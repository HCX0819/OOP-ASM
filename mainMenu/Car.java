package mainMenu;
public class Car extends Vehicle {
  private String carType;
  
  

  public Car(String vehicleId, String brand, String model, double pricePerDay, String plateNo, String color, int year,
      String carType) {
    super(vehicleId, brand, model, pricePerDay, plateNo, color, year);
    this.carType = carType;
  }



  public String getCarType() {
    return carType;
  }


  public void setCarType(String carType) {
    this.carType = carType;
  }



  @Override
  public String toString() {
      return super.getDetails() + String.format(" %-10s | %-10s |", carType, (isAvailable() ? "Available" : "Rented"));
  }

  public static String getHeader() {
    return String.format(
        "%-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-4s | %-10s | %-10s |",
        "VehicleID", "Brand", "Model", "Price/Day", "Plate No", "Color", "Year", "Car Type", "Status"
    );
 }


  public double calculateRentalCost(int days) {
    return getPricePerDay() * days;
  }

  


}