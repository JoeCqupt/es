package com.example.service.impl;

import com.example.DO.User;
import com.example.DO.UserExample;
import com.example.REQ.user.UserRegisterREQ;
import com.example.UserServiceApi;
import com.example.dao.UserMapper;
import com.example.service.UserService;
import com.example.util.MyAssert;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService, UserServiceApi {
    @Autowired

    private UserMapper userMapper;


    @Override
    public User login(String userName, String password) {
        return null;
    }

    @Override
    public void register(UserRegisterREQ req) {
        // todo 业务逻辑实现
        // todo 要让req 的validation 生效还需要写个 aop 切面
        User user = new User();
        user.setUserName(req.getName());
        user.setUserAge(req.getAge());
        user.setUserNickName(req.getNickName());
        user.setUserPass(req.getPass());

        userMapper.insertSelective(user);
    }

    @Override
    public void updateName(String name, int id) {
        User updateUser = new User();
        updateUser.setUserName(name);
        updateUser.setId(id);
        userMapper.updateByPrimaryKeySelective(updateUser);
    }

    @Override
    public List<User> queryByName(String name) {
        MyAssert.notBlank(name);
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(name);
        return userMapper.selectByExample(example);
    }

    @Override
    public void updateAge(int age, int id) {
        User updateUser = new User();
        updateUser.setUserAge((byte) age);
        updateUser.setId(id);
        userMapper.updateByPrimaryKeySelective(updateUser);
    }
}
