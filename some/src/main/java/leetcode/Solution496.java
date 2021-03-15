package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {

    public static void main(String[] args) {
        Solution496 so = new Solution496();

        int[] ints = so.nextGreaterElement(
                new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2}
        );

        System.out.println(Arrays.toString(ints));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            int value = nums2[i];
            while (!stack.isEmpty() && value > stack.peek())
                map.put(stack.pop(), value);

            stack.push(value);
        }
        while (!stack.isEmpty())
            map.put(stack.pop(), -1);

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
