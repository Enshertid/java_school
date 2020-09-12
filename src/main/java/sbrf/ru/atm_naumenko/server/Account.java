package sbrf.ru.atm_naumenko.server;

import com.sun.org.apache.bcel.internal.generic.FSUB;

public class Account {
    private long balance;
    private String number;
    private Currency currency;


    public Account(long balance, Currency currency) {
        this.balance = balance;
        this.currency = currency;
    }

    public void increaseBalance(long sum) {
        balance += sum;
    }

    public void reduceBalance(long sum) {
        balance -= sum;
    }

    public long getBalance() {
        return balance;
    }

    /****************Реализовать получение баланса в разной валюте*******/

    public String getNumber() { return number; }

    public Currency getCurrency() { return currency; }
}
