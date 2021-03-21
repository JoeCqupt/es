package basic.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDesc {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        ai.compareAndSet(0,1);
        ai.weakCompareAndSet(1,2);
    }
}
