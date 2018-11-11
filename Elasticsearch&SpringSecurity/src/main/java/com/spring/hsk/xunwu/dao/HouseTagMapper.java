package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.HouseTag;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseTagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseTag record);

    int insertSelective(HouseTag record);

    HouseTag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseTag record);

    int updateByPrimaryKey(HouseTag record);
}