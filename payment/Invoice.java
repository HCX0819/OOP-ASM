package payment;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import mainMenu.Vehicle;

public class Invoice {
    
    private final String customerName;
    private final Vehicle vehicle;
    private final LocalDate startDate;
    private final LocalDate returnDate;
    private final double totalCost;
    public static List<Invoice> invoiceList = new ArrayList<>(); //added

    // Modified constructor
    public Invoice(Vehicle vehicle, LocalDate startDate, LocalDate returnDate,double totalCost, String customerName) {
        this.customerName = customerName;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public static List<Invoice> getInvoiceList() {
        return invoiceList;
    }
    
    public static void setInvoiceList(List<Invoice> customersInvoice) {
        invoiceList = customersInvoice;

        // Example: Print each invoice's details or extract to variables
        for (Invoice invoice : invoiceList) {
            String currentUsername = invoice.getCustomerName();
            Vehicle vehicle = invoice.getVehicle(); 
            LocalDate StartDate = invoice.getStartDate();
            LocalDate returnDate = invoice.getReturnDate();
            double totalCost = invoice.getTotalCost();
        }
    }

    
    public void printInvoice() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long rentalDays = ChronoUnit.DAYS.between(startDate, returnDate);
        
        System.out.println("\n==================================================");
        System.out.println("               VEHICLE RENTAL RECEIPT");
        System.out.println("==================================================\n");
        
        System.out.println("Customer: " + customerName);
        
        
        System.out.println("Vehicle Information:");
        System.out.println("----------------------------------------");
        System.out.println(vehicle); // Use vehicle's toString()
        
        System.out.println("\nRental Period:");
        System.out.println("----------------------------------------");
        System.out.println("Start Date     : " + startDate.format(formatter));
        System.out.println("Return Date    : " + returnDate.format(formatter));
        System.out.println("Duration       : " + rentalDays + " days\n");
        
        System.out.println("Payment Information:");
        System.out.println("----------------------------------------");
        System.out.printf("Daily Rate     : RM%.2f\n", vehicle.getPricePerDay());
        System.out.printf("Total Cost     : RM%.2f\n", totalCost);
       
        
    }
}