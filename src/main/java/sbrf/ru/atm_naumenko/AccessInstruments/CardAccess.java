package sbrf.ru.atm_naumenko.AccessInstruments;

import java.util.Scanner;

public class CardAccess implements AccessInstrument{
    private final String secret;
    private int pin;

    public CardAccess(String secret, int pin) {
        this.secret = secret;
        this.pin = pin;
    }

    public void setPin(int newPin) { pin = newPin; }

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
