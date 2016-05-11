package edu.umsl.sunnyDaysATM.controller;

import edu.umsl.sunnyDaysATM.domain.Account;
import edu.umsl.sunnyDaysATM.domain.Transaction;
import edu.umsl.sunnyDaysATM.domain.UserLoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by genebrowder on 5/10/16.
 */
@Controller
public class CheckingOptionsController {
    @RequestMapping(value = {"/checking_options"}, method= RequestMethod.GET)
    public String checkingOptions(Model model){

        return "checking_options";

    }

    @RequestMapping(value = {"/checking_options"}, method= RequestMethod.POST)
    public String checkingOptionsSubmit(HttpServletRequest request, Model model, HttpSession session){


        UserLoginInfo userLoginInfo = (UserLoginInfo) session.getAttribute("userLoginInfo");

        List<Account> accounts =  userLoginInfo.getUser().getAccount();

        Account checkingAccount = new Account();

        for(Account account: accounts)  {
            if(account.getTypeOfAccountName().equals("CHECKING"))  {
               checkingAccount =  account;
            }

        }


        String checkingOption = request.getParameter("action");
        System.out.println("checkingOption = " + checkingOption);

        if(checkingOption.equals("DEPOSIT")) {

            String lastCheckingTransactionDate = checkingAccount.getLastCheckingTransactionDateModifiedAsString();
            model.addAttribute("lastCheckingTransactionDate",lastCheckingTransactionDate) ;
            return "checking_deposit";
        }else if(checkingOption.equals("WITHDRAWAL"))
        {
            String lastCheckingTransactionDate = checkingAccount.getLastCheckingTransactionDateModifiedAsString();
            model.addAttribute("lastCheckingTransactionDate",lastCheckingTransactionDate) ;

            return "checking_withdrawal";
        }
        else if(checkingOption.equals("BALANCE"))
        {
            String balance = ""+checkingAccount.getCheckingBalance();
            model.addAttribute("balance",balance) ;
            return "checking_balance";
        }
        else
        {
            List<Transaction> checkingTransactions= checkingAccount.getCheckingTransactions();
            model.addAttribute("checkingTransactions",checkingTransactions) ;
            return "checking_transactions";
        }

    }
}
