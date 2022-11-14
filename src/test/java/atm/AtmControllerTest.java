package atm;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class AtmControllerTest {

    AtmController atmController = new AtmController(10000);

    @Test
    void checkPin() throws Exception {
        Card card = atmController.checkPin(123456, new int[] {1,0,0,4});
        assertEquals(123456, card.getCardNumber());
        assertEquals(1, card.getAccounts().size());
        assertEquals(3244, card.getAccounts().get(0).getAccountNumber());
    }

    @Test
    void checkPin_fail() {
        Exception exception = assertThrows(Exception.class, () ->
            atmController.checkPin(123456, new int[] {1,0,0,2}));
        assertEquals(ExceptionMsg.WRONG_PIN, exception.getMessage());
    }

    @Test
    void getAccounts() {
        Card card = new Card(
            123456, new int[] {1,0,0,4},
            new ArrayList<>(Collections.singletonList(new Account(3244, 2000)))
        );
        List<Account> accounts = atmController.getAccounts(card);
        assertEquals(1, accounts.size());
        assertEquals(3244, accounts.get(0).getAccountNumber());
    }

    @Test
    void getBalance() {
        Account account = new Account(1234, 100);
        assertEquals(100, atmController.getBalance(account));
    }

    @Test
    void deposit() {
        Account account = new Account(1234, 100);
        assertEquals(200, atmController.deposit(account, 100));
    }

    @Test
    void withdraw() throws Exception {
        Account account = new Account(1234, 100);
        assertEquals(0, atmController.withdraw(account, 100));
    }

    @Test
    void withdraw_noCash() {
        Account account = new Account(1234, 100000);
        Exception exception = assertThrows(Exception.class, () ->
            atmController.withdraw(account, 100000));
        assertEquals(ExceptionMsg.NO_CASH, exception.getMessage());
    }

    @Test
    void withdraw_noBalance() {
        Account account = new Account(1234, 100);
        Exception exception = assertThrows(Exception.class, () ->
            atmController.withdraw(account, 200));
        assertEquals(ExceptionMsg.NO_BALANCE, exception.getMessage());
    }
}