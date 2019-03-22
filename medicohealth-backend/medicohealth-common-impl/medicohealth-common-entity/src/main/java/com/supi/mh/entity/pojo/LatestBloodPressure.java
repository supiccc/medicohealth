package com.supi.mh.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by supiccc on 2019-03-16 14:16
 */
public class LatestBloodPressure implements Serializable {
    private Integer bloodPressureId;

    private Float diastolic;

    private Float shrink;

    private Byte pulse;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date bloodPressureCreateTime;

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
}
