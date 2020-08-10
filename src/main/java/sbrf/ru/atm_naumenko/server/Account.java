package sbrf.ru.atm_naumenko.server;

public class Account {
    private long balance;
    private Currency currency;


    public Account(long balance, Currency currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getBalance() {
        return balance;
    }
}
