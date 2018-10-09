package com.spring.mybatisdemo.service;

import com.spring.mybatisdemo.pojo.User;

import java.util.List;

public interface IUserService {
    User insertUser(User user);

    User getUser(int id);

    User updateUserName(int id, String name);

    List<User> findUsers(String name, String note);

    int deleteUser(int id);
}
