package basic.lambda;

import java.util.logging.Logger;

public class Test {

    private static final Logger logger = Logger
            .getLogger(Test.class.getName());



    private void log(){
        logger.fine("打印一些日志:" + this);
        logger.fine(() -> "打印一些日志:" + this);
    }

    public static void main(String[] args) {

    }
}
