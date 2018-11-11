package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.SupportAddress;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupportAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SupportAddress record);

    int insertSelective(SupportAddress record);

    SupportAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SupportAddress record);

    int updateByPrimaryKey(SupportAddress record);
}