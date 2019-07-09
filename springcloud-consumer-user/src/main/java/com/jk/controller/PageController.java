package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:slm
 * @Date：
 **/
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

}
