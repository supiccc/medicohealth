package com.supi.mh.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MonitorBloodOxygen implements Serializable {
    private Integer bloodOxygenId;

    private Float bloodOxygenValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date bloodOxygenCreateTime;

    private Integer userElderElderId;

    public Integer getBloodOxygenId() {
        return bloodOxygenId;
    }

    public void setBloodOxygenId(Integer bloodOxygenId) {
        this.bloodOxygenId = bloodOxygenId;
    }

    public Float getBloodOxygenValue() {
        return bloodOxygenValue;
    }

    public void setBloodOxygenValue(Float bloodOxygenValue) {
        this.bloodOxygenValue = bloodOxygenValue;
    }

    public Date getBloodOxygenCreateTime() {
        return bloodOxygenCreateTime;
    }

    public void setBloodOxygenCreateTime(Date bloodOxygenCreateTime) {
        this.bloodOxygenCreateTime = bloodOxygenCreateTime;
    }

    public Integer getUserElderElderId() {
        return userElderElderId;
    }

    public void setUserElderElderId(Integer userElderElderId) {
        this.userElderElderId = userElderElderId;
    }
}