package com.example.dao;

import java.sql.Timestamp;

public interface AdminManagerDao {

    void addVisitorLog(String remoteAddr, String country, String province, String city, Timestamp timestamp, String browserType, String platformType, String requestURL);

}
