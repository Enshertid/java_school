package sbrf.ru.atm_naumenko.client;

import  sbrf.ru.atm_naumenko.server.Bank;
import sbrf.ru.atm_naumenko.server.Client;

public class ATM {
    private Bank bank;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public boolean requestOfClientExists(long numberOfClient) {
        return bank.checkClientExists(numberOfClient);
    }

    public long getBalance(long clientNumber, String accountNumber) throws Exception {
        return bank.getBalance(clientNumber, accountNumber);
    }

    public String getSecret(long numberOfClient) throws Exception {
        return bank.getSecret(numberOfClient);
    }
    public int getPin(long numberOfClient) throws Exception {
        return bank.getPin(numberOfClient);
    }
}
