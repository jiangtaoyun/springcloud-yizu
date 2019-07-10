package com.jk.Mapper;

import com.jk.model.ImgBean;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/9 21:22
 * @Description:
 */
public interface SyMapper {
   /* *
      * @Author: Mr.Zhang
      * @Description:
      * @Date: 21:24 2019/7/9
      * @param: 
      * @return: java.util.List<com.jk.model.ImgBean>
      * @Version: 1.0
      */
    @Select(" select * from t_img")
    List<ImgBean> queryImg();
/* *
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 11:13 2019/7/10
   * @param:
   * @return: java.lang.Integer
   * @Version: 1.0
   */
@Select("select count(1) from t_work")
    Integer queryziwei();
/* *
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 11:13 2019/7/10
   * @param:
   * @return: java.lang.Integer
   * @Version: 1.0
   */
@Select("select count(1) from t_company")
    Integer queryqiyecount();
/* *
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 11:13 2019/7/10
   * @param:
   * @return: java.lang.Integer
   * @Version: 1.0
   */
@Select(" select count(1) from t_user")
    Integer queryrencaicount();
}
