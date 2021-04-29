package basic.concurrency.utils.executor;



import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorDesc {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
        scheduledExecutorService.scheduleWithFixedDelay(
                () -> System.out.println("running"),
                3,
                3,
                TimeUnit.SECONDS
        );

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
