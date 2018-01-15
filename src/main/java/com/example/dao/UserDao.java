package com.example.dao;

import com.example.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Set;

public interface UserDao {

    User selectUser(@Param(value = "id") long id);

    public User getByUsername(@Param(value="username")String username);

    public Set<String> getRoles(@Param(value="username")String username);

    public Set<String> getPermissions(@Param(value="username")String username);
}
