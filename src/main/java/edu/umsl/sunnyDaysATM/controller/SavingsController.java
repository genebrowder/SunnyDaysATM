package edu.umsl.sunnyDaysATM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.umsl.sunnyDaysATM.AccountChoice;
@Controller
public class SavingsController {
	@RequestMapping(value = "/savings_options", method=RequestMethod.GET)
    public ModelAndView savings(){
		ModelAndView mav = new ModelAndView("savings_options");
        //model.addAttribute("accountChoice",new AccountChoice());
        return mav;

    }

    @RequestMapping(value = {"/savings_options"}, method= RequestMethod.POST)
    public ModelAndView savings(@ModelAttribute AccountChoice accountChoice, Model model){
    	ModelAndView mav = new ModelAndView("savings_options");
        //model.addAttribute("accountChoice",accountChoice);
        return mav;

    }
}
