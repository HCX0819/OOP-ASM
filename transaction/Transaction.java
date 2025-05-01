package transaction;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private String transactionId;
    private String userId;
    private String carId;
    private Date rentalDate;
    private double amountPaid;
    private String paymentStatus;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Transaction(String transactionId, String userId, String carId, Date rentalDate, double amountPaid, String paymentStatus) {
        this.transactionId = transactionId;
        this.userId = userId;
        this.carId = carId;
        this.rentalDate = rentalDate;
        this.amountPaid = amountPaid;
        this.paymentStatus = paymentStatus;
    }

    // Getters and setters (Encapsulation)
    public String getTransactionId() {
        return transactionId;
    }

    public String getUserId() { 
        return userId; 
    }
    
    public String getCarId() { 
        return carId; 
    }
    
    public Date getRentalDate() {
        return rentalDate; 
    }
    
    public double getAmountPaid() { 
        return amountPaid; 
    }
    
    public String getPaymentStatus() { 
        return paymentStatus; 
    }

    public void setPaymentStatus(String status) {
        this.paymentStatus = status;
    }

    public String toCSV() {
        return transactionId + "," + userId + "," + carId + "," +
               sdf.format(rentalDate) + "," + amountPaid + "," + paymentStatus;
    }

    public static Transaction fromCSV(String line) {
        try {
            String[] parts = line.split(",");
            return new Transaction(
                parts[0], parts[1], parts[2],
                sdf.parse(parts[3]),
                Double.parseDouble(parts[4]),
                parts[5]
            );
        } catch (Exception e) {
            return null; // handle error in calling code
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %s | User: %s | Car: %s | Date: %s | Paid: RM%.2f | Status: %s",
                transactionId, userId, carId, sdf.format(rentalDate), amountPaid, paymentStatus);
    }
}

