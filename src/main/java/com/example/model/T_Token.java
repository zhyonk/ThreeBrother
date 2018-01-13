package com.example.model;


import java.sql.Timestamp;

public class T_Token {
    private int id;
    private String access_token;
    private int expries_in;
    private Timestamp createTime;

    public int getId() {
        return id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public int getExpries_in() {
        return expries_in;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setId(int id) {
        this.id = id;
    }
}
