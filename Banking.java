package Banking;

/**
 * @author : Anjanee S. Wijewardana
 *
 */

import java.util.Scanner;

public class Banking {
    public static void main(String[] args){

        //Scanner object set up
        Scanner scanner = new Scanner(System.in);
        //Bank object
        BankAccount myAccount = new BankAccount(0);

        //input
        System.out.println("-----------------------------------------------");
        System.out.println("Welcome to banking system");
        myAccount.printBalance();

        //deposit
        System.out.println("What is the amount you wish to deposit? ");
        double depositAmount = scanner.nextDouble();
        myAccount.deposit(depositAmount);
        myAccount.printBalance();

        //withdraw
        System.out.println("What is the amount you wish to withdraw? ");
        double withdrawAmount = scanner.nextDouble();
        myAccount.withdraw( withdrawAmount);
        myAccount.printBalance();

        //ADD Transfer


    }
}
