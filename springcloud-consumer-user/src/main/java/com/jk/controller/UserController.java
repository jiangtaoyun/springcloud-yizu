package com.jk.controller;

import com.jk.model.AreaModel;
import com.jk.model.GongzuoModel;
import com.jk.model.UserModel;
import com.jk.model.ZyeleibieModel;
import com.jk.service.UserService;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //测试
    @GetMapping("findmysql")
    public List<UserModel> findmysql(){
      return  userService.findmysql();
    }
    //注册
    @RequestMapping("findreg")
    private boolean findreg(UserModel userModel){
        try {
            userService.findreg(userModel);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    //地区
    @RequestMapping("findarea")
    private List<AreaModel> findarea(){
        return userService.findarea();
    }
    //工作
    @RequestMapping("findgongzuo")
    private List<GongzuoModel> findgongzuo(){
        return userService.findgongzuo();
    }
    //专业类别
    @RequestMapping("findzyeleibie")
    private List<ZyeleibieModel> findzyeleibie(){
        return userService.findzyeleibie();
    }
}
