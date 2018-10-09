package com.spring.mybatisdemo;

import com.spring.mybatisdemo.dao.EmployeeMapper;
import com.spring.mybatisdemo.pojo.Employee;
import com.spring.mybatisdemo.service.TransTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadLocalRandom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private TransTestService transTestService;

    @Test
    public void insertAll() {
        Employee employee = null;
        for (int i = 4; i < 100; i++) {
            int age = ThreadLocalRandom.current().nextInt(10, 100);
            employee = new Employee(i, age, "测试用名字" + i);
            employeeMapper.insert(employee);
        }
    }

    @Test
    public void selectOne(){
        Employee employee = employeeMapper.selectByPrimaryKey(50);
        System.out.println(employee);
    }

    @Test
    public void testTran(){
        transTestService.insertStudentAndEmployee();
    }

}
