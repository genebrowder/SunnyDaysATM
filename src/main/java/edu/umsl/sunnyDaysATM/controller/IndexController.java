package edu.umsl.sunnyDaysATM.controller;

import edu.umsl.sunnyDaysATM.dao.UserLoginInfoDao;
import edu.umsl.sunnyDaysATM.domain.UserLoginInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by genebrowder on 3/3/16.
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/index","/"}, method= RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("userLoginInfo",new UserLoginInfo());
        return "index";

    }
    @RequestMapping(value = {"/index","/"}, method= RequestMethod.POST)
    public String indexSubmit(@ModelAttribute UserLoginInfo userLoginInfo, Model model, HttpSession session){


        if(UserLoginInfoDao.isValiduser(userLoginInfo)){

            userLoginInfo = UserLoginInfoDao.getUser(userLoginInfo);

            session.setAttribute("userLoginInfo",userLoginInfo);

//            List<Account> accounts =  userLoginInfo.getUser().getAccount();
//            System.out.println("Account Number = " +accounts.get(0).getAccountNumber());
//            model.addAttribute("lastName",userLoginInfo.getUser().getLastName());
//            model.addAttribute("firstName",userLoginInfo.getUser().getFirstName());
            return "checkings_or_savings";
        }
        else{
            model.addAttribute("userLoginInfo",new UserLoginInfo());
            return "index";
        }

    }





}
