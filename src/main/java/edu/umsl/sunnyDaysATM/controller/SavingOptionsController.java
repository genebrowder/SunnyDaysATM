package edu.umsl.sunnyDaysATM.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SavingOptionsController {
	@RequestMapping(value = {"/saving_options"}, method= RequestMethod.GET)
    public String checkingOrSavings(Model model){

        return "savings_options";
	}
	
	@RequestMapping(value = {"/saving_options"}, method= RequestMethod.POST)
    public String checkingOrSavingsSubmit(HttpServletRequest request, Model model){
        String checkingOption = request.getParameter("action");
        System.out.println("checkingOption = " + checkingOption);
        if(checkingOption.equals("DEPOSIT")) {
            return "saving_deposit";
        }else if(checkingOption.equals("WITHDRAWAL"))
        {
            return "saving_withdrawal";
        }
        else if(checkingOption.equals("BALANCE"))
        {
            return "saving_balance";
        }
        else
        {
            return "saving_transactions";
        }

    }
	
}
