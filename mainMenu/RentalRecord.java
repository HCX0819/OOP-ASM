package mainMenu;
import java.time.LocalDate;

public class RentalRecord {

    private Vehicle vehicle;
    private LocalDate rentalDate;
    private int rentalDurationDays;
    private String username;

    private LocalDate returnDate;
    private int lateFee;

    // Constructor with Vehicle, LocalDate, rental duration, and username
    public RentalRecord(Vehicle vehicle, LocalDate rentalDate, int rentalDurationDays, String username) {
        this.vehicle = vehicle;
        this.rentalDate = rentalDate;
        this.rentalDurationDays = rentalDurationDays;
        this.username = username;
    }

    // Getters and other methods

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public int getRentalDurationDays() {
        return rentalDurationDays;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getLateFee() {
        return lateFee;
    }

    public void setLateFee(int lateFee) {
        this.lateFee = lateFee;
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Rented on: %s, Duration: %d days",
                vehicle.getBrand() + " " + vehicle.getModel(),
                vehicle.getPlateNo(),
                rentalDate,
                rentalDurationDays);
    }
}
