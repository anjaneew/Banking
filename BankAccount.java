package Banking;

/**
 * @author : Anjanee S. Wijewardana
 *
 */



public class BankAccount {

    double balance;

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

    //special method to transfer money from one account to another


    public void printBalance(){
        System.out.println("-----------------------------------------------");
        System.out.println("The current balance is: "+ balance + "Euros");
    }

}
