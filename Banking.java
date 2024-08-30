package Banking;

/*
 * @author : Anjanee S. Wijewardana
 *
 */

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Set;

public class Banking {
    public static void main(String[] args){

        //Scanner object set up
        Scanner scanner = new Scanner(System.in);
        //Bank object
        BankAccount myAccount = new BankAccount(10000);
        displayMenu(scanner, myAccount);
    }


    //special method
    static void displayMenu(Scanner scanner, BankAccount myAccount){
        //input
        System.out.println("-----------------------------------------------");
        System.out.println("Welcome to banking system");


        System.out.println("Enter your Username: ");
        String user = scanner.nextLine();
        System.out.println("Enter your Password: ");
        String password= scanner.nextLine();
        myAccount.printBalance();

        //storing username and balance
        Map<String, Double> map = new TreeMap();
        map.put(user, myAccount.balance);
        //NEED TO ADD A READER TO MATCH USER & PASSWORD AND DISPLAY ERRORS IF MISMATCHED


        System.out.println("Choose the service: ");
        System.out.println("1. Deposit ");
        System.out.println("2. Withdraw ");
        System.out.println("3. Transfer ");
        System.out.println("4. Account Statement");
        System.out.println("5. Exit");
        int service =scanner.nextInt();

        switch(service){
            case 1:
                //deposit
                System.out.println("What is the amount you wish to deposit? ");
                double depositAmount = scanner.nextDouble();
                myAccount.deposit(depositAmount);
                myAccount.printBalance();
                break;

            case 2:
                //withdraw
                System.out.println("What is the amount you wish to withdraw? ");
                double withdrawAmount = scanner.nextDouble();
                myAccount.withdraw( withdrawAmount);
                myAccount.printBalance();
                break;
            case 3:
                //ADD TRANSFER
                System.out.println("What is the amount you wish to transfer? ");
                //double transferAmount = scanner.nextDouble();
                //myAccount.transfer(transferAmount);
                myAccount.printBalance();
                break;
            case 4:
                myAccount.printBalance();
                break;

            case 5:
                System.out.println("Thank you for banking with us.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid");
                break;
        }



        FileOutputStream fileOutputStream = null;

        try{
            fileOutputStream = new FileOutputStream( "C:\\Users\\Anjanee Wijewardana\\Documents\\Java\\Accenture Bootcamp\\SEF_-_Participants_Workspace\\SEF - Participants Workspace\\progress\\src\\Banking\\BankData.csv", true);
            String data = "\n"+ user +","+ password + ","+  myAccount.balance;
            fileOutputStream.write(data.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
