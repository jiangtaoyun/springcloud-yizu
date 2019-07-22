package com.jk.controller;

import com.jk.model.SouWork;
import com.jk.service.SouService;
import com.jk.util.Easyuipage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class SouController {
    @Autowired
    private SouService souService;
    @GetMapping("toSouSou")
    public String  toSouSou(){
        return "SouSou";
    }


    @RequestMapping("totest")
    public String  totest(){

        return "Test";
    }
    @GetMapping("queryWork")
    @ResponseBody
    public List<SouWork> queryWork(SouWork souWork){
        List<SouWork> list =   souService.queryWork(souWork);
        return list;
    }
    @GetMapping("query")
    @ResponseBody
    public List<SouWork> query(){
        return souService.query();
    }
    @GetMapping("toTest")
    @ResponseBody
    public  String toTest(){

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++"+"请求到达controller");
        return "请求成功";
    }

}
