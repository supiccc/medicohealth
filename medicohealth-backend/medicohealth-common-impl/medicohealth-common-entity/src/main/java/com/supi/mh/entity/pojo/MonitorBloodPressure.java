package com.supi.mh.entity.pojo;

import java.io.Serializable;
import java.util.Date;

public class MonitorBloodPressure implements Serializable {
    private Integer bloodPressureId;

    private Float diastolic;

    private Float shrink;

    private Byte pulse;

    private Date bloodPressureCreateTime;

    private Integer elderId;

    public Integer getBloodPressureId() {
        return bloodPressureId;
    }

    public void setBloodPressureId(Integer bloodPressureId) {
        this.bloodPressureId = bloodPressureId;
    }

    public Float getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(Float diastolic) {
        this.diastolic = diastolic;
    }

    public Float getShrink() {
        return shrink;
    }

    public void setShrink(Float shrink) {
        this.shrink = shrink;
    }

    public Byte getPulse() {
        return pulse;
    }

    public void setPulse(Byte pulse) {
        this.pulse = pulse;
    }

    public Date getBloodPressureCreateTime() {
        return bloodPressureCreateTime;
    }

    public void setBloodPressureCreateTime(Date bloodPressureCreateTime) {
        this.bloodPressureCreateTime = bloodPressureCreateTime;
    }

    public Integer getElderId() {
        return elderId;
    }

    public void setElderId(Integer elderId) {
        this.elderId = elderId;
    }
}