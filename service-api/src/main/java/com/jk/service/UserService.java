package com.jk.service;

import com.jk.model.AreaModel;
import com.jk.model.GongzuoModel;
import com.jk.model.UserModel;
import com.jk.model.ZyeleibieModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface UserService {
    //测试
    @GetMapping("findmysql")
    List<UserModel> findmysql();
    //注册
    @RequestMapping("findreg")
    void findreg(@RequestBody UserModel userModel);
    //地区
    @RequestMapping("findarea")
    List<AreaModel> findarea();
    //工作
    @RequestMapping("findgongzuo")
    List<GongzuoModel> findgongzuo();
    //专业类别
    @RequestMapping("findzyeleibie")
    List<ZyeleibieModel> findzyeleibie();
}
