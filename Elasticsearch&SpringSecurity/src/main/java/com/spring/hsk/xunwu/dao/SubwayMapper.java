package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.Subway;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubwayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Subway record);

    int insertSelective(Subway record);

    Subway selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Subway record);

    int updateByPrimaryKey(Subway record);
}