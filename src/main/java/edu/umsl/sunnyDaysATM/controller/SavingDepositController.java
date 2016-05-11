package edu.umsl.sunnyDaysATM.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SavingDepositController {
	
	@RequestMapping(value = {"/saving_deposit"}, method= RequestMethod.POST)
	public String SavingsDepositSubmit(HttpServletRequest request, Model model){
		
		return "saving_deposit_complete";
	}
}
