package edu.umsl.sunnyDaysATM.domain;

import javax.persistence.Entity;

/**
 * Created by genebrowder on 3/10/16.
 */
@Entity
public class UserLoginInfo {
    String accountNumber;
    String pin;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
