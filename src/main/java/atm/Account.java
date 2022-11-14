package atm;

public class Account {

    private int accountNumber;
    private int balance;

    public Account(int accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) throws Exception {
        if (balance < amount) {
            throw new Exception(ExceptionMsg.NO_BALANCE);
        }
        balance -= amount;
    }

}
