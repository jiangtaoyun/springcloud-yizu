package com.jk.mapper;

import com.jk.model.Qiuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author:slm
 * @Date：
 **/
@Mapper
public interface UserMapper {
   @Select("select * from t_qiuser")
    List<Qiuser> findmysql();
}
