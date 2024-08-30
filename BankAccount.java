package Banking;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author : Anjanee S. Wijewardana
 *
 */



public class BankAccount {

    String User;
    String Password;
    double balance;
    int service;

    public BankAccount(double balance){
        this.balance = balance;
    }



    //use switch to select which action?

    public void deposit(double depositAmount){
        balance += depositAmount;
    }

    public void withdraw(double withdrawAmount){
        balance -= withdrawAmount;
    }

    //ADD TRANSFER
    //special method to transfer money from one account to another


    public void printBalance(){
        System.out.println("-----------------------------------------------");
        System.out.println("The current balance is: "+ balance + "Euros");
    }

}
