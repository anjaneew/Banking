import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    @DisplayName("Deposit positive amount")
    void depositPositiveAmount() {

        //Account 1
        BankAccount account1 = new BankAccount("0001", "1234", 4000);
        account1.deposit(1000);
        double depositAmount = 1000.0;
        assertEquals(5000, account1.getBalance());

        //Account 2
        BankAccount account2 = new BankAccount("0002", "1234", 5000);
        account2.deposit(400);
        assertEquals(5400, account2.getBalance());

        //Account 3
        BankAccount account3 = new BankAccount("0003", "1234", 5000);
        account3.deposit(300);
        assertEquals(5300, account3.getBalance());
    }

    @Test
    @DisplayName("Deposit negative amount")
    void depositNegativeAmount() {

        //Account 1
        BankAccount account1 = new BankAccount("0002", "1234", 4000);
        assertThrows(IllegalArgumentException.class, () -> account1.deposit(-1000));

        //Account 2
        BankAccount account2 = new BankAccount("0002", "1234", 5000);
        assertThrows(IllegalArgumentException.class, () -> account2.deposit(-300));

        //Account 3
        BankAccount account3 = new BankAccount("0003", "1234", 5000);
        assertThrows(IllegalArgumentException.class, () -> account3.deposit(-2000));
    }

    @Test
    @DisplayName("Withdraw positive amount")
    void withdrawPositiveAmount() {
        //Account 1
        BankAccount account1 = new BankAccount("0001", "123", 4000);
        account1.withdraw(1000);
        double withdrawAmount = 1000.0;
        assertEquals(3000, account1.getBalance());

        BankAccount account2 = new BankAccount("0002", "123", 5000);
        account2.withdraw(400);
        assertEquals(4600, account2.getBalance());

        BankAccount account3 = new BankAccount("0003", "123", 5000);
        account3.withdraw(300);
        assertEquals(4700, account3.getBalance());
    }

    @Test
    @DisplayName("Withdraw negative amount")
    void withdrawNegativeAmount() {

        //Account 1
        BankAccount account1 = new BankAccount("0002", "123", 4000);
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(-2000));

        //Account 2
        BankAccount account2 = new BankAccount("0002", "123", 5000);
        assertThrows(IllegalArgumentException.class, () -> account2.withdraw(-300));

        //Account 3
        BankAccount account3 = new BankAccount("0003", "123", 5000);
        assertThrows(IllegalArgumentException.class, () -> account3.withdraw(-5000));

    }

    @Test
    @DisplayName("Withdraw amount less than balance")
    void withdrawAmountLessThanBalance() {

        //Account 1
        BankAccount account1 = new BankAccount("0001", "123", 4000);
        account1.withdraw(1000);
        assertEquals(3000, account1.getBalance());

        //Account 2
        BankAccount account2 = new BankAccount("0002", "123", 5000);
        account2.withdraw(400);
        assertEquals(4600, account2.getBalance());

        //Account 3
        BankAccount account3 = new BankAccount("0003", "123", 5000);
        account3.withdraw(300);
        assertEquals(4700, account3.getBalance());

    }

    @Test
    @DisplayName("Withdraw amount more than Balance")
    void withdrawAmountMoreThanBalance() {

        //Account 1
        BankAccount account1 = new BankAccount("0001", "123", 4000);
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(-10000));

        //Account 2
        BankAccount account2 = new BankAccount("0002", "123", 5000);
        assertThrows(IllegalArgumentException.class, () -> account2.withdraw(-6000));

        //Account 3
        BankAccount account3 = new BankAccount("0003", "123", 10000);
        assertThrows(IllegalArgumentException.class, () -> account3.withdraw(-10000));
    }


    @Test
    @DisplayName("Transfer positive Amount")
    void transferPositiveAmount() {

        //Account 1
        BankAccount account1 = new BankAccount("0001", "123", 4000);
        BankAccount account2 = new BankAccount("0002", "123", 5000);
        account1.transfer(500, account2);
        assertEquals(3500, account1.getBalance());
        assertEquals(5500, account2.getBalance());

        //Account 2
        BankAccount account3 = new BankAccount("0003", "123", 5000);
        BankAccount account4 = new BankAccount("0004", "123", 5000);
        account3.transfer(500, account4);
        assertEquals(4500, account3.getBalance());
        assertEquals(5500, account4.getBalance());

        //Account 3
        BankAccount account5 = new BankAccount("0005", "123", 500);
        BankAccount account6 = new BankAccount("0006", "123", 300);
        account5.transfer(500, account6);
        assertEquals(0, account5.getBalance());
        assertEquals(800, account6.getBalance());
    }

    @Test
    @DisplayName("Transfer negative Amount")
    void transferNegativeAmount() {

        //Account 1
        BankAccount account1 = new BankAccount("0001", "123", 4000);
        BankAccount account2 = new BankAccount("0002", "123", 5000);
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(-6000, account2));

        //Account 2
        BankAccount account3 = new BankAccount("0003", "123", 5000);
        BankAccount account4 = new BankAccount("0004", "123", 5000);
        assertThrows(IllegalArgumentException.class, () -> account3.transfer(-60, account4));

        //Account 3
        BankAccount account5 = new BankAccount("0005", "123", 500);
        BankAccount account6 = new BankAccount("0006", "123", 300);
        assertThrows(IllegalArgumentException.class, () -> account5.transfer(-800, account6));
    }


    @Test
    @DisplayName("Transfer less than balance")
    void transferLessThanBalance() {

        //Account 1
        BankAccount account1 = new BankAccount("0001", "123", 4000);
        BankAccount account2 = new BankAccount("0002", "123", 5000);
        account1.transfer(500, account2);
        assertEquals(3500, account1.getBalance());
        assertEquals(5500, account2.getBalance());

        //Account 2
        BankAccount account3 = new BankAccount("0003", "123", 5000);
        BankAccount account4 = new BankAccount("0004", "123", 5000);
        account3.transfer(500, account4);
        assertEquals(4500, account3.getBalance());
        assertEquals(5500, account4.getBalance());

        //Account 3
        BankAccount account5 = new BankAccount("0005", "123", 500);
        BankAccount account6 = new BankAccount("0006", "123", 300);
        account5.transfer(500, account6);
        assertEquals(0, account5.getBalance());
        assertEquals(800, account6.getBalance());
    }


    @Test
    @DisplayName("Transfer more than balance")
    void transferMoreThanBalance() {

        //Account 1
        BankAccount account1 = new BankAccount("0001", "123", 4000);
        BankAccount account2 = new BankAccount("0002", "123", 5000);
        assertThrows(IllegalArgumentException.class, () -> account1.transfer(4500, account2));

        //Account 2
        BankAccount account3 = new BankAccount("0003", "123", 5000);
        BankAccount account4 = new BankAccount("0004", "123", 5000);
        assertThrows(IllegalArgumentException.class, () -> account3.transfer(6000, account4));

        //Account 3
        BankAccount account5 = new BankAccount("0005", "123", 500);
        BankAccount account6 = new BankAccount("0006", "123", 300);
        assertThrows(IllegalArgumentException.class, () -> account5.transfer(800, account2));
    }

}