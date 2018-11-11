package com.spring.hsk.xunwu.pojo;

import java.util.Date;

public class HouseSubscribe {
    private Integer id;

    private Integer houseId;

    private Integer userId;

    private String desc;

    private Integer status;

    private Date createTime;

    private Date lastUpdateTime;

    private Date orderTime;

    private String telephone;

    private Integer adminId;

    public HouseSubscribe(Integer id, Integer houseId, Integer userId, String desc, Integer status, Date createTime, Date lastUpdateTime, Date orderTime, String telephone, Integer adminId) {
        this.id = id;
        this.houseId = houseId;
        this.userId = userId;
        this.desc = desc;
        this.status = status;
        this.createTime = createTime;
        this.lastUpdateTime = lastUpdateTime;
        this.orderTime = orderTime;
        this.telephone = telephone;
        this.adminId = adminId;
    }

    public HouseSubscribe() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}