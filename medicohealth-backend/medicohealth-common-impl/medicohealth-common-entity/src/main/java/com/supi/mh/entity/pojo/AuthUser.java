package com.supi.mh.entity.pojo;

import java.io.Serializable;
import java.util.Date;

public class AuthUser implements Serializable {
    private Integer userId;

    private String authUsername;

    private String authPhone;

    private String authPassword;

    private String authSalt;

    private Date authCreatetime;

    private Integer authRoleRoleId;

    private Byte isValidity;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAuthUsername() {
        return authUsername;
    }

    public void setAuthUsername(String authUsername) {
        this.authUsername = authUsername;
    }

    public String getAuthPhone() {
        return authPhone;
    }

    public void setAuthPhone(String authPhone) {
        this.authPhone = authPhone;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public void setAuthPassword(String authPassword) {
        this.authPassword = authPassword;
    }

    public String getAuthSalt() {
        return authSalt;
    }

    public void setAuthSalt(String authSalt) {
        this.authSalt = authSalt;
    }

    public Date getAuthCreatetime() {
        return authCreatetime;
    }

    public void setAuthCreatetime(Date authCreatetime) {
        this.authCreatetime = authCreatetime;
    }

    public Integer getAuthRoleRoleId() {
        return authRoleRoleId;
    }

    public void setAuthRoleRoleId(Integer authRoleRoleId) {
        this.authRoleRoleId = authRoleRoleId;
    }

    public Byte getIsValidity() {
        return isValidity;
    }

    public void setIsValidity(Byte isValidity) {
        this.isValidity = isValidity;
    }
}