package edu.umsl.sunnyDaysATM.domain;

/**
 * Created by genebrowder on 3/10/16.
 */
public class UserLoginInfo {
    int accountNumber;
    int pin;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
