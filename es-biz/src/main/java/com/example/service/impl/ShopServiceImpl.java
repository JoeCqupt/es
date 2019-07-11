package com.example.service.impl;

import com.example.DO.User;
import com.example.UserServiceApi;
import com.example.service.ShopService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {


    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceApi userServiceApi;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Override
    public List<User> getShopUser() {
        return userServiceApi.queryByName("joe");
    }

    // 注解 单机事务
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSomething() {
        userService.updateName("joeUpdate456", 1);
        throw new RuntimeException("test");  // 本地事务生效了
//        userServiceApi.updateAge(24, 1);
    }

    //编程式 单机事务
    @Override
    public void updateSomething2() {
        transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus status) {

                try {
                    userService.updateName("8989", 1);
                    int a = 1 / 0;
//              userServiceApi.updateAge(24, 1);
                    return null;
                } catch (Exception e) {
                    status.setRollbackOnly();
                    throw e;
                }
            }
        });
    }


    // 分布式事务
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateSomething3() {

        userServiceApi.updateAge(44, 1);
        int a = 1 / 0;
        userService.updateName("joeUpdate456", 1);
    }


}
