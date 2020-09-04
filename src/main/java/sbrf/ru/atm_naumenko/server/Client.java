package sbrf.ru.atm_naumenko.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Client {
    private Map<String, Account> accounts;
    private String secret;
    private long number;

    Client(HashMap<String, Account> accounts){
        this.accounts = accounts;
    }

    public Optional<Account> getAccount(String accountNumber) {
        return Optional.ofNullable(accounts.get(accountNumber));
    }

    public long getNumber() {return number; }
}
