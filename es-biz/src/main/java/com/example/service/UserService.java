package com.example.service;

import com.example.DO.User;

public interface UserService {
    User login(String userName, String password);
    void register(User user);
}
