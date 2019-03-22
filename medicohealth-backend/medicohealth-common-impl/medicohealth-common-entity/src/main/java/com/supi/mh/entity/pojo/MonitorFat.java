package com.supi.mh.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MonitorFat implements Serializable {
    private Integer fatId;

    private Float fatValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date fatCreateTime;

    private Integer fatMetabolicRate;

    private Float fatMoistureContent;

    private Integer userElderElderId;

    public Integer getFatId() {
        return fatId;
    }

    public void setFatId(Integer fatId) {
        this.fatId = fatId;
    }

    public Float getFatValue() {
        return fatValue;
    }

    public void setFatValue(Float fatValue) {
        this.fatValue = fatValue;
    }

    public Date getFatCreateTime() {
        return fatCreateTime;
    }

    public void setFatCreateTime(Date fatCreateTime) {
        this.fatCreateTime = fatCreateTime;
    }

    public Integer getFatMetabolicRate() {
        return fatMetabolicRate;
    }

    public void setFatMetabolicRate(Integer fatMetabolicRate) {
        this.fatMetabolicRate = fatMetabolicRate;
    }

    public Float getFatMoistureContent() {
        return fatMoistureContent;
    }

    public void setFatMoistureContent(Float fatMoistureContent) {
        this.fatMoistureContent = fatMoistureContent;
    }

    public Integer getUserElderElderId() {
        return userElderElderId;
    }

    public void setUserElderElderId(Integer userElderElderId) {
        this.userElderElderId = userElderElderId;
    }
}