package com.supi.mh.entity.pojo;

/**
 * Created by supiccc on 2019-02-19 15:45
 */
public class AuthProfile {
    private String username;

    private String token;

    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
