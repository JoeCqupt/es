package test;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * 数据连接测试类
 */
public class ConnectionTest extends TestBase {


    @Autowired
    private DruidDataSource dataSource;

    /**
     * 测试数据库连接没有问题
     */
    @Test
    public void testGetConnection() {
        try {
            Assert.assertNotNull(dataSource.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
