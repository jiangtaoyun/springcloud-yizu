package com.jk.service;

import com.jk.dao.QiuserMapper;
import com.jk.model.Qiuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QiyeServiceImpl implements QiyeService{

    @Autowired
    private QiuserMapper qiuserMapper;

}
