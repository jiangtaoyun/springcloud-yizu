package com.jk.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("postm/{name}")
    public String postm(@PathVariable("name") String name){
        System.out.println("你好"+ name);
        String result = "你好" + name;
        return result;
    }

}
