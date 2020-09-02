package sbrf.ru.atm_naumenko.client;

import  sbrf.ru.atm_naumenko.server.Bank;

public class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public long getBalance(long clientNumber, String accountNumber) throws Exception {
        return bank.getBalance(clientNumber, accountNumber);
    }
}
