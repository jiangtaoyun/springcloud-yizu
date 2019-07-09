package com.jk.service;

import com.jk.model.Qiuser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface UserService {

@GetMapping("findmysql")
    List<Qiuser> findmysql();
}
