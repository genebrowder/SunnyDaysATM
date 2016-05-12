package edu.umsl.sunnyDaysATM.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SavingsWithdrawStatusController {
	 @RequestMapping(value = {"/savings_withdrawal_status"}, method= RequestMethod.GET)
	    public String checkingBalance(Model model){

	        return "saving_withdrawal_complete";

	    }

	    @RequestMapping(value = {"/savings_withdrawal_status"}, method= RequestMethod.POST)
	    public String checkingBalanceSubmit(HttpServletRequest request, Model model, HttpSession session){

	        return "another_transaction";
	    }
}
