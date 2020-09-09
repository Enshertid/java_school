package sbrf.ru.atm_naumenko.AccessInstruments;

import com.sun.org.apache.xpath.internal.objects.XNumber;
import sbrf.ru.atm_naumenko.client.ATM;

import java.util.Scanner;

public class FingerAccess implements AccessInstrument{
    private final String secret;
    private int pin;
    private int countOfAttempts = 0;

    public FingerAccess(ATM currentATM, long numberOfClient) throws Exception{
        this.secret = getSecretFromBank(currentATM, numberOfClient);
        this.pin = getPinFromBank(currentATM, numberOfClient);
    }

    private String getSecretFromBank(ATM currentATM, long numberOfClient) throws Exception {
        return (currentATM.getSecret(numberOfClient));
    }

    private int getPinFromBank(ATM currentATM, long numberOfClient) throws Exception{
        return (currentATM.getPin(numberOfClient));
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
