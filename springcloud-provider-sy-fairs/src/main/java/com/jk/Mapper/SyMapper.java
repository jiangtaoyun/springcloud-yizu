package com.jk.Mapper;

import com.jk.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 17:45 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.CompanyBean>
     * @Version: 1.0
     */
    @Select(" select * from t_company")
    List<CompanyBean> querysyqiye();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 21:59 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.SyImgBeanZcy>
     * @Version: 1.0
     */
    @Select(" select * from t_img group by gtime desc")
    List<SyImgBeanZcy> querysyimg();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 22:58 2019/7/10
     * @param:
     * @return: java.util.List<com.jk.model.TitleBeanZcy>
     * @Version: 1.0
     */
    @Select(" select * from t_sytitle ")
    List<TitleBeanZcy> queryTitle();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 15:25 2019/7/11
     * @param:
     * @return: java.util.List<com.jk.model.TiaoBanModelZcy>
     * @Version: 1.0
     */
    @Select(" select tw.*,tc.*,tt.* from t_work tw  left JOIN  \tt_company tc on tc.qId=tw.compId  \n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t  left JOIN  t_type tt on tw.typeId=tt.tid\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\twhere tw.qTotpe=1\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\t")
    List<TiaoBanModelZcy> querytiaoban();

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 14:37 2019/7/12
     * @param: id
     * @param: linename
     * @return: void
     * @Version: 1.0
     */
    @Update("  update t_linecount a set a.linecount=#{lincount},a.refreshtime=now() where id=#{id}")
    void updatelinecount(@Param("id") Integer id, @Param("lincount") Integer lincount);

    /**
     * @Author: Mr.Zhang
     * @Description:
     * @Date: 14:46 2019/7/12
     * @param:
     * @return: java.util.List<com.jk.model.SyLineCountBeanZcy>
     * @Version: 1.0
     */
    @Select(" select * from t_linecount")
    List<SyLineCountBeanZcy> querylinecount();
}
