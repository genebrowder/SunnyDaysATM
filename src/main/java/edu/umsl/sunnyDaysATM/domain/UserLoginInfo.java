package edu.umsl.sunnyDaysATM.domain;

import javax.persistence.*;

/**
 * Created by genebrowder on 3/10/16.
 */
@Entity
@Table(name="USER_LOGIN_INFO")
public class UserLoginInfo {


    private static final long serialVersionUID = 336542947443965225L;
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    @Id
    private long id;

    @Column(name="ACCOUNT_NUMBER")
    String accountNumber;


    @Column(name="PIN")
    String pin;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
