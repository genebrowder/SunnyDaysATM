package edu.umsl.sunnyDaysATM.controller;

public class SavingBalanceController {

	  @RequestMapping(value = {"/savings_balance"}, method= RequestMethod.GET)
	    public String checkingBalance(Model model){

	        return "savings_balance";

	    }

	    @RequestMapping(value = {"/savings_balance"}, method= RequestMethod.POST)
	    public String checkingBalanceSubmit(HttpServletRequest request, Model model, HttpSession session){

	        return "another_transaction";
	    }
}
