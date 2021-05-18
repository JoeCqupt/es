package leetcode.offer;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class Offer30 {
    /**
     * 垃圾实现 时间复杂度
     * push log2N
     * pop  log2N
     * top  o1
     * min  o1
     */
    class MinStack1 {

        PriorityQueue<Integer> queue = null;
        LinkedList<Integer> stack = null;

        /**
         * initialize your data structure here.
         */
        public MinStack1() {
            queue = new PriorityQueue<>();
            stack = new LinkedList<>();
        }

        public void push(int x) {
            stack.push(x);
            queue.offer(x);
        }

        public void pop() {
            Integer pop = stack.pop();
            queue.remove(pop);
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return queue.peek();
        }
    }

    class MinStack {

        class Node {
            int val;
            Node next;
            int min;

            public Node(int val, Node next, int min) {
                this.val = val;
                this.next = next;
                this.min = min;
            }
        }

        Node head;

        /**
         * initialize your data structure here.
         */
        public MinStack() {

        }

        public void push(int x) {
            if (head == null) {
                head = new Node(x, null, x);
            } else {
                Node node = new Node(x, head, Math.min(head.min, x));
                head = node;
            }
        }

        public void pop() {
            if (head == null)
                throw new IllegalArgumentException();
            head = head.next;
        }

        public int top() {
            if (head == null)
                throw new IllegalArgumentException();
            return head.val;
        }

        public int min() {
            if (head == null)
                throw new IllegalArgumentException();
            return head.min;
        }
    }


}
