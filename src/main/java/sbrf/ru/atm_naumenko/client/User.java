package sbrf.ru.atm_naumenko.client;

import sbrf.ru.atm_naumenko.AccessInstruments.AccessInstrument;
import sbrf.ru.atm_naumenko.AccessInstruments.CardAccess;
import sbrf.ru.atm_naumenko.AccessInstruments.FingerAccess;
import sbrf.ru.atm_naumenko.AccessInstruments.Instruments;
import sun.util.resources.cldr.aa.CurrencyNames_aa;

import javax.smartcardio.Card;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

public class User {
    //это пользователь, который заходит в сессию программы....
    // каждый раз при выходе он будет генериться заново
    // что он может?
    // авторизовываться
    // запрашивать баланс
    // вносить/снимать деньги в разной валюте
    // переключаться между аккаунтами / переводить деньги с одного аккаунта на другой
    // создавать новый аккаунт
    // он может получить доступ по инструменту к Клиенту банка целиком!
    private long numberOfClient;

    public User(ATM currentATM) throws Exception {
       identificationOfClient(currentATM);
       authorizationOfClient(currentATM);
    }

    private void identificationOfClient(ATM currentATM) {
        boolean flag = false;
        while (!flag) {
            defineClient();
            flag = checkCorrectClient(currentATM);
        }
    }

    private void defineClient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter you number, client"); // (аналог вставке карты / прикладывания телефона)
        boolean flag = false;
        while (!flag) {
            try {
                numberOfClient = scanner.nextLong();
                flag = true;
            } catch (Exception e) {
                System.out.println("incorrect format of number, try again");
            }
        }
    }

    private boolean checkCorrectClient(ATM currentATM) {
        return (currentATM.requestOfClientExists(numberOfClient));
    }

    private void authorizationOfClient(ATM currentATM) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("check your Instrument for Access");
        AccessInstrument instrument = getInstrument(scanner.nextLine(), currentATM);

    }

    private AccessInstrument getInstrument(String instrument, ATM currentATM) throws Exception{
        if (Instruments.CARD.getWord().equals(instrument)) {
            return new CardAccess(currentATM, numberOfClient);
        } else if (Instruments.FINGER.getWord().equals(instrument)) {
            return new FingerAccess(currentATM, numberOfClient);
        } else {
            return new CardAccess(currentATM, numberOfClient);
        }
    }
}
