package atm;

import java.util.List;

public class AtmController {

    private final CardRepository cardRepository = new CardRepository();
    private int cash;

    public AtmController(int cash) {
        this.cash = cash;
    }

    public Card checkPin(int cardNumber, int[] pin) throws Exception {
        return cardRepository.findByCardNumberAndPin(cardNumber, pin).orElseThrow(
            () -> new Exception(ExceptionMsg.WRONG_PIN)
        );
    }

    public List<Account> getAccounts(Card card) {
        return card.getAccounts();
    }

    public int getBalance(Account account) {
        return account.getBalance();
    }

    public int deposit(Account account, int amount) {
        cash += amount;
        account.deposit(amount);
        return account.getBalance();
    }

    public int withdraw(Account account, int amount) throws Exception {
        if (cash < amount) {
            throw new Exception(ExceptionMsg.NO_CASH);
        }
        account.withdraw(amount);
        return account.getBalance();
    }
}
