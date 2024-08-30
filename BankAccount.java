package Banking;

/**
 * @author : Anjanee S. Wijewardana
 *
 */



public class BankAccount {

    String user;
    String password;
    double balance;
    //int service;
    //double recipientBalance;

    public BankAccount(String user, String password, double initialBalance){
        this.user = user;
        this.password = password;
        this.balance = initialBalance;

    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double depositAmount){
        balance += depositAmount;
    }

    public void withdraw(double withdrawAmount){
        if (balance >= withdrawAmount){
            balance -= withdrawAmount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    //ADD TRANSFER
    //special method to transfer money from one account to another
    public void transfer(double transferAmount, BankAccount recipient){
        if (balance >= transferAmount){
            this.balance -= transferAmount;
            recipient.deposit(transferAmount);
        } else {
            System.out.println("Insufficient balance");
        }
    }


    public void printBalance(){
        System.out.println("-----------------------------------------------");
        System.out.println("The current balance is: "+ balance + "Euros");
    }

}
