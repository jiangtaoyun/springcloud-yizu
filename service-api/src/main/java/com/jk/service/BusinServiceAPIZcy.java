package com.jk.service;

import com.jk.model.CompanyBean;
import com.jk.model.JianlibeanZcy;
import com.jk.model.UserWorkBean;
import com.jk.model.WorkBeanZcy;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/15 10:48
 * @Description:
 */
public interface BusinServiceAPIZcy {

    @RequestMapping("/buscon/queryBusinessbyid")
    CompanyBean queryBusinessbyid(@RequestParam("id") Integer id);
    @RequestMapping("/buscon/queryworkcountbyid")
    Integer queryworkcountbyid(@RequestParam("id") Integer id);
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 9:39 2019/7/16
   * @param:
   * @return: java.util.List<com.jk.model.WorkBeanZcy>
   * @Version: 1.0
   */
    @RequestMapping("/buscon/queryopnings")
    List<WorkBeanZcy> queryopnings(@RequestParam("id") Integer id);
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 19:00 2019/7/17
   * @param: userid
   * @return: java.util.List<com.jk.model.JianlibeanZcy>
   * @Version: 1.0
   */
@RequestMapping("/buscon/queryjianli")
    List<JianlibeanZcy> queryjianli(@RequestParam("userid")Integer userid);

    @RequestMapping("/buscon/queryjianli2")
    List<JianlibeanZcy> queryjianli2(@RequestParam("userid") Integer userid);
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 21:16 2019/7/17
   * @param: id
   * @return: com.jk.model.JianlibeanZcy
   * @Version: 1.0
   */
@RequestMapping("/buscon/findjianlixiangqing")
    JianlibeanZcy findjianlixiangqing(@RequestParam("id") Integer id);

/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 11:35 2019/7/18
   * @param: bean
   * @return: void
   * @Version: 1.0
   */
@RequestMapping("/buscon/saveshenqing")
    void saveshenqing(@RequestBody UserWorkBean bean);

/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 19:19 2019/7/18
   * @param: uzid
   * @return: void
   * @Version: 1.0
   */
@RequestMapping("/buscon/updateuserwork")
    void updateuserwork(@RequestParam("uzid") Integer uzid);
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 19:46 2019/7/18
   * @param: userid
 * @param: jid
 * @param: zid
   * @return: com.jk.model.UserWorkBean
   * @Version: 1.0
   */
@RequestMapping("/buscon/queryuserwork")
    UserWorkBean queryuserwork(@RequestParam("userid") Integer userid,@RequestParam("jianliid") Integer jid,@RequestParam("zid") Integer zid);
}
