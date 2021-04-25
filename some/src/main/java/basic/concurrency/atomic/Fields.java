package basic.concurrency.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class Fields {

    static class Node {
        // 必须是volatile关键字修饰的, 不然会报错
        volatile long version;
    }


    public static void main(String[] args) {
        Node node = new Node();

        AtomicLongFieldUpdater<Node> fieldUpdater =
                AtomicLongFieldUpdater.newUpdater(Node.class, "version");

        fieldUpdater.compareAndSet(node, 0L, 3L);
    }

}
