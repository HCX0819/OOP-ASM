package mainMenu;
import java.util.Scanner;
import assign.CustAccount;
import assign.Start;
import java.util.ArrayList;

public class UpdatePersonalInfo_Function {
    private static String currentUsername;

    public static void setCurrentUsername(String username) {
        currentUsername = username;
    }

    public static void updatePersonalInfo(ArrayList<CustAccount> customerList) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("====================================");
        System.out.println("     Personal Information Page      ");
        System.out.println("====================================");
        
        // Find current user's account
        CustAccount currentUser = null;
        for (CustAccount account : customerList) {
            if (account.getuName().equals(currentUsername) || account.geteAddress().equals(currentUsername)) {
                currentUser = account;
                break;
            }
        }
        
        if (currentUser == null) {
            System.out.println("Error: User account not found!");
            return;
        }
        
        // Display detailed current information first
        System.out.println("\nYour Personal Information:");
        System.out.println("====================================");
        System.out.println("Customer ID: " + currentUser.getCustid());
        System.out.println("Username: " + currentUser.getuName());
        System.out.println("Full Name: " + currentUser.getName());
        System.out.println("Email Address: " + currentUser.geteAddress());
        System.out.println("Contact Number: " + currentUser.getContact());
        System.out.println("Emergency Contact: " + currentUser.geteContact());
        System.out.println("IC Number: " + currentUser.getIcNum());
        System.out.println("====================================");
        
        System.out.println("\nPress Enter to continue to update menu...");
        scanner.nextLine();
        
        // Clear screen for update menu
        System.out.println("\n\n====================================");
        System.out.println("     Update Personal Information    ");
        System.out.println("====================================");
        
        // Display update options
        System.out.println("\nWhat would you like to update?");
        System.out.println("------------------------------------");
        System.out.println("1. Name: " + currentUser.getName());
        System.out.println("2. Email: " + currentUser.geteAddress());
        System.out.println("3. Contact Number: " + currentUser.getContact());
        System.out.println("4. Emergency Contact: " + currentUser.geteContact());
        System.out.println("5. Password");
        System.out.println("0. Back to Main Menu");
        System.out.println("------------------------------------");
        
        // Ask what to update
        System.out.print("\nEnter your choice (0-5): ");
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                if (!newName.trim().isEmpty()) {
                    currentUser.setName(newName);
                    System.out.println("Name updated successfully!");
                }
                break;
                
            case "2":
                System.out.print("Enter new email: ");
                String newEmail = scanner.nextLine();
                if (newEmail.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    currentUser.seteAddress(newEmail);
                    System.out.println("Email updated successfully!");
                } else {
                    System.out.println("Invalid email format!");
                }
                break;
                
            case "3":
                System.out.print("Enter new contact number: ");
                String newContact = scanner.nextLine();
                if (newContact.matches("^\\+?[0-9]{10,12}$")) {
                    currentUser.setContact(newContact);
                    System.out.println("Contact number updated successfully!");
                } else {
                    System.out.println("Invalid contact number format! Please use format: +60123456789");
                }
                break;
                
            case "4":
                System.out.print("Enter new emergency contact: ");
                String newEContact = scanner.nextLine();
                if (newEContact.matches("^\\+?[0-9]{10,12}$")) {
                    currentUser.seteContact(newEContact);
                    System.out.println("Emergency contact updated successfully!");
                } else {
                    System.out.println("Invalid contact number format! Please use format: +60123456789");
                }
                break;
                
            case "5":
                System.out.print("Enter current password: ");
                String currentPassword = scanner.nextLine();
                
                if (currentPassword.equals(currentUser.getPassword())) {
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Confirm new password: ");
                    String confirmPassword = scanner.nextLine();
                    
                    if (newPassword.equals(confirmPassword)) {
                        if (newPassword.length() >= 8) {
                            currentUser.setPassword(newPassword);
                            System.out.println("Password updated successfully!");
                        } else {
                            System.out.println("Password must be at least 8 characters long!");
                        }
                    } else {
                        System.out.println("Passwords do not match!");
                    }
                } else {
                    System.out.println("Incorrect current password!");
                }
                break;
                
            case "0":
                System.out.println("Returning to main menu...");
                break;
                
            default:
                System.out.println("Invalid choice!");
                break;
        }
        
        // Add a pause before returning
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }
} 