package sbrf.ru.atm_naumenko.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class Client {
    private Map<String, Account> accounts;
    private String secret;
    private long number;
    private int pin;

    Client(HashMap<String, Account> accounts, String secret){
        this.accounts = accounts;
        this.secret = secret;
    }

    public Optional<Account> getAccount(String accountNumber) {
        return Optional.ofNullable(accounts.get(accountNumber));
    }

    public String getSecret() {
        return secret;
    }
    public int getPin() {
        return pin;
    }


    public long getNumber() {return number; }
}
