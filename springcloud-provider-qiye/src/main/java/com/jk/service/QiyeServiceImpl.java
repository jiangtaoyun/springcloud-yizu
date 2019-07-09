package com.jk.service;

import com.jk.dao.QiuserMapper;
import com.jk.model.Qiuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QiyeServiceImpl implements QiyeService{

    @Autowired
    private QiuserMapper qiuserMapper;


    @Override
    public List<Qiuser> query() {
        return qiuserMapper.query();
    }
}
