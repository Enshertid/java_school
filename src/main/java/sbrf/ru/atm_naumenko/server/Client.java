package sbrf.ru.atm_naumenko.server;

public class Client {
    private Account account;

    Client(Account account){
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }
}
