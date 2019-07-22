package com.jk.rmi;

import com.jk.model.TreeBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@FeignClient("springcloud-provider-backstage")
public interface TreeClient {

    @RequestMapping("queryTree")
    List<TreeBean> queryTree();

    @RequestMapping("queryGangwei")
    HashMap<String, Object> queryGangwei(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @RequestMapping("queryCompany")
    HashMap<String, Object> queryCompany(@RequestParam(value = "page",required = false) Integer page, @RequestParam(value = "rows",required = false) Integer rows);

    @RequestMapping("updateUqiyeser")
    Boolean updateUqiyeser(@RequestParam("qid") Integer qid);

    @RequestMapping("updateUqiye")
    Boolean updateUqiye(@RequestParam("qid") Integer qid);

    @RequestMapping("queryYongHu")
    HashMap<String, Object> queryYongHu(@RequestParam("page") Integer page, @RequestParam("rows") Integer rows);

    @RequestMapping("updateUser")
    Boolean updateUser(@RequestParam("userid") Integer userid);
    @RequestMapping("updateUserhei")
    Boolean updateUserhei(@RequestParam("userid") Integer userid);
}
