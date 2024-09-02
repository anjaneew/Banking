/**
 * @author : Anjanee S. Wijewardana
 *
 */



public class BankAccount{

    String user;
    String password;
    double balance;

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
        if(depositAmount > 0){
            balance += depositAmount;
        } else {
            throw new IllegalArgumentException("Deposit amount must be greater than zero Euros.");
        }
    }

    public void withdraw(double withdrawAmount){
        if(withdrawAmount > 0){
            if (balance >= withdrawAmount){
                balance -= withdrawAmount;
            } else {
                throw new IllegalArgumentException("Withdraw amount must be greater than account balance.");
            }
        } else {
            throw new IllegalArgumentException("Withdraw amount must be greater than zero Euros.");
        }
    }

    //special method to transfer money from one account to another
    public void transfer(double transferAmount, BankAccount recipient){
        if (transferAmount > 0){
            if (balance >= transferAmount){
                this.balance -= transferAmount;
                recipient.deposit(transferAmount);
            } else {
                throw new IllegalArgumentException("Transfer amount must be greater than account balance.");
            }
        } else {
            throw new IllegalArgumentException("Transfer amount must be greater than zero Euros.");
        }
    }

    public void printBalance(){
        System.out.println("-----------------------------------------------");
        System.out.println("The current balance is: "+ balance + "Euros");
    }

}
