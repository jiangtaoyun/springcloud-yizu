package com.jk.controller;

import com.jk.service.QiyeServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("qiye")
public class QiyeController {

    @RequestMapping("toindex")
    public String toindex(){
        System.out.println("sss");
        return "/qiye/index";
    }
    @Autowired
    private QiyeServiceFeign qiyeServiceFeign;


}
