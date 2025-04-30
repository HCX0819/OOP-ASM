/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assign;
import java.util.ArrayList;
import java.util.Scanner;

public class AccSignUp { 
        
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
            
            if(!emptyPassword && !passLength && !emptyPassword){
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
                        
            //initialization
            boolean emptyIcNum = false;
            boolean icInvalidLength = false;
            boolean icNumUsed = false;
            boolean notDigitBday = false;
            boolean exMaxMonth = false;
            boolean doubleZeroMonth = false; //month double zero
            boolean exMaxDay = false;
            boolean dashMiss = false;
            boolean notDigitPb = false;
            boolean doubleZeroPb = false;
            boolean notDigitNum = false;
            boolean allZeroLast = false;
                
            //Check for empty input (or not assigning value to variable)
            if(icNum == null || icNum.trim().isEmpty()){
                emptyIcNum = true;

            }else{
                //Length
                if(icNum.length()!=14){
                    icInvalidLength = true;
                }

                //Day of birth
                //Avoid non-digit input for year, month(first number) and day(first number)
                for(CustAccount account :customerList){
                    if(icNum.equals(account.getIcNum())){
                        icNumUsed = true;
                        break;
                    }
                }
                if(!Character.isDigit(icNum.charAt(0)) || !Character.isDigit(icNum.charAt(1)) || !Character.isDigit(icNum.charAt(3)) || !Character.isDigit(icNum.charAt(5))){
                    notDigitBday = true;
                }

                //Month
                //Allow 1 and 0(because only 12 months, would either be 0 or 1)
                if(icNum.charAt(2)!='0' && icNum.charAt(2)!='1'){
                    exMaxMonth = true;
                }
                //cannot exceed 12 for month input
                if(icNum.charAt(2)=='1' && icNum.substring(3,4).matches("[3-9]")){
                    exMaxMonth =true;
                }
                //prevent "00" for month input
                if(icNum.charAt(2)=='0'&& icNum.charAt(3)=='0'){
                    doubleZeroMonth = true;
                }

                //Day
                //Avoid exceed 31 days, 0-3 only since max days in single month is 31
                if(icNum.charAt(4)!='0'&& icNum.charAt(4)!='1' && icNum.charAt(4)!='2' && icNum.charAt(4)!='3'){
                    exMaxDay = true;
                }
                //Avoid exceed 31 days, avoid month input between 32 to 39
                if(icNum.charAt(4)=='3' && icNum.substring(5,6).matches("[2-9]")){
                    exMaxDay = true;
                }

                //State of birth
                if(!Character.isDigit(icNum.charAt(7)) || !Character.isDigit(icNum.charAt(8))){
                    notDigitPb = true;
                }
                if(icNum.charAt(7)=='0' && icNum.charAt(8)=='0'){
                    doubleZeroPb = true;
                } 
                
                //last 4 number
                if(icNum.charAt(10) == '0' && icNum.charAt(11) == '0' && icNum.charAt(12) == '0' && icNum.charAt(13) == '0'){
                    allZeroLast = true;
                }                
                if(!icNum.substring(10).matches("[0-9]+")){
                    notDigitNum = true;
                }                

                //"-" symbol
                //Avoid symbol got replaced by other input
                if(icNum.charAt(6)!='-' || icNum.charAt(9)!='-'){
                    dashMiss =true;
                }
            }

            if(!emptyIcNum && !icInvalidLength && !icNumUsed && !notDigitBday && !exMaxMonth && !doubleZeroMonth && !exMaxDay && !dashMiss && !notDigitPb && !doubleZeroPb && !allZeroLast && !notDigitNum){
                validateIcNum = true;

            }else{
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");                                    

                if(emptyIcNum){
                    System.out.println("|- No IC number given                          |");
                }
                if(icInvalidLength){
                    System.out.println("|- Less or more input for IC numbers           |");
                }
                if(icNumUsed){
                    System.out.println("|- IC number has been used                     |");
                }
                if(notDigitBday){
                    System.out.println("|- Non-digit input for data of birth           |");
                }
                if(exMaxMonth){
                    System.out.println("|- Exceed maximum months in a year             |");
                }
                if(doubleZeroMonth){
                    System.out.println("|- Invalid month input (Month - 00)            |");
                }
                if(exMaxDay){
                    System.out.println("|- Exceed maximum days in a month              |");
                }
                if(notDigitPb){
                    System.out.println("|- Non-digit input for place of birth          |");                
                }    
                if(doubleZeroPb){
                    System.out.println("|- Invalid place of birth input (PB - 00)      |");
                }
                if(notDigitNum){
                    System.out.println("|- Non-digit input                             |");
                }
                if(allZeroLast){
                    System.out.println("|- Invalid input (00 input)                    |");
                }
                if(dashMiss){
                    System.out.println("|- Missing special symbol \"-\"                |");
                }
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
                
        }while(!validateIcNum);
        
        addMethod.clearScreen();
        addMethod.headerSignUp();
        
        boolean validateContact = false;
        do{
            System.out.print(" Contact(+60XXXXXXXXX)    : ");
            contact = scanner.nextLine();

            boolean emptyContact = false;
            boolean invalidContactLength = false;
            boolean invalidContactFormat = false;
            
            if(contact == null || contact.trim().isEmpty()){
                emptyContact = true;
            }else{
                if(contact.length()!=13 && contact.length()!=12){
                    invalidContactLength = true;            
                }
                
                if(contact.charAt(0)!='+' && contact.charAt(1)!='6' && contact.charAt(2)!='0'){
                    invalidContactFormat = true;
                }
            }
            
            if(!emptyContact && !invalidContactLength && !invalidContactFormat){
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
                if(invalidContactFormat){
                    System.out.println("|- Invalid contact number format               |");
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
            boolean invalidContactLength = false;
            boolean invalidContactFormat = false;
            
            if(eContact == null || eContact.trim().isEmpty()){
                emptyEContact = true;
            }else{
                if(eContact.equals(contact)){
                    sameAsContact = true;
                }
                if(contact.length()!=13 && contact.length()!=12){
                    invalidContactLength = true;            
                }
                
                if(eContact.charAt(0)!='+' && eContact.charAt(1)!='6' && eContact.charAt(2)!='0'){
                    invalidContactFormat = true;
                }
            }
            
            if(!emptyEContact && !emptyEContact && !sameAsContact && !invalidContactLength && !invalidContactFormat){
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
                if(invalidContactLength){
                    System.out.println("|- Less or more input for contact              |");
                }
                if(invalidContactFormat){
                    System.out.println("|- Invalid contact number format               |");
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
            + name + "\n" + " IC number                : " + icNum + "\n" + " Contact number           : " + contact + "\n" + " Emergency contact number : " + eContact + "\n"
        );
        
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