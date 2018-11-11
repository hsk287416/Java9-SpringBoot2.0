package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> selectByUserId(Integer userId);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}