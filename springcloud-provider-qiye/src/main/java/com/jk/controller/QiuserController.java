package com.jk.controller;

import com.jk.model.Qiuser;
import com.jk.service.QiyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QiuserController {

    @Autowired
    private QiyeService qiyeService;

    @RequestMapping("query")
    public List<Qiuser> query(){
        return qiyeService.query();
    }


}
