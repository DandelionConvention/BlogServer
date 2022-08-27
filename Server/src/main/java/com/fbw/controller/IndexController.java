package com.fbw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @RequestMapping
    public String indexPage(){
        System.out.println("--------->index");
        return "redirect:/static/pages/index.html";
//        重定向
    }
}
