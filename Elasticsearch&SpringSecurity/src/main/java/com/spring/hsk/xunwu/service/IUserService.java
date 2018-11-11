package com.spring.hsk.xunwu.service;

import com.spring.hsk.xunwu.pojo.User;

public interface IUserService {
    User findUserByName(String userName);
}
