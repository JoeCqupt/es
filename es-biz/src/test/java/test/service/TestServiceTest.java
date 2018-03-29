package test.service;

import com.example.DO.TestDO;
import com.example.service.TestService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import test.TestBase;

public class TestServiceTest extends TestBase {
    @Autowired
    private TestService testService;

    @Test
    public void test() {
        TestDO testDO = new TestDO();
        testDO.setName("test");
        Assert.assertTrue(testService.insert(testDO));
    }
}
