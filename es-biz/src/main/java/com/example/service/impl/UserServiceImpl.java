package com.example.service.impl;

import com.example.DO.User;
import com.example.dao.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(String userName, String password) {
        return null;
    }

    @Override
    public void register(User user) {
        // todo 业务逻辑实现
        userMapper.insertSelective(user);
    }
}
