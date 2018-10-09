package com.spring.mybatisdemo.pojo;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class User implements Serializable {

    private static final long serialVersionUID = 2107014912076216233L;

    private Integer id;

    private String userName;

    private String note;

    public User(Integer id, String userName, String note) {
        this.id = id;
        this.userName = userName;
        this.note = note;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}