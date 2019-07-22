package com.jk.service.impl;

import com.jk.mapper.TreeMapper;
import com.jk.model.Company;
import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.model.WorkBean;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<TreeBean> queryTree() {
        int pid = 0;
        List<TreeBean> list = findNode(pid);
        return list;
    }



    private List<TreeBean> findNode(int pid) {
        List<TreeBean> list = treeMapper.findTreeByPid(pid);
        for (TreeBean treeBean : list) {
            Integer id = treeBean.getId();
            List<TreeBean> nodes = findNode(id);
            if (nodes.size() <= 0) {
                //无子节点
                treeBean.setSeletetable(true);
            } else {
                //有子节点
                treeBean.setSeletetable(false);
                treeBean.setNodes(nodes);
            }
        }
        return list;

    }


    @Override
    public HashMap<String, Object> queryGangwei(Integer page, Integer rows) {

        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = treeMapper.fiotal();
        //分页
        int start = (page-1)*rows;
        List<WorkBean> list = treeMapper.findRoadPage(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;

    }

    @Override
    public HashMap<String, Object> queryCompany(Integer page, Integer rows) {

        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = treeMapper.fiotalCompany();
        //分页
        int start = (page-1)*rows;
        List<Company> list = treeMapper.findCompanyPage(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;


    }

    @Override
    public Boolean updateUqiyeser(Integer qid) {
        return treeMapper.updateUqiyeser(qid);
    }

    @Override
    public Boolean updateUqiye(Integer qid) {
        return treeMapper.updateUqiye(qid);
    }

    @Override
    public HashMap<String, Object> queryYongHu(Integer page, Integer rows) {
        HashMap<String, Object> hashMap = new HashMap<>();
        //查询总条数
        int total = treeMapper.fiotalUser();
        //分页
        int start = (page-1)*rows;
        List<User> list = treeMapper.findUser(start,rows);
        hashMap.put("total", total);
        hashMap.put("rows", list);
        return hashMap;
    }

    @Override
    public Boolean updateUser(Integer userid) {
        return treeMapper.updateUser(userid);
    }

    @Override
    public Boolean updateUserhei(Integer userid) {
        return treeMapper.updateUserhei(userid);
    }
}
