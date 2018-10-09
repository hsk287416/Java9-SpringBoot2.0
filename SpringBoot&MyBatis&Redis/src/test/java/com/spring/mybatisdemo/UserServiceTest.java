package com.spring.mybatisdemo;

import com.spring.mybatisdemo.pojo.User;
import com.spring.mybatisdemo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void insertUser(){
        User user = new User(1001, "刘备", "test note 1");
        User result = iUserService.insertUser(user);

        System.out.println(result);
    }

    @Test
    public void selectUser(){
        User user = iUserService.getUser(1001);
        System.out.println(user);
    }
}
