package com.supi.mh.entity.pojo;

import java.io.Serializable;
import java.util.Date;

public class Warning implements Serializable {
    private Integer idwarning;

    private String type;

    private Date time;

    private Byte state;

    private Integer elderId;

    private String comment;

    private String content;

    public Integer getIdwarning() {
        return idwarning;
    }

    public void setIdwarning(Integer idwarning) {
        this.idwarning = idwarning;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getElderId() {
        return elderId;
    }

    public void setElderId(Integer elderId) {
        this.elderId = elderId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}