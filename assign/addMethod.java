package assign;
import java.util.Scanner;

//additional methods that would be called later
public class addMethod {
//print only 
    //vehicle drawing
    public static void car(){
      System.out.println(
        "   __---~~~~--__                      __--~~~~---__\n" +
        " `\\---~~~~~~~~\\\\                    //~~~~~~~~---/'  \n" +
        "   \\/~~~~~~~~~\\||                  ||/~~~~~~~~~\\/ \n" +
        "               `\\\\                //'\n" +
        "                 `\\\\            //'\n" +
        "                   ||          ||      \n" +
        "         ______--~~~~~~~~~~~~~~~~~~--______              \n" +
        "    ___ // _-~                        ~-_ \\\\ ___  \n" +
        "   `\\__)\\/~                              ~\\/(__/'          \n" +
        "    _--`-___                            ___-'--_        \n" +
        "  /~     `\\ ~~~~~~~~------------~~~~~~~~ /'     ~\\        \n" +
        " /|        `\\         ________         /'        |\\     \n" +
        "| `\\   ______`\\_      \\------/      _/'______   /' |          \n" +
        "|   `\\_~-_____\\ ~-________________-~ /_____-~_/'   |  \n" +
        "`.     ~-__________________________________-~     .'       \n" +
        " `.      [_______/------|~~|------\\_______]      .'\n" +
        "  `\\--___((____)(________\\/________)(____))___--/'           \n" +
        "   |>>>>>>||                            ||<<<<<<|\n"
      );  
    }
    
    public static void car2(){
        System.out.println("	    __               __\n" +
            "___________|__\\             /__|___________\n" +
            "\\__________-' '=.         .=' '-__________/           \n" +
            "                \\\\	 //\n" +
            "           ______\\\\_____//______\n" +
            "	  '                     '\n" +
            "         /                       \\\n" +
            "      __'____________________.--._'_\n" +
            "     /   ________________________   \\\n" +
            "     |/[_][_]______ARVRS_____[_][_]\\|                   \n" +
            "     \\___<_>_______|HCX|_______<_>__/                  \n" +
            "     |\\___=======================__/|\n" +
            "     |__|'                      '|__|\n"
        );
    }
    
    public static void van(){
        System.out.println(
                "          ___________________________________________________\n" +
                "         /  _________ |  ______________________________      \\\n" +
                "        /  /         || |          |     |             \\     |\n" +
                "       /  /          || |          |     |              \\    |\n" +
                "      /  /__________/ |  \\_________|_____|_______________)   |\n" +
                "   __/           (==) | [.]                                 _|\n" +
                "  /                   |                                    |_|\n" +
                " (}                   |                                    | |\n" +
                "/_]                   |                                    |_|\n" +
                "|       _______       |                         _______      |\n" +
                "|______//     \\\\      |.______________________.//     \\\\     |\n" +
                "\\.____/ | [_] | \\_____|_______________________/ | [_] | \\___./ \n" +
                "        \\.___./                                 \\.___./\n"
        );
    }
    
    //banner
    public static void banner(){
        System.out.println("===========================================\n------A RANDOM VEHICLE RENTING SYSTEM------\n===========================================");
    }
    
    public static void emptyLine(){
        System.out.println("|                                              |");
    }
    
    public static void headerSignUp(){
        car2();
        banner();
        addMethod.separator();
        System.out.println("|[Sign Up]                                     |\n|Please provide the necessary information      |");
        addMethod.emptyLine();
        addMethod.separator();
    }

    public static void headerLogIn(){
        van();
        banner();
        addMethod.separator();
        System.out.println("|[Log In]                                      |\n|Please provide the necessary information      |");
        addMethod.emptyLine();
        addMethod.separator();
    }
    
    public static void separator(){
        System.out.println("+----------------------------------------------+");
    
    }
    
    public static void errorHeader(){
        System.out.print("|[ERROR found]");
    
    }
    
    public static void plsTryAgain(){
        System.out.println(" --Please try again--");
        
    }
//methods
    //clear screen method
    public static void clearScreen(){
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } 
            else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } 
        
        catch (Exception e) {
            System.out.println("Error clearing screen");
        }
    }
    
    public static void pressKeyCont(Scanner anyKey){
        System.out.println("Please any key to continue...");
        anyKey.nextLine();
    
    }
    
    public static void exitConfirm(Scanner scanner){
        String exitConfirm;
        
        clearScreen();
        car2();
        banner();
        
        separator();
        System.out.println("|[Exit]                                        |");
        emptyLine();
        System.out.println("|        Are you sure you want to EXIT?        |");
        System.out.println("|                 [ Yes / No ]                 |");
        emptyLine();
        separator();
        do{
            System.out.print(" Option(Y for Yes and N for No) : ");
            exitConfirm = scanner.nextLine().toUpperCase();
            
            if(!exitConfirm.equals("Y") && !exitConfirm.equals("N")){
                separator();
                errorHeader();
                System.out.println("                                 |");
                System.out.println("|- Invalid aside from \"Y\" and \"N\"          |");
                emptyLine();
                separator();
                plsTryAgain();  
            }
        
        }while(!exitConfirm.equals("Y") && !exitConfirm.equals("N"));
        
        if (exitConfirm.equals("Y")){
            System.out.println("\nExiting the program...");
            System.exit(0);
        }else{
            Start.menu();
        }
    
    }
}
