package com.supi.mh.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MonitorHeightWeight implements Serializable {
    private Integer heightWeightId;

    private Float height;

    private Float weight;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date heightWeightCreateTime;

    private Integer userElderElderId;

    public Integer getHeightWeightId() {
        return heightWeightId;
    }

    public void setHeightWeightId(Integer heightWeightId) {
        this.heightWeightId = heightWeightId;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Date getHeightWeightCreateTime() {
        return heightWeightCreateTime;
    }

    public void setHeightWeightCreateTime(Date heightWeightCreateTime) {
        this.heightWeightCreateTime = heightWeightCreateTime;
    }

    public Integer getUserElderElderId() {
        return userElderElderId;
    }

    public void setUserElderElderId(Integer userElderElderId) {
        this.userElderElderId = userElderElderId;
    }
}