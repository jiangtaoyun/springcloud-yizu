package com.jk.service;

import com.jk.model.UserModel;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface UserService {
    //测试
@GetMapping("findmysql")
    List<UserModel> findmysql();
}
