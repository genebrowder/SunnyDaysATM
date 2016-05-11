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
public class CheckingDepositController {

    @RequestMapping(value = {"/checkings_deposit"}, method= RequestMethod.GET)
    public String checkingOptions(Model model){

        return "checking_options";

    }

    @RequestMapping(value = {"/checkings_deposit"}, method= RequestMethod.POST)
    public String checkingOptionsSubmit(HttpServletRequest request, Model model, HttpSession session) {

        UserLoginInfo userLoginInfo = (UserLoginInfo) session.getAttribute("userLoginInfo");

        List<Account> accounts =  userLoginInfo.getUser().getAccount();

        Account checkingAccount = new Account();

        for(Account account: accounts)  {
            if(account.getTypeOfAccountName().equals("CHECKING"))  {
                checkingAccount =  account;
            }

        }

        String dateOfDeposit = request.getParameter("dateOfDeposit");
        String amountOfDeposit = request.getParameter("amountOfDeposit");

        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");

        Date date = new Date();
        try {

            date = formatter.parse(dateOfDeposit);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        checkingAccount.modifyAccount(checkingAccount,"DEPOSIT", date,Double.parseDouble(amountOfDeposit));

        UserLoginInfoDao.updateUserLoginInfo(userLoginInfo);

        Transaction transaction = checkingAccount.getLastCheckingTransaction();

        model.addAttribute("dateDepositAdded",transaction.getDateOfTranaction()) ;
        model.addAttribute("depositAmount",transaction.getAmount()) ;
        model.addAttribute("balance",transaction.getBalance()) ;

        return "checking_deposit_status";

    }
}
