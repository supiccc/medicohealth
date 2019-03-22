package com.supi.mh.entity.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class MonitorUricAcid implements Serializable {
    private Integer uricAcidId;

    private Float uricAcidValue;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date uricAcidCreateTime;

    private Integer elderId;

    public Integer getUricAcidId() {
        return uricAcidId;
    }

    public void setUricAcidId(Integer uricAcidId) {
        this.uricAcidId = uricAcidId;
    }

    public Float getUricAcidValue() {
        return uricAcidValue;
    }

    public void setUricAcidValue(Float uricAcidValue) {
        this.uricAcidValue = uricAcidValue;
    }

    public Date getUricAcidCreateTime() {
        return uricAcidCreateTime;
    }

    public void setUricAcidCreateTime(Date uricAcidCreateTime) {
        this.uricAcidCreateTime = uricAcidCreateTime;
    }

    public Integer getElderId() {
        return elderId;
    }

    public void setElderId(Integer elderId) {
        this.elderId = elderId;
    }
}