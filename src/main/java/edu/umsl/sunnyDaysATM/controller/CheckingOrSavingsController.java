package edu.umsl.sunnyDaysATM.controller;

import edu.umsl.sunnyDaysATM.domain.AccountChoice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by genebrowder on 3/13/16.
 */
@Controller
public class CheckingOrSavingsController {

    @RequestMapping(value = {"/checkings_or_savings"}, method= RequestMethod.GET)
    public String checkingOrSavings(Model model){
        model.addAttribute("accountChoice",new AccountChoice());
        return "checkings_or_savings";

    }

    @RequestMapping(value = {"/checkings_or_savings"}, method= RequestMethod.POST)
    public String checkingOrSavingsSubmit(@ModelAttribute AccountChoice accountChoice, Model model){
        model.addAttribute("accountChoice",accountChoice);
        return "signin";

    }
}
