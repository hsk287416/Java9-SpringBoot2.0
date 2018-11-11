package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.HouseDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseDetail record);

    int insertSelective(HouseDetail record);

    HouseDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseDetail record);

    int updateByPrimaryKey(HouseDetail record);
}