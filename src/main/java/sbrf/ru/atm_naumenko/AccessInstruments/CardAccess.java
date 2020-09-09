package sbrf.ru.atm_naumenko.AccessInstruments;

import sbrf.ru.atm_naumenko.client.ATM;

import java.util.Scanner;

public class CardAccess implements AccessInstrument{
    private final String secret;
    private int pin;

    public CardAccess(ATM currentATM, long numberOfClient) throws Exception{
        this.secret = getSecretFromBank(currentATM, numberOfClient);
        this.pin = getPinFromBank(currentATM, numberOfClient);
    }

    private String getSecretFromBank(ATM currentATM, long numberOfClient) throws Exception {
        return (currentATM.getSecret(numberOfClient));
    }

    private int getPinFromBank(ATM currentATM, long numberOfClient) throws Exception{
        return (currentATM.getPin(numberOfClient));
    }

    public void setPin(int newPin) {
        pin = newPin;
    }

    public String getSecret() {
        if (requestPin()) {
            return secret;
        } else {
            return ("WRONG");
        }
    }

    private boolean requestPin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter pin:");
        if (scanner.nextLine().equals(Integer.toString(pin))) {
            System.out.println("Access granted");
            return true;
        } else {
            System.out.println("Access denied");
            return false;
        }
    }
}
