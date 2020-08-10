package sbrf.ru.atm_naumenko.client;

public class User { // наверное тут будет интерфейс взаимодействия с пользователем, не более того
    private ATM appliedATM;

    User(ATM atm){
        this.appliedATM = atm;
    }
}
