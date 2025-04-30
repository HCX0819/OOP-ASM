/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assign;

//import java.util.Scanner;
//import java.util.ArrayList;

/**
 *
 * @author 60123
 */
public class CustAccount extends Account {
    
    private String custid;
    
    public CustAccount(String uName,String eAddress,String password,String name,String icNum,String contact,String eContact,String custid){
        super(uName,eAddress,password,name,icNum,contact,eContact);
        this.custid = custid;

    }
    
    public String getCustid() {
        return custid;
    }

    public void setCustid(String custid) {
        this.custid = custid;
    
    }
    
//    @Override
//    public void logIn(Scanner scanner, ArrayList<? extends Account> accountList){
//        AccLogIn.custLogIn(scanner, (ArrayList<CustAccount>) accountList);
//    }
//    
//    public void signUp(Scanner scanner, ArrayList<? extends Account> accountList){
//        AccSignUp.signUp(scanner, (ArrayList<CustAccount>) accountList);
//    }
    
}
