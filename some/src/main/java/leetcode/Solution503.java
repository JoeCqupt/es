package leetcode;

import java.util.Stack;

public class Solution503 {

    static class Item {
        int value;
        int index;

        public Item(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Stack<Item> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int value = nums[i];
            while (!stack.isEmpty() && value > stack.peek().value)
                res[stack.pop().index] = value;
            stack.push(new Item(value, i));
        }

        if (!stack.isEmpty()) {
            for (int i = 0; i < n; i++) {
                int value = nums[i];
                while (!stack.isEmpty() && value > stack.peek().value)
                    res[stack.pop().index] = value;
            }
        }

        while (!stack.isEmpty()) {
            res[stack.pop().index] = -1;
        }


        return res;
    }

}
