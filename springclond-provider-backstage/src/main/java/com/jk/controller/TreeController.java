package com.jk.controller;

import com.jk.model.Company;
import com.jk.model.TreeBean;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("queryTree")
    public List<TreeBean> queryTree(){
        return treeService.queryTree();
    }

    @RequestMapping("queryGangwei")
    public HashMap<String,Object> queryGangwei(@RequestParam("page") Integer page,@RequestParam("rows") Integer rows){

        return treeService.queryGangwei(page,rows);
    }

    @RequestMapping("queryCompany")
    public HashMap<String,Object> queryCompany(@RequestParam(value = "page",required = false) Integer page,@RequestParam(value = "rows",required = false) Integer rows){

        return treeService.queryCompany(page,rows);
    }

    @RequestMapping("updateUqiyeser")
    public Boolean updateUqiyeser(@RequestParam("qid") Integer qid){

        try {

            return treeService.updateUqiyeser(qid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("updateUqiye")
    public Boolean updateUqiye(@RequestParam("qid") Integer qid){

        try {

            return treeService.updateUqiye(qid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping("queryYongHu")
    public HashMap<String,Object>  queryYongHu(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows){

        return treeService.queryYongHu(page,rows);
    }

    @RequestMapping("updateUser")
    public Boolean updateUser(@RequestParam("userid") Integer userid){
        try {
            return treeService.updateUser(userid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
    @RequestMapping("updateUserhei")
    public Boolean updateUserhei(@RequestParam("userid") Integer userid){
        try {
            return treeService.updateUserhei(userid);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
