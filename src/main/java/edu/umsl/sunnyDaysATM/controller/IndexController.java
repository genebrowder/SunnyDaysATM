package edu.umsl.sunnyDaysATM.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by genebrowder on 3/3/16.
 */
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(){

        return "index";

    }

}
