package com.jk.Service;

import com.jk.model.*;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 21:20
 * @Description:
 */
public interface SyService {
    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 21:20 2019/7/9
     * @param:
     * @return: java.util.List<com.jk.model.ImgBean>
     * @Version: 1.0
     */
    List<ImgBean> queryImg();

    /* *
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 11:13 2019/7/10
     * @param:
     * @return: com.jk.model.SyCountBeanZcy
     * @Version: 1.0
     */
    List<SyLineCountBeanZcy> querysycount();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 17:45 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.CompanyBean>
     * @Version: 1.0
     */
    List<CompanyBean> querysyqiye();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 21:59 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.SyImgBeanZcy>
     * @Version: 1.0
     */
    List<SyImgBeanZcy> querysyimg();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 22:58 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.TitleBeanZcy>
     * @Version: 1.0
     */
    List<TitleBeanZcy> queryTitle();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 15:24 2019/7/11
     * @param:
     * @return: java.util.List<com.jk.model.TiaoBanModelZcy>
     * @Version: 1.0
     */
    List<TiaoBanModelZcy> querytiaoban();
}
