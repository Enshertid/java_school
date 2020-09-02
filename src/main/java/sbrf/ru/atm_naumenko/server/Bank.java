package sbrf.ru.atm_naumenko.server;

import java.util.*;

public class Bank {
    List<Client> clients;

    public Bank(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public long getBalance(long clientNumber, String accountNumber) throws Exception {
        Client currentClient = validateClient(clientNumber).orElseThrow(() ->
                                                                        new Exception ("Invalid client number"));
        Account currentAccount = validateAccount(currentClient, accountNumber).orElseThrow(() ->
                                                                        new Exception("Invalid account number"));
        return currentAccount.getBalance();
    }

    private Optional<Account> validateAccount(Client client, String accountNumber) {
        return (client.getAccount(accountNumber));
    }

    private Optional<Client> validateClient(long clientNumber) {
        return (clients.stream().filter(client -> client.getNumber() == clientNumber)).findAny();
    }

}
