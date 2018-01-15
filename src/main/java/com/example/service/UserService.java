package com.example.service;

import com.example.model.User;

import java.util.Set;

public interface UserService {
    public User selectUser(long userId);
    public User getByUsername(String username);

    public Set<String> getRoles(String username);

    public Set<String> getPermissions(String username);
}
