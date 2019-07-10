package com.jk.Service.impl;

import com.jk.Mapper.SyMapper;
import com.jk.Service.SyService;
import com.jk.model.ImgBean;
import com.jk.model.SyCountBeanZcy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 21:21
 * @Description:
 */
@Service
public class SyServiceImpl implements SyService {
    @Autowired
    private SyMapper symapper;

    /* *
       * @Author: Mr.Zhang
       * @Description:
       * @Date: 21:21 2019/7/9
       * @param:
       * @return: java.util.List<com.jk.model.ImgBean>
       * @Version: 1.0
       */
    @Override
    public List<ImgBean> queryImg() {
        return symapper.queryImg();
    }
/* *
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 11:12 2019/7/10
   * @param:
   * @return: com.jk.model.SyCountBeanZcy
   * @Version: 1.0
   */
    @Override
    public SyCountBeanZcy querysycount() {
       Integer zhiweicount= symapper.queryziwei();
        Integer zicount = zicount(zhiweicount);
        
        Integer qiyecount= symapper.queryqiyecount();
        Integer zicount1 = zicount(qiyecount);

        Integer rencaicount= symapper.queryrencaicount();
        Integer rencaicount2 = zicount(rencaicount);

        SyCountBeanZcy beanZcy = new SyCountBeanZcy();
        beanZcy.setPositioncount(zicount);
        beanZcy.setEnterprisecount(zicount1);
        beanZcy.setPersonnelcount(rencaicount2);
        return beanZcy;
    }

    public Integer zicount(Integer count){
        Integer a=count*100;
        return a;
    }
}
