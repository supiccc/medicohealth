package com.supi.mh.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MonitorBloodSugar extends Monitor implements Serializable {
    private Integer bloodSugarId;

    private Float bloodSugarvalue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date bloodSugarCreateTime;

    private Integer userElderElderId;

    public Integer getBloodSugarId() {
        return bloodSugarId;
    }

    public void setBloodSugarId(Integer bloodSugarId) {
        this.bloodSugarId = bloodSugarId;
    }

    public Float getBloodSugarvalue() {
        return bloodSugarvalue;
    }

    public void setBloodSugarvalue(Float bloodSugarvalue) {
        this.bloodSugarvalue = bloodSugarvalue;
    }

    public Date getBloodSugarCreateTime() {
        return bloodSugarCreateTime;
    }

    public void setBloodSugarCreateTime(Date bloodSugarCreateTime) {
        this.bloodSugarCreateTime = bloodSugarCreateTime;
    }

    public Integer getUserElderElderId() {
        return userElderElderId;
    }

    public void setUserElderElderId(Integer userElderElderId) {
        this.userElderElderId = userElderElderId;
    }
}