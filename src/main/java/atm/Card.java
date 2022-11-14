package atm;

import java.util.Arrays;
import java.util.List;

public class Card {

    private int cardNumber;
    private int[] pin;
    private List<Account> accounts;

    public Card(int cardNumber, int[] pin, List<Account> accounts) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.accounts = accounts;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public boolean checkPin(int[] pin) {
        return Arrays.equals(this.pin, pin);
    }
}
