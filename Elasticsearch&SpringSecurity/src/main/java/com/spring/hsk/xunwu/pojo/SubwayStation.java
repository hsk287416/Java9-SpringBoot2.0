package com.spring.hsk.xunwu.pojo;

public class SubwayStation {
    private Integer id;

    private Integer subwayId;

    private String name;

    public SubwayStation(Integer id, Integer subwayId, String name) {
        this.id = id;
        this.subwayId = subwayId;
        this.name = name;
    }

    public SubwayStation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubwayId() {
        return subwayId;
    }

    public void setSubwayId(Integer subwayId) {
        this.subwayId = subwayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}