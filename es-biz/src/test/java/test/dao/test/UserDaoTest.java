package test.dao.test;

import com.example.DO.User;
import com.example.DO.UserExample;
import com.example.dao.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.TestBase;

import java.util.List;

public class UserDaoTest extends TestBase {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void test1(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUser_ageIsNotNull();
        List<User> userList = userMapper.selectByExample(userExample);
        Assert.assertNotNull(userList);
    }
}
