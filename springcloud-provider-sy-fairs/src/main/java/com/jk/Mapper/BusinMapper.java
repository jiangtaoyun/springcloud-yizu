package com.jk.Mapper;

import com.jk.model.CompanyBean;
import com.jk.model.JianlibeanZcy;
import com.jk.model.UserWorkBean;
import com.jk.model.WorkBeanZcy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Auther: 16654
 * @Date: 2019/7/15 10:54
 * @Description:
 */
public interface BusinMapper {
    @Select("  select t1.*,t4.AREANAME as xian ,t3.AREANAME as shi,t2.AREANAME sheng from t_company t1,t_area t2,t_area t3,t_area t4 where t1.qArea=t4.AREACODEID and t4.PCODE=t3.AREACODEID and t3.PCODE=t2.AREACODEID and t1.qId=#{value}")
    CompanyBean queryBusinessbyid(Integer id);
    @Select(" select count(1) from t_work tw where tw.compId=#{value} and tw.qTotpe=1")
    Integer queryworkcountbyid(Integer id);

    /**
       * @Author: Mr.Zhang
       * @Description:
       * @Date: 9:59 2019/7/16
       * @param:
       * @return: java.util.List<com.jk.model.WorkBeanZcy>
       * @Version: 1.0
       */
    @Select("select  twk.*,tty.tname as zhiweiname,t4.AREANAME as xian ,t3.AREANAME as shi,t2.AREANAME sheng  from t_work twk,t_type tty,t_area t2,t_area t3,t_area t4 where twk.typeId=tty.tid and\n" +
            "twk.work=t4.AREACODEID and t4.PCODE=t3.AREACODEID and t3.PCODE=t2.AREACODEID \n" +
            "and twk.compId=#{value} and twk.qTotpe=1")
    List<WorkBeanZcy> queryopnings(Integer id);
    @Select("SELECT tj.* from t_jianli tj left JOIN  t_user tu\n" +
            "\t\t\t\t\t\t\t\t\t\t\t\t\ton tj.userid=tu.userid where tj.jlstatu=1 and tu.userid=#{value}")
    List<JianlibeanZcy> queryjianli(Integer userid);
    @Select(" SELECT tj.* from t_jianli tj left JOIN  t_user tu on tj.userid=tu.userid where tj.jlstatu=1 and tj.userid=#{userid}")
    List<JianlibeanZcy> queryjianli2(@Param("userid") Integer userid);
    @Select(" select * from t_jianli where jlid=#{value}")
    JianlibeanZcy findjianlixiangqing(Integer id);
    /**
       * @Author: Mr.Zhang
       * @Description:
       * @Date: 11:37 2019/7/18
       * @param: bean
       * @return: void
       * @Version: 1.0
       */
    @Insert(" insert INTO t_user_work (jid,uid,zid,qid,ustatus,shenqtime) values (#{bean.jid},#{bean.uid},#{bean.zid},#{bean.qid},#{bean.ustatus},now()) ")
    void saveshenqing(@Param("bean") UserWorkBean bean);
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 19:14 2019/7/18
   * @param: userid
 * @param: jid
   * @return: com.jk.model.UserWorkBean
   * @Version: 1.0
   */
   @Select(" select * from t_user_work where uid=#{userid} and jid=#{jid} and zid=#{zid}")
    UserWorkBean queryuserwork(@Param("userid")Integer userid,@Param("jid") Integer jid,@Param("zid") Integer zid);
/**
   * @Author: Mr.Zhang
   * @Description:
   * @Date: 19:24 2019/7/18
   * @param: uzid
   * @return: void
   * @Version: 1.0
   */
@Update(" update t_user_work set shenqtime=now() where uzid=#{value}")
    void updateuserwork(Integer uzid);
}
