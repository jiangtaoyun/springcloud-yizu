package com.jk.controller;

import com.jk.model.TreeBean;
import com.jk.rmi.TreeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TreeController {

    @Autowired
    private TreeClient treeClient;

    @RequestMapping("queryTree")
    public List<TreeBean> queryTree(){
        return treeClient.queryTree();
    }


    @RequestMapping("queryGangwei")
    public HashMap<String,Object> queryGangwei(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){

        return treeClient.queryGangwei(page,rows);
    }

    @RequestMapping("queryCompany")
    public HashMap<String,Object> queryCompany(@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "rows",required = false) Integer rows){

        return treeClient.queryCompany(page,rows);
    }

    @RequestMapping("updateUqiyeser")
    public Boolean updateUqiyeser(@RequestParam("qid") Integer qid){

        try {

            return treeClient.updateUqiyeser(qid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("updateUqiye")
    public Boolean updateUqiye(@RequestParam("qid") Integer qid){

        try {

            return treeClient.updateUqiye(qid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("queryYongHu")
    public HashMap<String,Object>  queryYongHu(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){

        return treeClient.queryYongHu(page,rows);
    }

    @RequestMapping("updateUser")
    public Boolean updateUser(@RequestParam("userid") Integer userid){
        try {
            return treeClient.updateUser(userid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("updateUserhei")
    public Boolean updateUserhei(@RequestParam("userid") Integer userid){

        try {

            return treeClient.updateUserhei(userid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }


}
