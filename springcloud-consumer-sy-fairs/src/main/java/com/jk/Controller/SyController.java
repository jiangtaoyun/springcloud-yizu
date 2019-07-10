package com.jk.Controller;

import com.jk.model.ImgBean;
import com.jk.model.SyCountBeanZcy;
import com.jk.service.Sy.SyServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping("queryImg")
    @ResponseBody
    public List<ImgBean> queryImg(){
        List<ImgBean> list=  syService.queryImg();
        return list;
    }
    /* *
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
    public SyCountBeanZcy querysycount(){

        return syService.querysycount();
    }
}
