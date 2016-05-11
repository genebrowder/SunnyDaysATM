package edu.umsl.sunnyDaysATM.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SavingWithdrawalController {

	@RequestMapping(value = {"/saving_withdrawal"}, method= RequestMethod.POST)
	public String SavingsDepositSubmit(HttpServletRequest request, Model model){
		
		return "saving_withdrawal_complete";
	}
	
}
