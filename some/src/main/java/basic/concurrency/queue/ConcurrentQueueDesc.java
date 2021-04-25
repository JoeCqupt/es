package basic.concurrency.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentQueueDesc {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> clq = new ConcurrentLinkedQueue<>();

        clq.offer(1);
        clq.offer(2);
    }
}
