package com.spring.mybatisdemo.pojo;

import java.util.Date;

public class Student {
    private Integer id;

    private String name;

    private Integer gender;

    private Date createDate;

    private Date updateDate;

    public Student(Integer id, String name, Integer gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    public Student(Integer id, String name, Integer gender, Date createDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}