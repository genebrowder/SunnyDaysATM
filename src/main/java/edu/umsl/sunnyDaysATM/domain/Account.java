package edu.umsl.sunnyDaysATM.domain;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.umsl.sunnyDaysATM.TransactionAsStrings;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = 336542947443965225L;

    @GeneratedValue(strategy= IDENTITY)
    @Column(name="ACCOUNT_ID", unique = true, nullable = false)
    @Id
    private long id;

    @Column(name="ACCOUNT_NUMBER")
    private int accountNumber;

    @Column(name="TYPE_OF_ACCOUNT_NUMBER")
    private int typeOfAccountNumber;

    @Column(name="TYPE_OF_ACCOUNT_NAME")
    private String typeOfAccountName;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;


//    @OneToMany(fetch = FetchType.LAZY)
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "account",fetch = FetchType.EAGER)
    private List<Transaction> transactions = new ArrayList<Transaction>();

//
//
    public Account() {

    }

    public void addTransactions(Transaction transaction){
         transactions.add(transaction) ;
    }

    public List<Transaction> getCheckingTransactions(){

        List<Transaction> checkingTransactions= new ArrayList<Transaction>();;

        for(Transaction transaction: transactions)   {
           if(typeOfAccountName.equals("CHECKING")){
               checkingTransactions.add(transaction) ;
           }
        }

        return  checkingTransactions;
    }
    public List<Transaction> getSavingsTransactions(){

        List<Transaction> savingsTransactions= new ArrayList<Transaction>();

        for(Transaction transaction: transactions)   {
            if(typeOfAccountName.equals("SAVINGS")){
                savingsTransactions.add(transaction) ;
            }
        }

        return  savingsTransactions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getTypeOfAccountNumber() {
        return typeOfAccountNumber;
    }

    public void setTypeOfAccountNumber(int typeOfAccountNumber) {
        this.typeOfAccountNumber = typeOfAccountNumber;
    }

    public String getTypeOfAccountName() {
        return typeOfAccountName;
    }

    public void setTypeOfAccountName(String typeOfAccountName) {
        this.typeOfAccountName = typeOfAccountName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Transaction getLastCheckingTransaction() {

        Set<Transaction> checkingTransactions = new HashSet<Transaction>();

        for (Transaction transaction : transactions) {
            if (typeOfAccountName.equals("CHECKING")) {
                checkingTransactions.add(transaction);
            }
        }
        Date tempDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            tempDate = sdf.parse("12-31-2015");
        }  catch(ParseException ex){
            ex.printStackTrace();
        }
        Transaction lastCheckingTransaction = new Transaction();
        for (Transaction transaction : checkingTransactions) {
            if (transaction.getDateOfTranaction().compareTo(tempDate) > 0) {
                tempDate =  transaction.getDateOfTranaction();
                lastCheckingTransaction = transaction;
            }
        }

        return lastCheckingTransaction;
    }

    public Transaction getLastSavingsTransaction() {

        Set<Transaction> savingsTransactions = new HashSet<Transaction>();

        for (Transaction transaction : transactions) {
            if (typeOfAccountName.equals("SAVINGS")) {
                savingsTransactions.add(transaction);
            }
        }
        Date tempDate = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
            tempDate = sdf.parse("12-31-2015");
        }  catch(ParseException ex){
            ex.printStackTrace();
        }
        Transaction lastSavingsTransaction = new Transaction();
        for (Transaction transaction : savingsTransactions) {
            if (transaction.getDateOfTranaction().compareTo(tempDate) > 0) {
                tempDate =  transaction.getDateOfTranaction();
                lastSavingsTransaction = transaction;
            }
        }

        return lastSavingsTransaction;
    }

    public double getCheckingBalance() {

        Transaction lastTransaction = getLastCheckingTransaction();

        return lastTransaction.getBalance();
    }

    public double getSavingsBalance() {

        Transaction lastTransaction = getLastSavingsTransaction();

        return lastTransaction.getBalance();
    }

    public Date getLastCheckingTransactionDate() {

        Transaction lastTransaction = getLastCheckingTransaction();

        return lastTransaction.getDateOfTranaction();
    }
    public Date getLastSavingsTransactionDate() {

        Transaction lastTransaction = getLastSavingsTransaction();

        return lastTransaction.getDateOfTranaction();
    }

        public Date getLastDateOfYear() {
            Date lastDateOfYear = new GregorianCalendar(2016, Calendar.DECEMBER, 31).getTime();
        return lastDateOfYear;
    }


    public String getDateAsString(Date originalDate) {


            String[] formatStrings = {"yyyy-MM-dd HH:mm:ss.S", "EEE MMM dd HH:mm:ss z yyyy", "EEE MMM dd HH:mm:ss zzz YYYY"};
            DateFormat targetFormat = new SimpleDateFormat("MM-dd-yyyy");
            String formattedDate = "";
            for (String formatString : formatStrings)
            {
                System.out.println("Trying: "+formatString);

                try {
                    SimpleDateFormat parserSDF = new SimpleDateFormat(formatString, Locale.ENGLISH);
                    Date tempDate = parserSDF.parse(originalDate.toString());
                    formattedDate  = targetFormat.format(tempDate);
                    return formattedDate;

                } catch (ParseException e) {
                    e.printStackTrace();
                }

            }



        return null;

    }





    public Transaction modifyAccount(Account account, String typeOfTranaction, Date dateOfTransaction, double amount)
    {
        Transaction localTransaction = new Transaction();

        switch (typeOfTranaction)
        {
            case "DEPOSIT":
                localTransaction.setAccount(account);
                localTransaction.setTypeOfTransaction("DEPOSIT");
                localTransaction.setDateOfTranaction(dateOfTransaction);
                localTransaction.setAmount(amount);
                localTransaction.setBalance(getCheckingBalance() + amount);

                addTransactions(localTransaction);

                return getLastCheckingTransaction();

            case "WITHDRAW":

                localTransaction.setTypeOfTransaction("WITHDRAW");
                localTransaction.setDateOfTranaction(dateOfTransaction);
                localTransaction.setAmount(amount);
                localTransaction.setBalance(getCheckingBalance() - amount);

                addTransactions(localTransaction);

                return getLastCheckingTransaction();

            default:

                break;

        }

        return null;
    }


    public String printNumberAsCurrency(double number) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(number);

        return moneyString;
    }

    public List<TransactionAsStrings> formatTransactionList(List<Transaction> transactions)  {

        List<TransactionAsStrings> tempTransactionList = new ArrayList<TransactionAsStrings>();

        TransactionAsStrings tempTransaction = new TransactionAsStrings();
        tempTransaction.setTypeOfTransaction("TYPE/");
        tempTransaction.setDateOfTranaction("DATE/");
        tempTransaction.setAmount("AMOUNT/");
        tempTransaction.setBalance("BALANCE");

        tempTransactionList.add(tempTransaction) ;


        for (Transaction transaction : transactions) {

            tempTransaction = new TransactionAsStrings();
            tempTransaction.setTypeOfTransaction(transaction.getTypeOfTransaction()+"/");
            tempTransaction.setDateOfTranaction(getDateAsString(transaction.getDateOfTranaction())+"/");
            tempTransaction.setAmount(printNumberAsCurrency(transaction.getAmount())+"/");
            tempTransaction.setBalance(printNumberAsCurrency(transaction.getBalance()));

            tempTransactionList.add(tempTransaction) ;
        }

        return tempTransactionList;


    }

}