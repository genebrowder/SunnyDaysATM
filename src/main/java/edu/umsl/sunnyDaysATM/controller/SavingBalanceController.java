package edu.umsl.sunnyDaysATM.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



public class SavingBalanceController {


	  @RequestMapping(value = {"/savings_balance"}, method= RequestMethod.GET)
	    public String checkingBalance(Model model){

	        return "savings_balance";

	    }

	    @RequestMapping(value = {"/savings_balance"}, method= RequestMethod.POST)
	    public String checkingBalanceSubmit(HttpServletRequest request, Model model, HttpSession session){

	        return "another_transaction";
	    }

	public void dog(){
		System.out.println("hi");
	}

}
