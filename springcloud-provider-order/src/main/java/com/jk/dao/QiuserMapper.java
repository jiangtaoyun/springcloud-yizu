package com.jk.dao;

import com.jk.model.Qiuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QiuserMapper {
    int deleteByPrimaryKey(Integer yid);

    int insert(Qiuser record);

    int insertSelective(Qiuser record);

    Qiuser selectByPrimaryKey(Integer yid);

    int updateByPrimaryKeySelective(Qiuser record);

    int updateByPrimaryKey(Qiuser record);

    @Select("select * from t_qiuser")
    List<Qiuser> query();
}