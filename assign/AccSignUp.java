/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assign;
import java.util.ArrayList;
import java.util.Scanner;

public class AccSignUp{ 
        
    //bring the arrayList and scanner as argument so can be used later    
    public static void signUp(Scanner scanner,ArrayList<CustAccount> customerList){
        addMethod.clearScreen();
        addMethod.headerSignUp();
        
        //initialize outside as for later object creation
        String uName,eAddress,password,name,icNum,contact,eContact;
        
        //validation (check if there's a existing account with the same username)
        boolean validateUName = false;    
        do{
            System.out.print(" Username : ");
            uName = scanner.nextLine();
            
            boolean emptyUsername = false;
            boolean isUsernameTaken = false;
            
            if(uName == null || uName.trim().isEmpty()){
                emptyUsername = true;
            }else{
                for(CustAccount account:customerList){
                    if (account.getuName().equals(uName)){
                        isUsernameTaken = true; 
                        break;
                    }
                }
            }
            
            if(!emptyUsername && !isUsernameTaken){
                validateUName = true;
   
            }else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");                
                
                if(emptyUsername){
                    System.out.println("|- No username given                           |");
                }
                if(isUsernameTaken){
                    System.out.println("|- Username has been taken                     |");
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
            
        }while(!validateUName);
        
        addMethod.clearScreen();
        addMethod.headerSignUp();
        
        //validate email format
        boolean validateAddress = false;
        do{
            System.out.print(" Email address(XXX@gmail.com or XXX@yahoo.com) : ");
            eAddress = scanner.nextLine();
            
            boolean emptyEAddress = false;
            boolean isEmailTaken = false;
            boolean invalidFormat = false;
            
            if(eAddress == null || eAddress.trim().isEmpty()){
                emptyEAddress = true;
            }else{
                for(CustAccount account:customerList){
                    if(eAddress.equals(account.geteAddress())){
                        isEmailTaken = true;
                        break; //escape loop when same email is found
                    }            
                }            

                if(!eAddress.contains("@yahoo.com") && !eAddress.contains("@gmail.com")){
                    invalidFormat = true;
                }
            }
            
            if(!emptyEAddress && !isEmailTaken && !invalidFormat){
                validateAddress = true;
                
            }else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");                
                
                
                if(emptyEAddress){
                    System.out.println("|- No email address given                      |");
                }
                if(isEmailTaken){
                    System.out.println("|- Email has been used                         |");
                }
                if(invalidFormat){
                    System.out.println("|- Invalid email format                        |");
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
            
        }while(!validateAddress);
        
        addMethod.clearScreen();
        addMethod.headerSignUp();
        
        boolean validatePassword = false;
        do{
            System.out.print(" Password (at least 8 characters): ");            
            password = scanner.nextLine();

            boolean emptyPassword = false;                        
            boolean passLength = false;
            
            if(password == null || password.trim().isEmpty()){ //isBlank()
                emptyPassword = true;
            }else{
                if(password.length()<8){
                    passLength = true;
                }
            }
            
            if(!emptyPassword && !passLength){
                validatePassword = true;
                
            }else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");                                
                
                if(emptyPassword){
                    System.out.println("|- Empty password                              |");
                }
                
                if(passLength){
                    System.out.println("|- Password must be at least have 8 characters |");
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
            
        }while(!validatePassword);    
        
        //Confirm password validation...
        do{
            System.out.print(" Confirm password                : ");
            String passwordConfirm = scanner.nextLine();
            
            if(passwordConfirm.equals(password)){
                break;  //break the loop if matches
                
            }else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |"); 
                System.out.println("|- Password does not match                     |");    
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();    
            }
        
        }while(true); //create infinite loop if password is not mathced
        
        addMethod.clearScreen();
        addMethod.headerSignUp();
        
        boolean validateName = false;
        do{
            System.out.print(" Name : ");
            name = scanner.nextLine();
            
            boolean emptyName = false;
            boolean nameTaken = false;
            
            if(name == null || name.trim().isEmpty()){
                emptyName = true;
            }else{
            
                for(CustAccount account : customerList){
                    if(name.equals(account.getName())){
                        nameTaken = true;
                        break;
                    }
                }
            }
            
            if(!emptyName && !nameTaken){
                validateName = true;
            }else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");                
                
                if(emptyName){
                    System.out.println("|- No name is given                            |");
                }
                if(nameTaken){
                    System.out.println("|- Name is taken already                       |");
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            
            }
            
        }while(!validateName);
        
        addMethod.clearScreen();
        addMethod.headerSignUp();
        
        //initialize false to valudateicNum so !validateicNum = true to form a do-while(true) loop
        boolean validateIcNum = false;
        //validate malaysia ic format (YYMMDD-PB-XXXX)
        do{
            System.out.print(" IC number(YYMMDD-PB-XXXX) : ");
            icNum = scanner.nextLine();
            
            try {
                // Check for empty input
                if(icNum == null || icNum.trim().isEmpty()) {
                    throw new Exception("IC number cannot be empty");
                }

                // Check length
                if(icNum.length() != 14) {
                    throw new Exception("IC must be exactly 14 characters");
                }

                // Check if IC is already used
                for(CustAccount account : customerList) {
                    if(icNum.equals(account.getIcNum())) {
                        throw new Exception("This IC number is already registered");
                    }
                }

                // Check format (YYMMDD-PB-XXXX)
                String birthDate = icNum.substring(0, 6);
                String stateCode = icNum.substring(7, 9);
                String lastFour = icNum.substring(10);

                // Check dashes
                if(icNum.charAt(6) != '-' || icNum.charAt(9) != '-') {
                    throw new Exception("Must include '-' at correct positions");
                }

                // Check birth date digits
                if(!birthDate.matches("\\d{6}")) {
                    throw new Exception("Birth date must contain only numbers");
                }

                // Check month (01-12)
                int month = Integer.parseInt(birthDate.substring(2, 4));
                if(month < 1 || month > 12) {
                    throw new Exception("Month must be between 01-12");
                }

                // Check day (01-31)
                int day = Integer.parseInt(birthDate.substring(4, 6));
                if(day < 1 || day > 31) {
                    throw new Exception("Day must be between 01-31");
                }

                // Check state code
                if(!stateCode.matches("\\d{2}")) {
                    throw new Exception("State code must contain only numbers");
                }
                if(stateCode.equals("00")) {
                    throw new Exception("State code cannot be 00");
                }

                // Check last 4 digits
                if(!lastFour.matches("\\d{4}")) {
                    throw new Exception("Last 4 digits must be numbers");
                }
                if(lastFour.equals("0000")) {
                    throw new Exception("Last 4 digits cannot all be 0");
                }

                // If we get here, all validations passed
                validateIcNum = true;

            } catch (Exception e) {
                System.out.println("\n╔════════════════ IC FORMAT ERROR ════════════════╗");
                System.out.println("║                                                  ║");
                System.out.println("║  - " + e.getMessage() + String.format("%-" + (37 - e.getMessage().length()) + "s", " ") + "║");
                System.out.println("║                                                  ║");
                System.out.println("╠══════════════════ EXAMPLE ═══════════════════════╣");
                System.out.println("║  Correct format: 990512-08-1234                  ║");
                System.out.println("║  - 990512: Birth date (YYMMDD)                   ║");
                System.out.println("║  - 08: State code                                ║");
                System.out.println("║  - 1234: Last 4 digits                           ║");
                System.out.println("╚══════════════════════════════════════════════════╝");
                System.out.println("\nPlease try again with the correct format.\n");
            }
                
        }while(!validateIcNum);
        
        addMethod.clearScreen();
        addMethod.headerSignUp();
        
        boolean validateContact = false;
        do{
            System.out.print(" Contact (no \"-\" needed)    : ");
            contact = scanner.nextLine();

            boolean emptyContact = false;
            boolean invalidContactLength = false;
            boolean contactUsed = false;
            boolean invalidContactFormat = false;
            
            if(contact == null || contact.trim().isEmpty()){
                emptyContact = true;
            }else{
                if(!contact.startsWith("0") && !contact.startsWith("+60")){
                    invalidContactFormat = true;
                }else{
                    if(contact.startsWith("0")){
                        if(contact.length()!=10 && contact.length()!=11){
                            invalidContactLength = true;
                        }
                    }
                    else if(contact.startsWith("+60")){
                        if(contact.length()!=12 && contact.length()!=13){
                        invalidContactLength = true;            
                        }
                    }
                }
                                    
                for(CustAccount account : customerList){
                    if(contact.equals(account.getContact())){
                        contactUsed = true;
                        break;
                    }
                }
                
            }
            
            if(!emptyContact && !invalidContactLength && !contactUsed && !invalidContactFormat){
                validateContact = true;
            }else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");                
                
                if(emptyContact){
                    System.out.println("|- No contact number is given                  |");
                }
                if(invalidContactLength){
                    System.out.println("|- Less or more input for contact number       |");
                }
                if(contactUsed){
                    System.out.println("|- Contact number has been used                |");
                }
                if(invalidContactFormat){
                    System.out.println("!- Invalid contact format                      |");
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
        
        }while(!validateContact);
        
        boolean validateEContact = false;
        do{
            System.out.print(" Emergency contact number : ");            
            eContact = scanner.nextLine();
            
            boolean emptyEContact = false;
            boolean sameAsContact = false;
            boolean invalidEContactLength = false;
            boolean invalidEContactFormat = false;
            
            if(eContact == null || eContact.trim().isEmpty()){
                emptyEContact = true;
            }else{
                if(!eContact.startsWith("0") && !eContact.startsWith("+60")){
                    invalidEContactFormat = true;
                }else{
                    if(eContact.startsWith("0")){
                        if(eContact.length()!=10 && eContact.length()!=11){
                            invalidEContactLength = true;
                        }
                    }
                    else if(eContact.startsWith("+60")){
                        if(eContact.length()!=12 && eContact.length()!=13){
                        invalidEContactLength = true;            
                        }
                    }
                }

                String cFormat = "+60"; 
                if(contact.startsWith(cFormat)){
                    if(eContact.startsWith("0")){
                        eContact =  cFormat + eContact;
                    }
                }
                else if(contact.startsWith("0")){
                    if(eContact.startsWith(("+60"))){
                        eContact = eContact.substring(2);
                    }
                }

                if(eContact.equals(contact)){
                    sameAsContact = true;
                }
            } 
            
            if(!emptyEContact && !emptyEContact && !sameAsContact && !invalidEContactFormat){
                validateEContact = true;
            }else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");
                
                if(emptyEContact){
                    System.out.println("|- No emergency contact number given           |");
                }
                if(sameAsContact){
                    System.out.println("|- Cannot be the same as user contact number   |");
                }
                if(invalidEContactLength){
                    System.out.println("|- Less or more input for contact              |");
                }
                if(invalidEContactFormat){
                    System.out.println("|- Invalid emergency contact format            |");
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
        
        }while(!validateEContact);
        
        //generate id
        String customerid = Start.generateCustid();
        
        addMethod.clearScreen();
        addMethod.car2();
        addMethod.banner();
        addMethod.separator();
        System.out.println("|[Sign Up]                                     |\n|Final confirmation for account creation       |");
        addMethod.emptyLine();
        addMethod.separator();
        
        //initialization
        String confirmAccCr;
      
        //display input given before
        System.out.println(
            " Provided Information/Details :\n Username                 : "+ uName + "\n" + " Email address            : "+ eAddress + "\n" + " Name                     : " 
            + name + "\n" + " IC number                : " + icNum); 
            
        if(contact.startsWith("0")){
            System.out.println(" Contact number           : +6" + contact);
        }
        else if(contact.startsWith("+60")){
            System.out.println(" Contact number           : " + contact);
        }
        if(eContact.startsWith("0")){
            System.out.println(" Emergency contact number : +6" + eContact);
        }
        else if(eContact.startsWith("+60")){
            System.out.println(" Emergency contact number : " + eContact);
        }        
           
        
        
        addMethod.separator();
        System.out.println("|[Confirm account creation]                    |");
        addMethod.emptyLine();
        System.out.println("|      Do you want to create the account?      |");
        System.out.println("|                 [ Yes / No ]                 |");
        addMethod.emptyLine();
        addMethod.separator();
        
        do{
            System.out.print(" Option(Y for yes and N for no) : ");
            confirmAccCr = scanner.nextLine().toUpperCase();
            
            if(!confirmAccCr.equals("Y") && !confirmAccCr.equals("N")){
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");
                System.out.println("|- Invalid aside from \"Y\" and \"N\"          |");
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
            
        }while(!confirmAccCr.equals("Y") && !confirmAccCr.equals("N"));
        
        if(confirmAccCr.equals("Y")){    
            System.out.println(" Account creating...please wait");
            
            //creates a new account
            CustAccount custAccount = new CustAccount(uName,eAddress,password,name,icNum,contact,eContact,customerid);    
            //add the account into the list
            customerList.add(custAccount);
            
            System.out.println(" Account created succefully.\n");
            addMethod.pressKeyCont(scanner);
            Start.menu();
            
        }else{
            addMethod.clearScreen();
            Start.menu();
        
        }
                   
    }
}