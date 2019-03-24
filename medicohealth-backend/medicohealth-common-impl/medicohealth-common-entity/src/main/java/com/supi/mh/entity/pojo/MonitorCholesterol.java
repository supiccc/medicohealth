package com.supi.mh.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MonitorCholesterol extends Monitor implements Serializable {
    private Integer cholesterolId;

    private Float cholesterolValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cholesterolCreateTime;

    private Integer elderId;

    public Integer getCholesterolId() {
        return cholesterolId;
    }

    public void setCholesterolId(Integer cholesterolId) {
        this.cholesterolId = cholesterolId;
    }

    public Float getCholesterolValue() {
        return cholesterolValue;
    }

    public void setCholesterolValue(Float cholesterolValue) {
        this.cholesterolValue = cholesterolValue;
    }

    public Date getCholesterolCreateTime() {
        return cholesterolCreateTime;
    }

    public void setCholesterolCreateTime(Date cholesterolCreateTime) {
        this.cholesterolCreateTime = cholesterolCreateTime;
    }

    public Integer getElderId() {
        return elderId;
    }

    public void setElderId(Integer elderId) {
        this.elderId = elderId;
    }
}