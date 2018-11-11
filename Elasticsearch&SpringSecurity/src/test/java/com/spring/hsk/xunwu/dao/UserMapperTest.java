package com.spring.hsk.xunwu.dao;

import com.spring.hsk.xunwu.ApplicationTests;
import com.spring.hsk.xunwu.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class UserMapperTest extends ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectOne(){
        User user = userMapper.selectByPrimaryKey(1);
        Assert.isTrue("hushukang".equals(user.getName()), "查询结果错误！");
    }
}