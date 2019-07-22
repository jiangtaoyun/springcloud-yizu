package com.jk.controller;

import com.jk.model.SouWork;
import com.jk.service.FeignService;
import com.jk.util.Easyuipage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeignController {
    @Autowired
    private FeignService feignService;
    @GetMapping("queryWork")
    public List<SouWork> queryWork(SouWork souWork){
        List<SouWork> list =   feignService.queryWork(souWork);
        System.out.println("1111111111111111111111111111++++"+list);
        return list;
    }

    @GetMapping("query")
    public List<SouWork> query(){
        return feignService.query();
    }
    @GetMapping("toTest")
    public  String toTest(){
        System.out.println("--------------------------------------------------"+"请求到达controller");
        return "请求成功";
    }
}
