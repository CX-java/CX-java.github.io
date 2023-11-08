package com.cx.atm.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private int uid;
    private String username;
    private String password;
    private LocalDateTime created;

    public int getUid() {
        return uid;
    }

    public void setUid( int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}