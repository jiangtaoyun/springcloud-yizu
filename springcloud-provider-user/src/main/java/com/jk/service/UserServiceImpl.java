package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.AreaModel;
import com.jk.model.GongzuoModel;
import com.jk.model.UserModel;
import com.jk.model.ZyeleibieModel;
import com.jk.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.Transient;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

@Autowired
private UserMapper userMapper;
    //测试
    @Override
    public List<UserModel> findmysql() {
        return userMapper.findmysql();
    }

    @Override
    public void findreg(UserModel userModel) {
          userMapper.findreg(userModel);
    }

    @Override
    public List<AreaModel> findarea() {
        return userMapper.findarea();
    }

    @Override
    public List<GongzuoModel> findgongzuo() {
        return userMapper.findgongzuo();
    }

    @Override
    public List<ZyeleibieModel> findzyeleibie() {
        return userMapper.findzyeleibie();
    }
}
