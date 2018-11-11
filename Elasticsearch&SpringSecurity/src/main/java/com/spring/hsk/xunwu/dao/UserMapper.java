package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectByName(String userName);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}