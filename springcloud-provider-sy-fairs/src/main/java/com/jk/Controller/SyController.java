package com.jk.Controller;

import com.jk.Service.SyService;
import com.jk.model.ImgBean;
import com.jk.model.SyCountBeanZcy;
import com.jk.service.Sy.SyServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 21:18
 * @Description:
 */
@Controller
@RequestMapping("sycon")
public class SyController implements SyServiceApi {

    @Autowired
    private SyService syService;

    /**
       * @Author: Mr.Zhang
       * @Description:
       * @Date: 21:19 2019/7/9
       * @param: null
       * @return:
       * @Version: 1.0
       */
    @RequestMapping("queryImg")
    @ResponseBody
    public List<ImgBean> queryImg(){

        return syService.queryImg();
    }
    /* *
       * @Author: Mr.Zhang
       * @Description:
       * @Date: 11:10 2019/7/10
       * @param: null
       * @return:
       * @Version: 1.0
       */
    @RequestMapping("querysycount")
    @ResponseBody
    public SyCountBeanZcy querysycount(){

        return syService.querysycount();
    }
}
