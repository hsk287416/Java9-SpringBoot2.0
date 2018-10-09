package com.spring.mybatisdemo.service;

import com.spring.mybatisdemo.dao.EmployeeMapper;
import com.spring.mybatisdemo.dao.StudentMapper;
import com.spring.mybatisdemo.pojo.Employee;
import com.spring.mybatisdemo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TransTestService {
    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public void insertStudentAndEmployee(){
        Student student = new Student(2, "小李", 1);
        Employee employee = new Employee(100, 10, "赵云");
        studentMapper.insert(student);
        employeeMapper.insert(employee);
    }
}
