package com.jk.controller;

import com.jk.mapper.UserMapper;
import com.jk.model.UserModel;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController{

@Autowired
private UserService userService;

//测试
    @GetMapping("findmysql")
    public List<UserModel> findmysql() {
        return userService.findmysql();
    }
}
