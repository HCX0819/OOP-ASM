package payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import mainMenu.Vehicle;

public class RunInvoice {

    public static  ArrayList<Feedback> feedbackList = new ArrayList<>();

   public static boolean paymentMenu(Vehicle vehicle, LocalDate startDate,
           LocalDate returnDate, double totalCost, String customerName){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean paymentCompleted = false;

        do {
            System.out.println("\n=====Select Option========");
            System.out.println("1. Payment");
            System.out.println("2. Give Feedback");
            System.out.println("3. View All Feedback");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 - 4.");
                scanner.next();
                continue;
            }

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    paymentCompleted = handlePayment(scanner, vehicle,
                            startDate, returnDate, totalCost, customerName);

                    if (paymentCompleted) {
                        return true;
                    }
                    break;
                case 2:
                    collectFeedback(scanner);
                    break;
                case 3:
                    viewAllFeedback();
                    break;
                case 4:
                    System.out.println("Exiting payment menu...");
                    return false;
                default:
                    System.out.println("Please enter a number between 1 - 4.");
                    break;
            }

        } while (choice != 4);

        return false;
    }

   public static boolean handlePayment(Scanner scanner, Vehicle vehicle,
        LocalDate startDate, LocalDate returnDate, 
        double totalCost, String customerName){

        System.out.println("\n--PAYMENT PAGE--");
        System.out.println("\nPayment Details:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Vehicle: " + vehicle.getBrand() + " " + vehicle.getModel());
        System.out.println("Rental Period: " + startDate + " to " + returnDate);
        System.out.printf("Total Amount: RM%.2f\n", totalCost);
        
        System.out.println("\nSelect Payment Method:");
        System.out.println("1. Credit Card");
        System.out.println("2. Online Banking");
        System.out.print("Enter choice (1-2): ");
        
        int method = scanner.nextInt();
        scanner.nextLine();

        String paymentMethod = "";
        switch (method) {
            case 1:
                paymentMethod = "Credit Card";
                break;
            case 2:
                paymentMethod = "Online Banking";
                break;
            default:
                System.out.println("Invalid method.");
                return false;
        }
    
        Invoice invoice = new Invoice(vehicle, startDate, returnDate, totalCost, customerName);
        Invoice.invoiceList.add(invoice);
        invoice.printInvoice();

        return true;
    }

    public static void collectFeedback(Scanner scanner) {
        int rating;

        while (true) {
            System.out.println("\n--- FEEDBACK ---");
            System.out.println("Rate our service (1 to 5)");
            System.out.println("Press 0 to cancel");
            System.out.print("Your rating: ");

            if (scanner.hasNextInt()) {
                rating = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (rating == 0) {
                    System.out.println("Feedback cancelled.");
                    return;
                }

                if (rating >= 1 && rating <= 5) 
                    break;
                else System.out.println("Invalid rating. Please enter between 1 and 5.");
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Your comments: ");
        String comment = scanner.nextLine();

        Feedback feedback = new Feedback(name, comment, String.valueOf(rating));
        feedbackList.add(feedback);

        System.out.println("\nThank you for your feedback!");
    }

    public static void viewAllFeedback() {
        System.out.println("\n--- All Feedback ---");
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback given yet.");
        } else {
            for (Feedback feedback : feedbackList) {
                System.out.println(feedback);
            }
        }
    }

  
}
