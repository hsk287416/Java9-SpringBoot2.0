package com.spring.hsk.xunwu.service.impl;

import com.google.common.collect.Lists;
import com.spring.hsk.xunwu.dao.RoleMapper;
import com.spring.hsk.xunwu.dao.UserMapper;
import com.spring.hsk.xunwu.pojo.Role;
import com.spring.hsk.xunwu.pojo.User;
import com.spring.hsk.xunwu.service.IUserService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User findUserByName(String userName) {
        User user = userMapper.selectByName(userName);

        if (ObjectUtils.NULL.equals(user)) {
            return null;
        }

        List<Role> roleList = roleMapper.selectByUserId(user.getId());
        List<GrantedAuthority> authorityList = roleList.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        user.setAuthorityList(authorityList);

        return user;
    }
}
