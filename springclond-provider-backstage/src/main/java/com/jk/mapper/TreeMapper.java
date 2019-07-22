package com.jk.mapper;

import com.jk.model.Company;
import com.jk.model.TreeBean;
import com.jk.model.User;
import com.jk.model.WorkBean;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface TreeMapper {

    @Select("select * from t_tree where pid = #{value}")
    List<TreeBean> findTreeByPid(int pid);

    @Select("select count(*) from t_work w LEFT JOIN t_type t ON w.typeId = t.tid LEFT JOIN t_company c ON w.compId = c.qId left join t_area a on c.qArea = a.AREACODEID")
    int fiotal();

    @Select(" SELECT t.tname,c.qName,c.qArea,a.AREANAME,w.* FROM t_work w LEFT JOIN t_type t ON w.typeId = t.tid\n" +
            "\n" +
            "         LEFT JOIN t_company c ON w.compId = c.qId left join t_area a on c.qArea = a.AREACODEID limit #{start},#{rows}")
    List<WorkBean> findRoadPage(@Param("start") int start, @Param("rows") Integer rows);

    @Select("select count(*) from t_company c ")
    int fiotalCompany();

    @Select(" select c.*,c.stuta from t_company c limit #{start},#{rows}")
    List<Company> findCompanyPage(@Param("start") int start, @Param("rows") Integer rows);

    @Update("update t_company set stuta=2 where qid = #{qid}")
    Boolean updateUqiyeser(Integer qid);

    @Update("update t_company set stuta=1 where qid = #{qid}")
    Boolean updateUqiye(Integer qid);

    @Select("select count(*) from t_user u left join t_gerenxinxi g on u.userid = g.userid ")
    int fiotalUser();
   @Select("select u.*,g.* from t_user u left join t_gerenxinxi g on u.userid = g.userid limit #{start},#{rows}")
    List<User> findUser(@Param("start") int start, @Param("rows") Integer rows);

    @Update("update t_user set statu=2 where userid = #{userid}")
    Boolean updateUser(Integer userid);
    @Update("update t_user set statu=1 where userid = #{userid}")
    Boolean updateUserhei(Integer userid);
}
