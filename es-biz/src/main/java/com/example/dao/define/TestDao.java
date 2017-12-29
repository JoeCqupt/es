package com.example.dao.define;

import com.example.DO.TestDO;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {
    Integer insert(TestDO testDO);
}
