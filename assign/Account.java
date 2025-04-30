/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assign;

//import java.util.ArrayList;
//import java.util.Scanner;

public class Account{
//public abstract class Account{
 
    // account details
    private String uName;
    private String eAddress;
    private String password;
    // personal details
    private String name;
    private String icNum;
    private String contact;
    private String eContact;
    
    public Account(String uName,String eAddress,String password,String name,String icNum,String contact,String eContact){
        this.uName = uName;
        this.eAddress = eAddress;
        this.password = password;

        this.name = name;
        this.icNum = icNum;
        this.contact = contact;
        this.eContact = eContact;
    }

    //accessor and mutator (getter and setter)
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }
    
    public String geteAddress() {
        return eAddress;
    }

    public void seteAddress(String eAddress) {
        this.eAddress = eAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcNum() {
        return icNum;
    }

    public void setIcNum(String icNum) {
        this.icNum = icNum;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String geteContact() {
        return eContact;
    }

    public void seteContact(String eContact) {
        this.eContact = eContact;
    }
    
//    //Method
//    public abstract void signUp(Scanner scanner, ArrayList<? extends Account> accountList);
//    
//    public abstract void logIn(Scanner scanner, ArrayList<? extends Account> accountList); 
    
       
}    

    
    
    

