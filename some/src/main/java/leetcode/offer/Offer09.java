package leetcode.offer;

import java.util.Stack;

public class Offer09 {

    class CQueue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>(); // 用于存储正序数据
            stack2 = new Stack<>(); // 用于存储逆序数据
        }

        public void appendTail(int value) {
            stack2.push(value);
        }

        public int deleteHead() {
            if (stack1.isEmpty() && stack2.isEmpty()) {
                return -1;
            }
            if (stack1.isEmpty()) {
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            return stack1.pop();
        }
    }

}
