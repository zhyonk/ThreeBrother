package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }
}
