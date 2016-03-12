package edu.umsl.sunnyDaysATM.controller;

import edu.umsl.sunnyDaysATM.domain.UserLoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by genebrowder on 3/3/16.
 */

// Sam's Test Comment here.

@Controller
public class IndexController {

    @RequestMapping(value = {"/index","/"}, method= RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("userLoginInfo",new UserLoginInfo());
        return "index";

    }
    @RequestMapping(value = {"/index","/"}, method= RequestMethod.POST)
    public String indexSubmit(@ModelAttribute UserLoginInfo userLoginInfo, Model model){
        model.addAttribute("userLoginInfo",userLoginInfo);
        return "signin";

    }



}
