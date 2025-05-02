/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assign;
import java.util.Scanner;
import java.util.ArrayList;
import mainMenu.SystemMain;
import mainMenu.ViewRentalHistory_Function;
import mainMenu.ViewAndRentVehicles_Function;
import mainMenu.ReturnVehicle_Function;
import mainMenu.UpdatePersonalInfo_Function;
import mainMenu.VehicleRentalSystem;
import transaction.TransactionApp;

public class AccLogIn {

    public static void custLogIn(Scanner scanner, ArrayList<CustAccount>customerList){
        
        addMethod.clearScreen();
        addMethod.headerLogIn();
        
        boolean validateLogIn = false;
        while (!validateLogIn){
            boolean emptyInput1 = false;
            boolean emptyInput2 = false;
            boolean userExist = false;
            boolean passwordCorrect = false;
            
            System.out.print(" Username/Email : ");
            String uNameEmail = scanner.nextLine();
            System.out.print(" Password       : ");
            String password = scanner.nextLine();
            
            if(uNameEmail == null || uNameEmail.trim().isEmpty()){
                emptyInput1 = true;
            }
            if(password ==null || password.trim().isEmpty()){ 
                emptyInput2 = true;
            }
            if(!emptyInput1 && !emptyInput2){
                for(CustAccount account:customerList){
                    if(uNameEmail.equals(account.getuName()) || uNameEmail.equals(account.geteAddress())){
                        userExist = true;

                        if(password.equals(account.getPassword())){
                            passwordCorrect = true;
                            break;                        
                        }
                    
                    }
                }
            }
            if(userExist && passwordCorrect && !emptyInput1 && !emptyInput2){
                validateLogIn = true;
                // Set current username for all functions
                ViewRentalHistory_Function.setCurrentUsername(uNameEmail);
                ViewAndRentVehicles_Function.setCurrentUsername(uNameEmail);
                ReturnVehicle_Function.setCurrentUsername(uNameEmail);
                UpdatePersonalInfo_Function.setCurrentUsername(uNameEmail);
                // Set customer list for personal info updates
                VehicleRentalSystem.setCustomerList(customerList);
            }
            else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");                
                
                if(emptyInput1){
                    System.out.println("|- No username or email address given          |");
                }
                if(emptyInput2){
                    System.out.println("|- No password given                           |");
                }
                if(!emptyInput1 && !emptyInput2){
                    if(!userExist){
                        System.out.println("|- Non-existing user                           |");                    
                    }    
                    else if(!passwordCorrect){
                        System.out.println("|- Incorrect password                          |");
                    }
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
        }

        System.out.println("Login Successfully\n");
        addMethod.pressKeyCont(scanner);
        //continue

        addMethod.clearScreen();
        boolean shouldLogout = SystemMain.custMenuDisplay();
        if (shouldLogout) {
            // Return to main menu instead of recursively calling login
            Start.menu();
        }
    }

                
    
    public static void staffLogIn(Scanner scanner,ArrayList<StaffAccount>staffList){        
        addMethod.clearScreen();
        addMethod.headerLogIn();
        
        boolean validateLogIn = false;
        while (!validateLogIn){
            
            boolean emptyInput1 = false;
            boolean emptyInput2 = false;
            boolean userExist = false;
            boolean passwordCorrect = false;
            
            System.out.print(" Username/Email : ");
            String uNameEmail = scanner.nextLine();
            System.out.print(" Password       : ");
            String password = scanner.nextLine();
            
            if(uNameEmail == null || uNameEmail.trim().isEmpty()){
                emptyInput1 = true;
            }
        
            if(password ==null || password.trim().isEmpty()){ 
                emptyInput2 = true;
            }
            
            if(!emptyInput1 && !emptyInput2){
                for(StaffAccount account:staffList){
                    if(uNameEmail.equals(account.getuName()) || uNameEmail.equals(account.geteAddress())){
                        userExist = true;

                        if(password.equals(account.getPassword())){
                            passwordCorrect = true;
                            break;                        
                        }
                    
                    }
                }
            }
            
            if(userExist && passwordCorrect && !emptyInput1 && !emptyInput2){
                validateLogIn = true;
            }
            else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");                

                if(emptyInput1){
                    System.out.println("|- No username or email address given          |");
                }
                if(emptyInput2){
                    System.out.println("|- No password given                           |");
                }
                if(!emptyInput1 && !emptyInput2){
                    if(!userExist){
                        System.out.println("|- Non-existing user                           |");                    
                    }    
                    else if(!passwordCorrect){
                        System.out.println("|- Incorrect password                          |");
                    }
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
        }
        
        System.out.println("Login Successfully");
        addMethod.pressKeyCont(scanner);
        //continue
        TransactionApp.staffMenuDisplay();
    }
    
    
}
