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
    public void insertTest1(){
        User user = new User();
        user.setUserAge((byte) 24);
        user.setUserName("joe");
        user.setUserNickName("joecqupt");
        user.setUserPass("test");
        user.setUserSalt("test");
        Assert.assertEquals(1, userMapper.insertSelective(user));
    }

    @Test
    public void test1(){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserAgeIsNotNull();
        List<User> userList = userMapper.selectByExample(userExample);
        Assert.assertNotNull(userList);
    }
}
