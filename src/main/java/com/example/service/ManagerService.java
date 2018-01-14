package com.example.service;

import com.example.model.UserAgent;
import org.weixin4j.Weixin;

public interface ManagerService {

    boolean adminLogin(String name,String password);
    void addVisitorLog(UserAgent userAgent, String remoteAddr, String requestURL);
}
