package edu.umsl.sunnyDaysATM.controller;

import edu.umsl.sunnyDaysATM.dao.UserLoginInfoDao;
import edu.umsl.sunnyDaysATM.domain.Account;
import edu.umsl.sunnyDaysATM.domain.Transaction;
import edu.umsl.sunnyDaysATM.domain.UserLoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by genebrowder on 5/10/16.
 */
@Controller
public class CheckingWithdrawalController {

    @RequestMapping(value = {"/checkings_withdrawal"}, method= RequestMethod.GET)
    public String checkingOptions(Model model){

        return "checking_options";

    }

    @RequestMapping(value = {"/checkings_withdrawal"}, method= RequestMethod.POST)
    public String checkingOptionsSubmit(HttpServletRequest request, Model model, HttpSession session) {

        UserLoginInfo userLoginInfo = (UserLoginInfo) session.getAttribute("userLoginInfo");

        List<Account> accounts =  userLoginInfo.getUser().getAccount();

        Account checkingAccount = new Account();

        for(Account account: accounts)  {
            if(account.getTypeOfAccountName().equals("CHECKING"))  {
                checkingAccount =  account;
            }

        }

        String dateOfwithdrawal = request.getParameter("dateOfWithdrawal");
        String amountOfwithdrawal = request.getParameter("amountOfWithdrawal");

        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

        Date date = new Date();
        try {

            date = formatter.parse(dateOfwithdrawal);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        checkingAccount.modifyAccount(checkingAccount,"WITHDRAW", date,Double.parseDouble(amountOfwithdrawal));

        UserLoginInfoDao.updateUserLoginInfo(userLoginInfo);

        Transaction transaction = checkingAccount.getLastCheckingTransaction();

        model.addAttribute("dateOfWithdrawal",checkingAccount.getDateAsString(transaction.getDateOfTranaction())) ;
        model.addAttribute("withdrawalAmount",checkingAccount.printNumberAsCurrency(transaction.getAmount()) );
        model.addAttribute("balance",checkingAccount.printNumberAsCurrency(transaction.getBalance()) );

        return "checking_withdrawal_status";

    }
}
