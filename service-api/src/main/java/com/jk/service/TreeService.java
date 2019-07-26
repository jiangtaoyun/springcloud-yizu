package com.jk.service;

import com.jk.model.TreeBean;

import java.util.HashMap;
import java.util.List;

public interface TreeService {

    List<TreeBean> queryTree();

    HashMap<String, Object> queryGangwei(Integer page, Integer rows);

    HashMap<String, Object> queryCompany(Integer page, Integer rows);

    Boolean updateUqiyeser(Integer qid);

    Boolean updateUqiye(Integer qid);

    HashMap<String, Object> queryYongHu(Integer page, Integer rows);

    Boolean updateUser(Integer userid);

    Boolean updateUserhei(Integer userid);
}
