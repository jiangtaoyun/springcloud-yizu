package com.jk.Controller;

import com.jk.Service.BusinService;
import com.jk.model.CompanyBean;
import com.jk.model.JianlibeanZcy;
import com.jk.model.UserWorkBean;
import com.jk.model.WorkBeanZcy;
import com.jk.service.BusinServiceAPIZcy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/15 10:52
 * @Description:
 */
@Controller
@RequestMapping("buscon")
public class BusinController implements BusinServiceAPIZcy {
    @Autowired
    private BusinService businService;

    @RequestMapping("queryBusinessbyid")
    @ResponseBody
    @Override
    public CompanyBean queryBusinessbyid(@RequestParam("id") Integer id) {
        return businService.queryBusinessbyid(id);
    }
    @RequestMapping("queryworkcountbyid")
    @ResponseBody
    @Override
    public Integer queryworkcountbyid(@RequestParam("id") Integer id) {
        return businService.queryworkcountbyid(id);
    }
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 9:40 2019/7/16
   * @param: 
   * @return: java.util.List<com.jk.model.WorkBeanZcy>
   * @Version: 1.0
   */
    @RequestMapping("queryopnings")
    @ResponseBody
    @Override
    public List<WorkBeanZcy> queryopnings(@RequestParam("id") Integer id) {
        return businService.queryopnings(id);
    }
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 19:01 2019/7/17
   * @param: userid
   * @return: java.util.List<com.jk.model.JianlibeanZcy>
   * @Version: 1.0
   */
    @RequestMapping("queryjianli")
    @ResponseBody
    @Override
    public List<JianlibeanZcy> queryjianli(@RequestParam("userid") Integer userid) {
        System.out.println("userid = [" + userid + "]");
        return businService.queryjianli(userid);
    }
    @RequestMapping("queryjianli2")
    @ResponseBody
    @Override
    public List<JianlibeanZcy> queryjianli2(@RequestParam("userid") Integer userid) {
        System.out.println("userid = [" + userid + "]");
        return businService.queryjianli2(userid);
    }
    @RequestMapping("findjianlixiangqing")
    @ResponseBody
    @Override
    public JianlibeanZcy findjianlixiangqing(@RequestParam("id") Integer id) {
        return businService.findjianlixiangqing(id);
    }
    @RequestMapping("saveshenqing")
    @ResponseBody
    @Override
    public void saveshenqing(@RequestBody UserWorkBean bean) {
        businService.saveshenqing(bean);
    }
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 19:12 2019/7/18
   * @param: userid
 * @param: jid
   * @return: com.jk.model.UserWorkBean
   * @Version: 1.0
   */
@RequestMapping("queryuserwork")
@ResponseBody
    @Override
    public UserWorkBean queryuserwork(@RequestParam("userid") Integer userid,@RequestParam("jianliid") Integer jid,@RequestParam("zid") Integer zid) {
        return businService.queryuserwork(userid,jid,zid);
    }
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 19:23 2019/7/18
   * @param: uzid
   * @return: void
   * @Version: 1.0
   */
@RequestMapping("updateuserwork")
@ResponseBody
    @Override
    public void updateuserwork(@RequestParam("uzid") Integer uzid) {
        businService.updateuserwork(uzid);
    }
}
