package basic.concurrency.thread;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Interrupts {
    public static void main(String[] args) throws InterruptedException {
        // 忽略中断
        test1();

        // 处理中断
//        test2();
    }

    public static void test1() throws InterruptedException {
        Thread thread = new Thread(new Task());
        thread.start();
        TimeUnit.SECONDS.sleep(3);

        thread.interrupt();

        new Scanner(System.in).nextLine();
    }


    public static void test2() throws InterruptedException {
        Thread thread = new Thread(new Task2());
        thread.start();
        TimeUnit.SECONDS.sleep(3);

        thread.interrupt();

        new Scanner(System.in).nextLine();
    }


    static class Task implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    // ignore
                    System.out.println(System.currentTimeMillis() + ":i got an interrupt, but i ignore");
                    // InterruptedException 一般会清除interrupt Status
//                    System.out.println("current interrupt state:" + Thread.interrupted()); // false
//                    Thread.currentThread().interrupt(); // 可以使用这种方式将传递 interrupt Status
                }
                System.out.println(System.currentTimeMillis() + ":i am running");
            }
        }
    }

    static class Task2 implements Runnable {
        @Override
        public void run() {
            while (true && !Thread.interrupted()) { // 处理中端
                System.out.println(System.currentTimeMillis() + ":i am running");
            }
        }
    }
}
