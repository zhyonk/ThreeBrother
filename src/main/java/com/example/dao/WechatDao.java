package com.example.dao;

import com.example.model.T_Token;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;

public interface WechatDao {
    T_Token selectToken();

    int saveOAuthToken(@Param("access_token") String access_token, @Param("expires_in") int expires_in, @Param("nowTime") Timestamp nowTime);
}
