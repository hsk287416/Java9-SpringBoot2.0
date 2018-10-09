package com.spring.mybatisdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void setValue(){
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name", "胡书康");
        String name = valueOperations.get("name");
        System.out.println(name);
    }

    @Test
    public void setHash(){
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();

        Map<String, String> student1 = new HashMap<>();
        student1.put("name", "小懒羊1");
        student1.put("birthday", "1991/09/24");
        student1.put("hobbies", "睡觉");

        Map<String, String> student2 = new HashMap<>();
        student2.put("name", "小懒羊2");
        student2.put("birthday", "1991/09/24");
        student2.put("hobbies", "吃饭");

        hashOperations.putAll("student:1", student1);
        hashOperations.putAll("student:2", student2);
    }

    @Test
    public void pipeLine(){

        List<Object> result = redisTemplate.executePipelined(new SessionCallback<String>() {
            @Override
            public String execute(RedisOperations redisOperations) throws DataAccessException {
                HashOperations<String, String, String> hashOperations = redisOperations.opsForHash();
                hashOperations.get("student:1", "name");
                hashOperations.get("student:1", "birthday");
                hashOperations.get("student:1", "hobbies");
                return null;
            }
        });

        result.forEach(System.out::println);


    }
}
