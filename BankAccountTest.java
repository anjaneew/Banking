import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void deposit() {
        BankAccount account = new BankAccount("0001", "123", 4000);
        account.deposit(1000);
        double depositAmount = 1000.0;
        assertEquals(5000, account.getBalance());
    }

    @Test
    void withdraw() {
        BankAccount account = new BankAccount("0001", "123", 4000);
        account.withdraw(1000);
        double withdrawAmount = 1000.0;
        assertEquals(3000, account.getBalance());
    }
}