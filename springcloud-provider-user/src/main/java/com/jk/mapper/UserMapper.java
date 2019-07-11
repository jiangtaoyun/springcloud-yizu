package com.jk.mapper;

import com.jk.model.AreaModel;
import com.jk.model.GongzuoModel;
import com.jk.model.UserModel;
import com.jk.model.ZyeleibieModel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    //测试
    @Select("select * from t_user")
    List<UserModel> findmysql();
    //注册
    @Insert("insert into t_user(usercode,userphone,password) values (#{usercode},#{userphone},#{password})")
    void findreg(UserModel userModel);
    //地区
    @Select("select * from t_area where PCODE=-1")
    List<AreaModel> findarea();
    //工作
    @Select("select * from t_type")
    List<GongzuoModel> findgongzuo();
    //专业类别
    @Select("select * from t_major")
    List<ZyeleibieModel> findzyeleibie();
}
