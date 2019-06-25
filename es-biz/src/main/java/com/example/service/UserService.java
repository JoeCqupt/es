package com.example.service;

import com.example.DO.User;
import com.example.REQ.user.UserRegisterREQ;
import org.springframework.validation.annotation.Validated;

public interface UserService {

    User login(String userName, String password);

    void register(@Validated UserRegisterREQ req);
}
