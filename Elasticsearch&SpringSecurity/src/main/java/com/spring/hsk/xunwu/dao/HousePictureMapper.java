package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.pojo.HousePicture;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HousePictureMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HousePicture record);

    int insertSelective(HousePicture record);

    HousePicture selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HousePicture record);

    int updateByPrimaryKey(HousePicture record);
}