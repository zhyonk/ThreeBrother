package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    public User getByUsername(String username){
        return userDao.getByUsername(username);
    }
    public Set<String> getRoles(String username){
        return userDao.getRoles(username);
    }
    public Set<String> getPermissions(String username){
        return userDao.getPermissions(username);
    }
}
