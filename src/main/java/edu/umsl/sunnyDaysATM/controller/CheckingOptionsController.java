package edu.umsl.sunnyDaysATM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by genebrowder on 5/10/16.
 */
@Controller
public class CheckingOptionsController {
    @RequestMapping(value = {"/checking_options"}, method= RequestMethod.GET)
    public String checkingOrSavings(Model model){

        return "checking_options";

    }

    @RequestMapping(value = {"/checking_options"}, method= RequestMethod.POST)
    public String checkingOrSavingsSubmit(HttpServletRequest request, Model model){
        String checkingOption = request.getParameter("action");
        System.out.println("checkingOption = " + checkingOption);
        if(checkingOption.equals("DEPOSIT")) {
            return "checking_deposit";
        }else if(checkingOption.equals("WITHDRAWAL"))
        {
            return "checking_withdrawal";
        }
        else if(checkingOption.equals("BALANCE"))
        {
            return "checking_balance";
        }
        else
        {
            return "checking_transactions";
        }

    }
}
