package com.example.service.impl;

import com.example.dao.AdminManagerDao;
import com.example.model.IpPosition;
import com.example.model.UserAgent;
import com.example.service.ManagerService;
import com.example.util.IpAddressUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Calendar;
@Service("managerService")
public class ManagerServiceImpl implements ManagerService{
    @Resource
    private AdminManagerDao adminmanagerDao;

    public boolean adminLogin(String name, String password) {
        return false;
    }

    public void addVisitorLog(UserAgent userAgent, String remoteAddr, String requestURL) {
        IpPosition ipObj = IpAddressUtils.getPosition(remoteAddr);
        adminmanagerDao.addVisitorLog(remoteAddr,ipObj.getCountry(),ipObj.getProvince(),ipObj.getCity(),new Timestamp(Calendar.getInstance().getTime().getTime()),userAgent.getBrowserType(),userAgent.getPlatformType(),requestURL);
    }
}
