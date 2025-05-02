package transaction;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import mainMenu.VehicleRentalSystem;
import mainMenu.RentalRecord;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();
    private final String fileName = "transactions.csv";
    private int nextId = 1; // auto-incrementing ID counter

    public TransactionManager() {
        loadFromFile(); // Automatically load existing records
    }

    // CREATE
    public void addTransaction(Transaction t) {
        transactions.add(t);
        saveToFile();
    }

    // READ
    public void displayAll() {
        List<RentalRecord> rentalHistory = VehicleRentalSystem.rentalHistory;
        
        if (rentalHistory.isEmpty()) {
            System.out.println("[INFO] No rental records available.");
            return;
        }

        System.out.println("\n================================================================================");
        System.out.printf("%-12s | %-15s | %-20s | %-12s | %-8s | %-10s%n", 
                          "Record #", "Username", "Vehicle", "Rental Date", "Duration", "Status");
        System.out.println("--------------------------------------------------------------------------------");

        int count = 1;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        for (RentalRecord record : rentalHistory) {
            String status = record.getReturnDate() != null ? "Returned" : "Active";
            String vehicle = record.getVehicle().getBrand() + " " + record.getVehicle().getModel();
            
            System.out.printf("%-12d | %-15s | %-20s | %-12s | %-8d | %-10s%n",
                    count++,
                    record.getUsername(),
                    vehicle,
                    record.getRentalDate().toString(),
                    record.getRentalDurationDays(),
                    status);
                    
            if (record.getLateFee() > 0) {
                System.out.printf("%12s   %-15s   %-20s   %-12s   %-8s   RM%.2f%n",
                        "", "Late Fee:", "", "", "", record.getLateFee());
            }
        }

        System.out.println("================================================================================");
    }

    public void searchByUsername(String username) {
        List<RentalRecord> rentalHistory = VehicleRentalSystem.rentalHistory;
        boolean found = false;
        int count = 1;

        System.out.println("\n================================================================================");
        System.out.printf("%-12s | %-15s | %-20s | %-12s | %-8s | %-10s%n", 
                          "Record #", "Username", "Vehicle", "Rental Date", "Duration", "Status");
        System.out.println("--------------------------------------------------------------------------------");

        for (RentalRecord record : rentalHistory) {
            if (record.getUsername().equalsIgnoreCase(username)) {
                String status = record.getReturnDate() != null ? "Returned" : "Active";
                String vehicle = record.getVehicle().getBrand() + " " + record.getVehicle().getModel();
                
                System.out.printf("%-12d | %-15s | %-20s | %-12s | %-8d | %-10s%n",
                        count++,
                        record.getUsername(),
                        vehicle,
                        record.getRentalDate().toString(),
                        record.getRentalDurationDays(),
                        status);
                        
                if (record.getLateFee() > 0) {
                    System.out.printf("%12s   %-15s   %-20s   %-12s   %-8s   RM%.2f%n",
                            "", "Late Fee:", "", "", "", record.getLateFee());
                }
                found = true;
            }
        }
        
        System.out.println("================================================================================");
        
        if (!found) {
            System.out.println("[INFO] No transactions found for username: " + username);
        }
    }

    // UPDATE
    public void updateStatus(String id, String newStatus) {
        for (Transaction t : transactions) {
            if (t.getTransactionId().equalsIgnoreCase(id)) {
                t.setPaymentStatus(newStatus);
                saveToFile();
                System.out.println("[INFO] Status updated.");
                return;
            }
        }
        System.out.println("[ERROR] Transaction not found.");
    }

    // DELETE
    public void deleteTransaction(int recordNumber) {
        List<RentalRecord> rentalHistory = VehicleRentalSystem.rentalHistory;
        
        if (recordNumber < 1 || recordNumber > rentalHistory.size()) {
            System.out.println("[ERROR] Invalid record number. Please enter a number between 1 and " + rentalHistory.size());
            return;
        }
        
        // Display the record to be deleted for confirmation
        RentalRecord recordToDelete = rentalHistory.get(recordNumber - 1);
        System.out.println("\nRecord to be deleted:");
        System.out.println("------------------------------------");
        System.out.println("Username: " + recordToDelete.getUsername());
        System.out.println("Vehicle: " + recordToDelete.getVehicle().getBrand() + " " + recordToDelete.getVehicle().getModel());
        System.out.println("Rental Date: " + recordToDelete.getRentalDate());
        System.out.println("------------------------------------");
        
        // Remove the record
        rentalHistory.remove(recordNumber - 1);
        System.out.println("[INFO] Record #" + recordNumber + " has been deleted successfully.");
    }

    public String generateTransactionId() {
        String id = String.format("TXN%03d", nextId);
        nextId++;
        return id;
    }

    // FILE I/O
    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Transaction t : transactions) {
                writer.write(t.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("[ERROR] Could not save file: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) {   
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int maxId = 0;

            while ((line = reader.readLine()) != null) {
                Transaction t = Transaction.fromCSV(line);
                if (t != null) {
                    transactions.add(t);

                    String idPart = t.getTransactionId().replaceAll("[^0-9]", "");
                    try {
                        int idNum = Integer.parseInt(idPart);
                        if (idNum > maxId) {
                            maxId = idNum;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("[WARN] Could not parse transaction ID: " + idPart);  
                    }
                }
            }
            nextId = maxId + 1;
        } catch (IOException e) {
            System.out.println("[ERROR] Could not load file: " + e.getMessage());
        }
    }
}
    
    
