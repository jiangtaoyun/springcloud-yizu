package com.jk.Controller;

import com.jk.Service.SyService;
import com.jk.model.*;
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
    public List<ImgBean> queryImg() {

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
    public List<SyLineCountBeanZcy> querysycount() {

        return syService.querysycount();
    }

    @RequestMapping("querysyqiye")
    @ResponseBody
    @Override
    public List<CompanyBean> querysyqiye() {
        return syService.querysyqiye();
    }

    @RequestMapping("querysyimg")
    @ResponseBody
    @Override
    public List<SyImgBeanZcy> querysyimg() {
        return syService.querysyimg();
    }

    /* *
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 22:58 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.TitleBeanZcy>
     * @Version: 1.0
     */
    @RequestMapping("queryTitle")
    @ResponseBody
    @Override
    public List<TitleBeanZcy> queryTitle() {
        return syService.queryTitle();
    }

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 15:24 2019/7/11
     * @param:
     * @return: java.util.List<com.jk.model.TiaoBanModelZcy>
     * @Version: 1.0
     */
    @RequestMapping("querytiaoban")
    @ResponseBody
    @Override
    public List<TiaoBanModelZcy> querytiaoban() {
        return syService.querytiaoban();
    }
}
