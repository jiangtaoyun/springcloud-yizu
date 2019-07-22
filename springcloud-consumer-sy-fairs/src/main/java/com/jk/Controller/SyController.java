package com.jk.Controller;

import com.jk.model.*;
import com.jk.service.Sy.SyServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 20:55
 * @Description:
 */
@Controller
@RequestMapping("Sycon")
public class SyController {

    @Autowired
    private SyServiceApi syService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("queryImg")
    @ResponseBody
    public List<ImgBean> queryImg() {
        List<ImgBean> list = syService.queryImg();
        return list;
    }

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 11:09 2019/7/10
     * @param: null
     * @return:
     * @Version: 1.0
     */
    @CrossOrigin
    @RequestMapping("querysycount")
    @ResponseBody
    public List<SyLineCountBeanZcy> querysycount() {

        return syService.querysycount();
    }

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 17:44 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.CompanyBean>
     * @Version: 1.0
     */
    @CrossOrigin
    @RequestMapping("querysyqiye")
    @ResponseBody
    public List<CompanyBean> querysyqiye() {
        return syService.querysyqiye();
    }

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 21:54 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.CompanyBean>
     * @Version: 1.0
     */
    @CrossOrigin
    @RequestMapping("querysyimg")
    @ResponseBody
    public List<SyImgBeanZcy> querysyimg() {
        return syService.querysyimg();
    }

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 22:57 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.TitleBeanZcy>
     * @Version: 1.0
     */
    @CrossOrigin
    @RequestMapping("queryTitle")
    @ResponseBody
    public List<TitleBeanZcy> queryTitle() {
        return syService.queryTitle();
    }

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 14:17 2019/7/11
     * @param:
     * @return: java.util.List
     * @Version: 1.0
     */
    @CrossOrigin
    @RequestMapping("querytiaoban")
    @ResponseBody
    public List<TiaoBanModelZcy> querytiaoban() {
        return syService.querytiaoban();
    }
/**
   * @Author: Mr.Zhang
   * @Description: 获取登录用户信息
   * @Date: 9:34 2019/7/19
   * @param:
   * @return: com.jk.model.UserModel
   * @Version: 1.0
   */
    @CrossOrigin
    @RequestMapping("queryuser")
    @ResponseBody
    public UserModel queryuser() {
        Object user =redisTemplate.opsForValue().get("user_login");
        UserModel user1;
        user1=(UserModel) user;
        return user1;
    }

}
