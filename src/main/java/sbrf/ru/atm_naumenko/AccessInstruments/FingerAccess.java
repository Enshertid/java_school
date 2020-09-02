package sbrf.ru.atm_naumenko.AccessInstruments;

import java.util.Scanner;

public class FingerAccess implements AccessInstrument{
    private final String secret;
    private int pin;
    private int countOfAttempts = 0;

    public FingerAccess(String secret, int pin) {
        this.secret = secret;
        this.pin = pin;
    }

    @Override
    public String getSecret() {
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("finger of rubber")) {
            countOfAttempts++;
            //сделать ограниченое количество попыток и принудительный ввод пин-кода
            // при отсутствии которого будет вылетать исключение
            return ("WRONG");
        } else {
            countOfAttempts = 0;
            return secret;
        }
    }
}
