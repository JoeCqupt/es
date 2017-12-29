package com.example.service.impl;

import com.example.DO.TestDO;
import com.example.dao.define.TestDao;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestDao testDao;
    @Override
    public boolean insert(TestDO testDO) {
        return testDao.insert(testDO)>0;
    }
}
