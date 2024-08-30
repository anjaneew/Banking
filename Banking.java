package Banking;

/*
 * @author : Anjanee S. Wijewardana
 *
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;



public class Banking {

    static final String FILE_PATH =  "C:\\Users\\Anjanee Wijewardana\\Documents\\Java\\Accenture Bootcamp\\SEF_-_Participants_Workspace\\SEF - Participants Workspace\\progress\\src\\Banking\\BankData.csv";

    public static void main(String[] args){
        //Scanner object set up
        Scanner scanner = new Scanner(System.in);
        //Reading the previous CVS file
        Map<String, BankAccount> accounts = loadAccountsFromFile(FILE_PATH);


        System.out.println("-----------------------------------------------");
        System.out.println("Welcome to banking system");
        System.out.println("Enter your Username: ");
        String user = scanner.nextLine();
        //Bank object
        BankAccount myAccount = accounts.get(user);

        System.out.println("Enter your Password: ");
        String password= scanner.nextLine();


        if (myAccount == null){
            System.out.println("Account not found");
            return;
        }

        if(!authenticate(user, password, accounts)){
            System.out.println("Invalid username or password");
            return;
        } else{
            displayMenu(scanner, myAccount, accounts);
        }


    }


    //special method
    static void displayMenu(Scanner scanner, BankAccount myAccount, Map<String, BankAccount> accounts ){
        //input

        System.out.println("Choose the service: ");
        System.out.println("1. Deposit ");
        System.out.println("2. Withdraw ");
        System.out.println("3. Transfer ");
        System.out.println("4. Account Statement");
        System.out.println("5. Exit");
        int service =scanner.nextInt();


        //use switch to select which action
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
                System.out.println("What is account number you wish to transfer funds to? ");
                String recipient = scanner.next();
                BankAccount recipientAccount = accounts.get(recipient);

                if(recipientAccount == null){
                    System.out.println("Account not found");
                    return;
                } else {
                    System.out.println("What is the amount you wish to transfer? ");
                    double transferAmount = scanner.nextDouble();
                    System.out.println("You wish to transfer " + transferAmount + " from " + myAccount.user + " to " + recipient);
                    System.out.println("Press 1 to confirm or 2 to cancel");
                    int confirm = scanner.nextInt();
                    if(confirm == 1){
                        myAccount.transfer(transferAmount, recipientAccount);
                    } else if (confirm == 2) {
                        System.out.println("Transaction cancelled.");
                        myAccount.printBalance();
                        break;
                    } else {
                        System.out.println("Invalid");
                        break;
                    }
                }
                break;

            case 4:
                myAccount.printBalance();
                break;

            case 5:
                System.out.println("Thank you for banking with us.");
                saveAccountsToFile(accounts, FILE_PATH);
                System.exit(0);
                break;

            default:
                System.out.println("Invalid");
                break;
        }


        FileOutputStream fileOutputStream = null;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Anjanee Wijewardana\\Documents\\Java\\Accenture Bootcamp\\SEF_-_Participants_Workspace\\SEF - Participants Workspace\\progress\\src\\Banking\\BankData.csv"))) {
            String data = myAccount.user +"\t"+ myAccount.password + "\t"+  myAccount.balance;
            writer.write(data);
            writer.newLine();


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


    static boolean authenticate(String user, String password, Map<String, BankAccount> accounts){
        BankAccount myAccount = accounts.get(user);
        return myAccount != null && myAccount.getPassword().equals(password);
    }

    static Map<String, BankAccount> loadAccountsFromFile(String filePath){
        Map<String, BankAccount> accounts = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) !=null){
                String[] data = line.split("\t");
                if (data.length == 3){
                    String user = data[0];
                    String password = data[1];
                    double balance = Double.parseDouble(data[2]);
                    accounts.put(user, new BankAccount(user, password, balance));
                }
            }
        } catch (IOException e){
                 e.printStackTrace();
        }
        return accounts;
    }


    static void saveAccountsToFile(Map<String, BankAccount> accounts, String filePath){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (BankAccount account : accounts.values()){
                String data = account.getUser() + "\t" + account.getPassword() + "\t" + account.getBalance();
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
