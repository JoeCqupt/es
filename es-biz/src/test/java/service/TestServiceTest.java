package service;

import com.example.DO.TestDO;
import com.example.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestServiceTest extends service.TestBase {
    @Autowired
    private TestService testService;

    @Test
    public void test() {
        TestDO testDO = new TestDO();
        testDO.setName("test");
        Assert.assertTrue(testService.insert(testDO));
    }
}
