package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.HouseSubscribe;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HouseSubscribeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HouseSubscribe record);

    int insertSelective(HouseSubscribe record);

    HouseSubscribe selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HouseSubscribe record);

    int updateByPrimaryKey(HouseSubscribe record);
}