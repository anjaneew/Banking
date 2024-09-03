/**
 * @author : Anjanee S. Wijewardana
 *
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankAccount{

    String user;
    String password;
    double balance;

    private static final Logger logger = LogManager.getLogger(BankAccount.class);

    public BankAccount(String user, String password, double initialBalance){
        this.user = user;
        this.password = password;
        this.balance = initialBalance;

    }

    public String getUser() {
        logger.info("The user is " + user);
        return user;
    }

    public String getPassword() {
        logger.info("The password is " + password);
        return password;
    }

    public double getBalance() {
        logger.info("The balance is " + balance);
        return balance;
    }

    public void deposit(double depositAmount){
        if(depositAmount > 0){
            balance += depositAmount;
            logger.info("The deposit amount is " + depositAmount);
        } else {
            logger.error("Attempted to deposit " + depositAmount + " Euros");
            throw new IllegalArgumentException("Deposit amount must be greater than zero Euros.");
        }
    }

    public void withdraw(double withdrawAmount){
        if(withdrawAmount > 0){
            if (balance >= withdrawAmount){
                balance -= withdrawAmount;
                logger.info("The withdraw amount is " + withdrawAmount);
            } else {
                logger.error("Attempted to withdraw " + withdrawAmount + " Euros");
                throw new IllegalArgumentException("Withdraw amount must be greater than account balance.");
            }
        } else {
            logger.error("Attempted to withdraw " + withdrawAmount + " Euros");
            throw new IllegalArgumentException("Withdraw amount must be greater than zero Euros.");
        }
    }

    //special method to transfer money from one account to another
    public void transfer(double transferAmount, BankAccount recipient){
        if (transferAmount > 0){
            if (balance >= transferAmount){
                this.balance -= transferAmount;
                recipient.deposit(transferAmount);
                logger.info( transferAmount +  "Euros is withdrawn from "+ user);
                logger.info( transferAmount + " Euros is transferred to "+ recipient.getUser());

            } else {
                logger.error("Attempted to transfer " + transferAmount + " Euros");
                throw new IllegalArgumentException("Transfer amount must be greater than account balance.");
            }
        } else {
            logger.error("Attempted to transfer " + transferAmount + " Euros");
            throw new IllegalArgumentException("Transfer amount must be greater than zero Euros.");
        }
    }

    public void printBalance(){
        System.out.println("-----------------------------------------------");
        System.out.println("The current balance is: "+ balance + "Euros");
        logger.info("The current balance is: "+ balance);
    }

}
