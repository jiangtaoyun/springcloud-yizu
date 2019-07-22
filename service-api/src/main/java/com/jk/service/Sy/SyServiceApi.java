package com.jk.service.Sy;

import com.jk.model.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 20:58
 * @Description:
 */
public interface SyServiceApi {
    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 21:17 2019/7/9
     * @param:
     * @return: java.util.List<com.jk.model.ImgBean>
     * @Version: 1.0
     */
    @RequestMapping("sycon/queryImg")
    List<com.jk.model.ImgBean> queryImg();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 11:10 2019/7/10
     * @param:
     * @return: com.jk.model.SyCountBeanZcy
     * @Version: 1.0
     */
    @RequestMapping("sycon/querysycount")
    List<SyLineCountBeanZcy> querysycount();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 17:44 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.CompanyBean>
     * @Version: 1.0
     */
    @RequestMapping("sycon/querysyqiye")
    List<CompanyBean> querysyqiye();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 21:57 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.SyImgBeanZcy>
     * @Version: 1.0
     */
    @RequestMapping("sycon/querysyimg")
    List<SyImgBeanZcy> querysyimg();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 22:57 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.TitleBeanZcy>
     * @Version: 1.0
     */
    @RequestMapping("sycon/queryTitle")
    List<TitleBeanZcy> queryTitle();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 15:23 2019/7/11
     * @param:
     * @return: java.util.List<com.jk.model.TiaoBanModelZcy>
     * @Version: 1.0
     */
    @RequestMapping("sycon/querytiaoban")
    List<TiaoBanModelZcy> querytiaoban();
}
