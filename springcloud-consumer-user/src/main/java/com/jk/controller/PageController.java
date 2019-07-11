package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("totest")
    public String toTest(){
        return "test";
    }
    @RequestMapping("toshow")
    public String toshow(){
        return "show";
    }
    //注册
    @RequestMapping("toreg")
    public String toreg(){
        return "reg";
    }
    //创建简历
    @RequestMapping("toresume")
    private String toresume(){
        return "resume";
    }
}
