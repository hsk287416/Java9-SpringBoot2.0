package com.spring.hsk.xunwu.pojo;

public class Subway {
    private Integer id;

    private String name;

    private String cityEnName;

    public Subway(Integer id, String name, String cityEnName) {
        this.id = id;
        this.name = name;
        this.cityEnName = cityEnName;
    }

    public Subway() {
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

    public String getCityEnName() {
        return cityEnName;
    }

    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName == null ? null : cityEnName.trim();
    }
}