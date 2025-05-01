package payment;

import java.util.ArrayList;
import java.util.Scanner;

public class RunInvoice {

    public static  ArrayList<Feedback> feedbackList = new ArrayList<>();

    public static boolean paymentMenu() {
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
                    paymentCompleted = handlePayment(scanner);
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

    public static boolean handlePayment(Scanner scanner) {
        System.out.println("\n--PAYMENT PAGE--");
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        // Add IC number validation
        String icNum;
        boolean validateIcNum = false;
        do {
            System.out.print("Enter IC number (YYMMDD-PB-XXXX): ");
            icNum = scanner.nextLine();
            
            try {
                // Basic format validation
                if (icNum == null || icNum.trim().isEmpty()) {
                    throw new Exception("No IC number given");
                }
                if (icNum.length() != 14) {
                    throw new Exception("IC number must be exactly 14 characters");
                }
                if (icNum.charAt(6) != '-' || icNum.charAt(9) != '-') {
                    throw new Exception("IC number must follow format YYMMDD-PB-XXXX");
                }

                // Validate birth date part (YYMMDD)
                String birthDate = icNum.substring(0, 6);
                if (!birthDate.matches("\\d{6}")) {
                    throw new Exception("Birth date must be 6 digits");
                }

                int month = Integer.parseInt(birthDate.substring(2, 4));
                if (month < 1 || month > 12) {
                    throw new Exception("Invalid month in IC number");
                }

                int day = Integer.parseInt(birthDate.substring(4, 6));
                if (day < 1 || day > 31) {
                    throw new Exception("Invalid day in IC number");
                }

                // Validate state code (PB)
                String stateCode = icNum.substring(7, 9);
                if (!stateCode.matches("\\d{2}") || stateCode.equals("00")) {
                    throw new Exception("Invalid state code in IC number");
                }

                // Validate last 4 digits
                String lastFour = icNum.substring(10);
                if (!lastFour.matches("\\d{4}") || lastFour.equals("0000")) {
                    throw new Exception("Invalid last 4 digits in IC number");
                }

                validateIcNum = true;

            } catch (Exception e) {
                System.out.println("\nError: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        } while (!validateIcNum);

        System.out.print("Enter amount: RM ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid amount. Please enter a number: RM ");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.println("Select Payment Method:\n1. Credit Card\n2. Online Banking");
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

        Invoice invoice = new Invoice(customerName, amount, paymentMethod);
        invoice.printInvoice();
        invoice.printReceipt();
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
