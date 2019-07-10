package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.UserModel;
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
}
