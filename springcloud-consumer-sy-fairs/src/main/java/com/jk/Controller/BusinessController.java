package com.jk.Controller;

import com.jk.model.*;
import com.jk.service.BusinServiceAPIZcy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/15 10:45
 * @Description:
 */
@Controller
@RequestMapping("buscon")
public class BusinessController {

    @Autowired
    private BusinServiceAPIZcy businServiceAPIZcy;

    @Autowired
    private RedisTemplate redisTemplate;

    @CrossOrigin
    @RequestMapping("queryBusinessbyid")
    @ResponseBody
    public CompanyBean queryBusinessbyid(Integer id){

        return  businServiceAPIZcy.queryBusinessbyid(id);
    }
    @CrossOrigin
    @RequestMapping("queryworkcountbyid")
    @ResponseBody
    public Integer queryworkcountbyid(Integer id){
        return  businServiceAPIZcy.queryworkcountbyid(id);
    }
    @CrossOrigin
    @RequestMapping("queryopnings")
    @ResponseBody
    public List<WorkBeanZcy> queryopnings(Integer id){
        return  businServiceAPIZcy.queryopnings(id);
    }
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 17:39 2019/7/17
   * @param: id
   * @return: java.util.List<com.jk.model.WorkBeanZcy>
   * @Version: 1.0
   */
    @CrossOrigin
    @RequestMapping("queryjianli")
    @ResponseBody
    public List<JianlibeanZcy> queryjianli(){


       Object user =redisTemplate.opsForValue().get("user_login");

       UserModel user1;
       user1=(UserModel) user;
        Integer userid = Integer.valueOf(user1.getUserid());
        System.out.println("用户ID"+userid);

        return  businServiceAPIZcy.queryjianli(userid);
    }
    @CrossOrigin
    @RequestMapping("queryjianli2")
    @ResponseBody
    public List<JianlibeanZcy> queryjianli2(){


       Object user =redisTemplate.opsForValue().get("user_login");

       UserModel user1;
        user1=(UserModel) user;
        Integer userid = Integer.valueOf(user1.getUserid());
        System.out.println("用户ID"+userid);
        return  businServiceAPIZcy.queryjianli2(userid);
    }
    @CrossOrigin
    @RequestMapping("findjianlixiangqing")
    @ResponseBody
    public JianlibeanZcy findjianlixiangqing(Integer id){

        System.out.println("id = [" + id + "]");
        return  businServiceAPIZcy.findjianlixiangqing(id);
    }
    @CrossOrigin
    @RequestMapping("saveshenqing")
    @ResponseBody
    public Boolean saveshenqing(UserWorkBean bean){
        try {
            Object user =redisTemplate.opsForValue().get("user_login");
            UserModel user1;
            user1=(UserModel) user;
            Integer userid = Integer.valueOf(user1.getUserid());
            UserWorkBean  ifyou   = businServiceAPIZcy.queryuserwork(userid,bean.getJid(),bean.getZid());
            if(ifyou==null){
                bean.setUid(userid);
                bean.setUstatus(1);
                businServiceAPIZcy.saveshenqing(bean);
            }else{
                businServiceAPIZcy.updateuserwork(ifyou.getUzid());
            }
            return true;
        }catch (Exception e){
         e.printStackTrace();
         return  false;
        }
    }


}
