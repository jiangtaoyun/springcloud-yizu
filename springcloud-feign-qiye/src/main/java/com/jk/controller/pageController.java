package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class pageController {
    @RequestMapping("toLogin")
    public String toLogin(){
        return "qiye/qiyelogin";
    }
}
