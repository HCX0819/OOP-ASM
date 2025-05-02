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
        // Call the setter
        this.setContact(contact); 
        this.seteContact(eContact);
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
        String mContactFormat = "+6";
        if (contact != null && !contact.trim().isEmpty()) {
            String trimmedContact = contact.trim();
            if (!trimmedContact.startsWith(mContactFormat)) {
                this.contact = mContactFormat + trimmedContact;
            }else{
                this.contact = trimmedContact; // Already starts with +6
            }
        }else{
            this.contact = "";
        }
        System.out.println(this.contact);
    }

    public String geteContact() {
        return eContact;
    }

    public void seteContact(String eContact) {
        System.out.println("seteContact() called with: " + eContact);
        String mContactFormat = "+6";
        if (eContact != null && !eContact.trim().isEmpty()) {
            String trimmedEContact = eContact.trim(); //trim down the contact input, if confirm no empty input
            if (!trimmedEContact.startsWith(mContactFormat)) { 
                this.eContact = mContactFormat + trimmedEContact; 
                //put +6 together with the trimmed input if +6 is confirmed not there
            }else{
                this.eContact = trimmedEContact; // Already starts with +6, remained the same
            }
        }else{
            this.eContact = "";
        }
        System.out.println("contact attribute is now: " + this.eContact);
    }
    
//    //Method
//    public abstract void signUp(Scanner scanner, ArrayList<? extends Account> accountList);
//    
//    public abstract void logIn(Scanner scanner, ArrayList<? extends Account> accountList); 
    
       
}    

    
    
    

