package com.jk.Service;

import com.jk.model.ImgBean;
import com.jk.model.SyCountBeanZcy;

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
    SyCountBeanZcy querysycount();
}
