package basic.concurrency.utils.executor;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorDesc {

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(4);

    }
}
