package basic.concurrency.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class References {

    static class Node {
        private volatile int version;
    }

    private static AtomicReference<Node> tail = new AtomicReference<Node>(null);

    private static AtomicStampedReference<Node> head = new AtomicStampedReference<Node>(null, 0);

    public static void main(String[] args) {
        Node node1 = new Node();


        boolean b = tail.compareAndSet(null, node1);
        System.out.println(b);


        int[] currentStamp = new int[1];
        Node node2 = head.get(currentStamp);
        head.compareAndSet(node2, node1, currentStamp[0], currentStamp[0] + 1);
    }
}
