package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("queryTree")
    public String queryTree(){
        return "tree";

    }

    @RequestMapping("queryGang")
    public String queryGang(){
        return "show";

    }

    @RequestMapping("queryqiye")
    public String queryqiye(){
        return "qiyexinxi";

    }

    @RequestMapping("queryyong")
    public String queryyong(){

        return "yonghu";
    }

}
