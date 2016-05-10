package edu.umsl.sunnyDaysATM.domain;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable {

    private static final long serialVersionUID = 336542947443965225L;

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ACCOUNT_ID")
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

//    Date lastDateOfYear = new GregorianCalendar(2016, Calendar.DECEMBER, 31).getTime();
//
    public Account() {

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

//    public Date getLastDateOfYear() {
//        return lastDateOfYear;
//    }
//
//    public void setLastDateOfYear(Date lastDateOfYear) {
//        this.lastDateOfYear = lastDateOfYear;
//    }

    //    public double getBalance() {
//        return getLastTransaction().getBalance();
//    }


//    public String getLastDayModifiedAsString() {
//
//        try {
//            DateFormat originalFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
//            DateFormat targetFormat = new SimpleDateFormat("MM-dd-yyyy");
//            Date date = originalFormat.parse(getLastTransaction().getDateOfTranaction().toString());
//            String formattedDate = targetFormat.format(date);
//            return formattedDate;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }

    public String formatTheDateAsString(Date dateToBeFormatted) {

        try {
            DateFormat originalFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
            DateFormat targetFormat = new SimpleDateFormat("MM-dd-yyyy");
            Date date = originalFormat.parse(dateToBeFormatted.toString());
            String formattedDate = targetFormat.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;

    }

//    public Date getLastDayModifiedAsDate() {
//
//        try {
//            DateFormat originalFormat = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
//            DateFormat targetFormat = new SimpleDateFormat("MM-dd-yyyy");
//            Date date = originalFormat.parse(getLastTransaction().getDateOfTranaction().toString());
//            String formattedDate = targetFormat.format(date);
//            DateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
//            Date lastDayModified = null;
//
//            try {
//
//                lastDayModified = formatter.parse(formattedDate);
//
//            } catch (ParseException e) {
//                System.out.println("Unable to parse " + formattedDate);
//            }
//            return lastDayModified;
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//
//    }

    /**
     *
     */


//    public List<Transaction> getTransactions() {
//        return transactions;
//    }
//
//    public void setTransactions(List<Transaction> transactions) {
//        this.transactions = transactions;
//    }
//
//    private Transaction getLastTransaction() {
//        Transaction transaction = transactions.get(transactions.size() - 1);
//
//        return transaction;
//    }

//    public void menu() {
//        try {
//            int input = 0;
//
//            do {
//                try {
//                    final String os = System.getProperty("os.name");
//
//                    if (os.contains("Windows")) {
//                        Runtime.getRuntime().exec("cls");
//                    } else {
//                        Runtime.getRuntime().exec("clear");
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//                System.out.println("*******************************************");
//                System.out.println("***     Choose a transactions Type:     ***");
//                System.out.println("***      1). Deposit                    *** ");
//                System.out.println("***      2). Withdraw                   ***");
//                System.out.println("***      3). Check Balance              ***");
//                System.out.println("***      4). History                    ***");
//                System.out.println("***      5). Exit                       ***");
//                System.out.println("******************************************");
//
//                Scanner sc = new Scanner(System.in);
//                input = sc.nextInt();
//
//
//                if (input == 1) {
//
//                    deposit();
//
//                } else if (input == 2) {
//
//                    withdraw();
//
//                } else if (input == 3) {
//
//                    checkBalance();
//                }
//                else if(input == 4)
//                {
//                    history();
//                }
//            } while (input != 5);
//        } catch (Exception e) {
//
//        }
//    }

//    public void processTransaction(Transaction transaction) {
//        transactions.add(transaction);
//    }

//    public void deposit(Transaction transaction) {
//        processTransaction(transaction);
//
//    }

//    public void deposit() {
//        try {
//            final String os = System.getProperty("os.name");
//
//            if (os.contains("Windows")) {
//                Runtime.getRuntime().exec("cls");
//            } else {
//                Runtime.getRuntime().exec("clear");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("\nYour current balance is: " + printNumberAsCurrency(getBalance()));
//
//        System.out.println("\n\tA DEPOSIT can be made on or after " + getLastDayModifiedAsString() + ". ");
//        System.out.println("\n\tOr on or before 12-31-2015. ");
//        System.out.println("\nPlease enter the Date of the Deposit (mm-dd-yyyy):");
//        String inputDate = sc.nextLine();
//        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
//        Date dateOfDeposit = null;
//        try {
//
//            dateOfDeposit = df.parse(inputDate);
//
//        } catch (ParseException e) {
//            System.out.println("Unable to parse " + inputDate);
//        }
//
//        System.out.println("Enter the amount to deposit: ");
//        double deposit = sc.nextDouble();
//
//        if (getLastDayModifiedAsDate().compareTo(dateOfDeposit) <= -0) {
//
//            if (dateOfDeposit.compareTo(lastDateOfYear) <= 0) {
//
//
//
//                if (deposit >= 0.0) {
//                    Transaction transaction = new Transaction();
//                    transaction.setTypeOfTransaction("DEPOSIT");
//                    transaction.setAmount(deposit);
//                    transaction.setDateOfTranaction(dateOfDeposit);
//
//                    transaction.setBalance(getBalance() + transaction.getAmount());
//
//                    processTransaction(transaction);
//
//                    System.out.println("\n\tA DEPOSIT was made to the account.");
//
//                    System.out.println("\tIt now has a balance of:  " + printNumberAsCurrency(getBalance()));
//
//                    System.out.println("\n\tTHANK YOU!  ");
//                } else {
//                    System.out.println("\n\tError. Invalid DEPOSIT amount. ");
//                }
//            } else {
//                System.out.println("\n\tError. The DEPOSIT must be done on or before 12-31-2015. ");
//            }
//        } else {
//            System.out.println("\n\tError. TThe DEPOSIT must be done on or after "+getLastDayModifiedAsString()+". ");
//        }
//
//    }

//    public void withdraw() {
//
//        try {
//            final String os = System.getProperty("os.name");
//
//            if (os.contains("Windows")) {
//                Runtime.getRuntime().exec("cls");
//            } else {
//                Runtime.getRuntime().exec("clear");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("\nYour current balance is: " + printNumberAsCurrency(getBalance()));
//
//        System.out.println("\n\tA WITHDRAWAL can be made on or after " + getLastDayModifiedAsString() + ". ");
//        System.out.println("\n\tOr on or before 12-31-2015. ");
//        System.out.println("\nPlease enter the Date of the Withdrawl (mm-dd-yyyy):");
//        String inputDate = sc.nextLine();
//        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
//        Date dateOfWithdrawal = null;
//        try {
//
//            dateOfWithdrawal = df.parse(inputDate);
//
//        } catch (ParseException e) {
//            System.out.println("Unable to parse " + inputDate);
//        }
//
//        System.out.println("Enter the amount to withdrawal: ");
//        double withdrawal = sc.nextDouble();
//
//        if (getLastDayModifiedAsDate().compareTo(dateOfWithdrawal) <= -0) {
//
//            if (dateOfWithdrawal.compareTo(lastDateOfYear) <= 0) {
//
//
//                if ((withdrawal >= 0.0) && (withdrawal <= getBalance())){
//                    Transaction transaction = new Transaction();
//                    transaction.setTypeOfTransaction("WITHDRAWAL");
//                    transaction.setAmount(withdrawal);
//                    transaction.setDateOfTranaction(dateOfWithdrawal);
//
//                    transaction.setBalance(getBalance() - transaction.getAmount());
//
//                    processTransaction(transaction);
//
//                    System.out.println("\n\tA Withdrawal was made to the account.");
//
//                    System.out.println("\tIt now has a balance of:  " + printNumberAsCurrency(getBalance()));
//
//                    System.out.println("\n\tTHANK YOU!  ");
//                } else {
//                    System.out.println("\n\tError. Invalid WITHDRAWAL amount. ");
//                }
//            } else {
//                System.out.println("\n\tError. The WITHDRAWAL must be done on or before 12-31-2015. ");
//            }
//        } else {
//            System.out.println("\n\tError. TThe WITHDRAWAL must be done on or after "+getLastDayModifiedAsString()+". ");
//        }
//    }

//    public void checkBalance() throws IOException {
//        try {
//            final String os = System.getProperty("os.name");
//
//            if (os.contains("Windows")) {
//                Runtime.getRuntime().exec("cls");
//            } else {
//                Runtime.getRuntime().exec("clear");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("\n\tThe balance can be checked for on or after " + getLastDayModifiedAsString() + ". ");
//        System.out.println("\n\tOr on or before 12-31-2015. ");
//        System.out.println("\nPlease enter the Date to check the balance (mm-dd-yyyy):");
//        String inputDate = sc.nextLine();
//        DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
//        Date dateToCheckBalance = null;
//        try {
//
//            dateToCheckBalance = df.parse(inputDate);
//
//
//        } catch (ParseException e) {
//            System.out.println("Unable to parse " + inputDate);
//        }
//
//
//    }


//    public void history(){
//        try {
//            final String os = System.getProperty("os.name");
//
//            if (os.contains("Windows")) {
//                Runtime.getRuntime().exec("cls");
//            } else {
//                Runtime.getRuntime().exec("clear");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        for (Iterator iterator = transactions.iterator(); iterator.hasNext();)
//        {
//            Transaction localTransaction = (Transaction)iterator.next();
//            System.out.println(localTransaction.getTypeOfTransaction()+"\t\t"+formatTheDateAsString(localTransaction.getDateOfTranaction())+"\t\t"+ printNumberAsCurrency(localTransaction.getAmount())+"\t\t" + printNumberAsCurrency(localTransaction.getBalance())) ;
//        }
//    }

    public String printNumberAsCurrency(double number) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String moneyString = formatter.format(number);

        return moneyString;
    }

}