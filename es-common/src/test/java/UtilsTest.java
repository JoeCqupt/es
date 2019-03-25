import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.HashSet;
import java.util.UUID;

public class UtilsTest {


    //测试生成随机的字符串
    @Test
    public void testGeneratorRandomStr(){


        String str = RandomStringUtils.random(32,true,true);

        System.out.println(str);


    }
}
