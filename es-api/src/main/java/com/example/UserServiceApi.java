package com.example;

import com.example.DO.User;

import java.util.List;

public interface UserServiceApi {

    List<User> queryByName(String name);

}
