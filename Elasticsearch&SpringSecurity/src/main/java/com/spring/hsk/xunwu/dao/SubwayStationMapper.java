package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.SubwayStation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubwayStationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SubwayStation record);

    int insertSelective(SubwayStation record);

    SubwayStation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SubwayStation record);

    int updateByPrimaryKey(SubwayStation record);
}