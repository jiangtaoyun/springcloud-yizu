package com.jk.mapper;

import com.jk.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    //测试
    @Select("select * from t_user")
    List<UserModel> findmysql();
}
