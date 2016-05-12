package edu.umsl.sunnyDaysATM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SavingTransactionsController {

	   @RequestMapping(value = {"/savings_transactions"}, method= RequestMethod.GET)
	    public String checkingBalance(Model model){

	        return "savings_balance";

	    }

	    @RequestMapping(value = {"/savings_transactions"}, method= RequestMethod.POST)
	    public String checkingBalanceSubmit(HttpServletRequest request, Model model, HttpSession session){

	        return "another_transaction";
	    }
	
	
}
