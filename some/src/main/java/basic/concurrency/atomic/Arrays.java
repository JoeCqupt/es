package basic.concurrency.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Arrays {

    public static void main(String[] args) {
        AtomicIntegerArray array = new AtomicIntegerArray(3);
        int i = array.addAndGet(1, 3);
        System.out.println(i);
    }
}
