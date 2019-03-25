package test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * 测试是否正确的读取到配置文件
 */
public class PropertiesTest extends TestBase {
    @Value("${className}")
    private String className;

    @Value("${user}")
    private String user;

    @Value("${url}")
    private String url;

    @Value("${password}")
    private String password;

    @Test
    public void testGetPropertiesValue() {
        Assert.assertEquals("com.mysql.jdbc.Driver", className);
        Assert.assertEquals("root", user);
        Assert.assertEquals("jdbc:mysql://localhost:3306/es_dev?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true", url);
        Assert.assertEquals("joe101019", password);
    }
}
