/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assign;

//import java.util.ArrayList;
//import java.util.Scanner;

class StaffAccount extends Account{

    private String staffid;
    private String role;
    
    public StaffAccount(String uName,String eAddress,String password,String name,String icNum,String contact,String eContact,String staffid,String role){
        super(uName,eAddress,password,name,icNum,contact,eContact);
        this.role = role;
        this.staffid = staffid;        
    }    

//getter & setter
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getStaffid() {
        return staffid;
    }

    public void setStaffid(String staffid) {
        this.staffid = staffid;
    }
    
//    public void logIn(Scanner scanner, ArrayList<? extends Account> accountList){
//        AccLogIn.staffLogIn(scanner, (ArrayList<StaffAccount>) accountList);
//    }
        
}
