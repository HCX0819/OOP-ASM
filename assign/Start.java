/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assign;

import java.util.Scanner;
import java.util.ArrayList;

public class Start{
    
    //counter
    private static int custIdCounter = 1;
    private static int staffIdCounter = 1;
    //array list
    private static final ArrayList<CustAccount> customerList = new ArrayList<>();  
    private static final ArrayList<StaffAccount> staffList = new ArrayList<>();
   
    static{
        customerList.add(new CustAccount("Haha","haha@gmail.com","haha12345","Jack Tan Chee Kit","010101-10-0001","+60123456789","+60111111111","CUST001"));
        customerList.add(new CustAccount("test","haha@gmail.com","test1212","Jack Tan Chee Kit","010101-10-0001","+60123456789","+60111111111","CUST002"));
        custIdCounter++;
    
        staffList.add(new StaffAccount("jack-hje","jack-hje@gmail.com","1234567","Jack Heng Jun Eng","011120-08-0002","+600000001","+600000020","ST001","Normal employee"));
        staffIdCounter++;
    }

    public static void menu(){

        addMethod.clearScreen();
        Scanner scanner = new Scanner(System.in);
        String accType;
        String loginOrSignup;
        
        addMethod.clearScreen();
        addMethod.car2();
        addMethod.banner();
        addMethod.separator();
        System.out.println("|Let's get started :)                          |");
        addMethod.emptyLine();
        System.out.println("|		I am a ...                     |");
        addMethod.emptyLine();
        System.out.println("|      [1.Customer]         [2.Staff]          |");
        addMethod.emptyLine();
        System.out.println("|[Q.Exit]                                      |");
        addMethod.separator();
        
        do{    
            System.out.print(" Option(1 for customer, 2 for staff, Q for exit) : ");
            accType = scanner.nextLine().toUpperCase();
            
            if(!accType.equals("1") && !accType.equals("2") && !accType.equals("Q")){
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");
                System.out.println("|- Input aside from \"1\" and \"2\"                |");
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
        }while(!accType.equals("1") && !accType.equals("2") && !accType.equals("Q"));
        
        if(accType.equals("2")){
            addMethod.clearScreen();
            AccLogIn.staffLogIn(scanner,staffList);    
        }
        
        if(accType.equals("Q")){
            addMethod.exitConfirm(scanner);
        }
                
        addMethod.clearScreen();
        addMethod.car2();
        addMethod.banner();
        addMethod.separator();
        System.out.println("|Let's get started :)                          |");
        addMethod.emptyLine();
        System.out.println("|           Would you like to..?               |");
        addMethod.emptyLine();
        System.out.println("|      [1.Log In]           [2.Sign Up]        |");
        addMethod.emptyLine();
        addMethod.separator();
            
        do{
            System.out.print(" OPTION(1 for Log In, 2 for Sign Up) : ");
            loginOrSignup = scanner.nextLine().toUpperCase();
            
            if(!loginOrSignup.equals("1") && !loginOrSignup.equals("2")){
                addMethod.separator();
                addMethod.errorHeader();
                System.out.println("                                 |");
                System.out.println("|- Input aside from \"1\" and \"2\"                |");
                addMethod.emptyLine();
                addMethod.separator();
                addMethod.plsTryAgain();
            }
                                     
        }while(!loginOrSignup.equals("1") && !loginOrSignup.equals("2"));
        
        if (accType.equals("1") && loginOrSignup.equals("1")){
            addMethod.clearScreen();
            AccLogIn.custLogIn(scanner,customerList);
            
        }
        
        else if (accType.equals("1") && loginOrSignup.equals("2")){
            addMethod.clearScreen();
            AccSignUp.signUp(scanner,customerList);          
            
        }
    }
    
    //use to return new generated customer id 
    public static String generateCustid(){
        return String.format("CUST%03d",custIdCounter++);  
    }
}