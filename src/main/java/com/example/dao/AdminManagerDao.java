package com.example.dao;

import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface AdminManagerDao {

    void addVisitorLog(@Param(value="remoteAddr")String remoteAddr, @Param(value="country")String country, @Param(value="province")String province, @Param(value="city")String city, @Param(value="timestamp")Timestamp timestamp, @Param(value="browserType")String browserType, @Param(value="platformType")String platformType, @Param(value="requestURL")String requestURL);

}
