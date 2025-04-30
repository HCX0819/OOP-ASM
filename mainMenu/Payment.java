package mainMenu;
import java.util.Scanner;

public class Payment {
    public static void processPayment(Scanner scanner) {
        System.out.println("----------------------------------------");
        System.out.println("\nPlease select the payment method.....");
        System.out.println("\nType of payment......");
        System.out.println("1. Credit/Debit Card");
        System.out.println("2. Online Banking");
         System.out.println("3. E-Wallet");
        System.out.print("Enter payment option: ");
        
        int paymentOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        System.out.println("\nProcessing payment...");
        System.out.println("Payment successful!");
    }
}
