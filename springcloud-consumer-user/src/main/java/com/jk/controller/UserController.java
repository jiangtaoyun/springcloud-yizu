package com.jk.controller;

import com.jk.model.Qiuser;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author:slm
 * @Date：
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("findmysql")
    public List<Qiuser> findmysql(){

      return  userService.findmysql();
    }

}
