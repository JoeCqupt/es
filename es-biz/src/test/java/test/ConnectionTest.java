package test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * 数据连接测试类
 */
public class ConnectionTest extends TestBase {

    private static Logger logger = LoggerFactory.getLogger(ConnectionTest.class);
    @Autowired
    private DruidDataSource dataSource;

    /**
     * 测试数据库连接没有问题
     */
    @Test
    public void testGetConnection() {
        try {
            logger.info("run test get connection");
            Assert.assertNotNull(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
