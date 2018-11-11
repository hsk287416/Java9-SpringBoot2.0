package com.spring.hsk.xunwu.pojo;

public class Role {
    private Integer id;

    private Integer userId;

    private String name;

    public Role(Integer id, Integer userId, String name) {
        this.id = id;
        this.userId = userId;
        this.name = name;
    }

    public Role() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}