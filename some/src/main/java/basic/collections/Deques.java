package basic.collections;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Deque short for double-ended-queue
 */
public class Deques {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(3);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.removeFirstOccurrence(3);
        System.out.println(deque);
    }
}
