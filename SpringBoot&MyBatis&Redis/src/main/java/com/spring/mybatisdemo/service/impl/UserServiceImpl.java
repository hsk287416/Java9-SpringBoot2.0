package com.spring.mybatisdemo.service.impl;

import com.spring.mybatisdemo.dao.UserMapper;
import com.spring.mybatisdemo.pojo.User;
import com.spring.mybatisdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
@CachePut: 表示将方法结果返回存放到缓存中
@Cacheable: 表示先从缓存中通过定义的键查询，如果可以查询到数据，则返回；
    否则执行该方法，返回数据，并将返回的结果保存到缓存中
@CacheEvict: 通过定义的键移除缓存，他有一个boolean类型的配置项beforeInvocation，表示
    在方法之前或者之后移除缓存。默认值为false，在方法之后移除缓存
 */

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 插入用户，最后获取结果id缓存用户
     * condition: 如果结果为null则不缓存
     * @param user
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisCache", condition = "#result != 'null'", key = "'redis_user_' + #result.id")
    public User insertUser(User user) {
        int result = userMapper.insert(user);
        if (result == 1) {
            return user;
        } else {
            return null;
        }
    }

    /**
     * 通过用户id，获取缓存中的User
     * @param id
     * @return
     */
    @Override
    @Transactional
    @Cacheable(value = "redisCache", key = "'redis_user_' + #id")
    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 更新用户，并且更新缓存
     * 如果condition配置项判断为true的话，则不缓存
     * @param id
     * @param name
     * @return
     */
    @Override
    @Transactional
    @CachePut(value = "redisCache", condition = "result != 'null'", key = "'redis_user_' + #id")
    public User updateUserName(int id, String name) {
        User user = this.getUser(id);
        if (user == null) {
            return null;
        }
        user.setUserName(name);

        int result = userMapper.updateByPrimaryKey(user);
        return result == 1 ? user : null;
    }

    /**
     * 命中率低，所以不采用缓存机制
     * @param name
     * @param note
     * @return
     */
    @Override
    @Transactional
    public List<User> findUsers(String name, String note) {
        return userMapper.findUsers(name, note);
    }

    /**
     * 移除缓存
     * @param id
     * @return
     */
    @Override
    @Transactional
    @CacheEvict(value = "redisCache", key = "'redis_user' + #id", beforeInvocation = false)
    public int deleteUser(int id) {
        return userMapper.deleteByPrimaryKey(id);
    }

}
