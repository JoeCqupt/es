package leetcode.week201129;

import java.util.LinkedList;

/**
 * 单调栈的应用
 */
public class Solution5614_2 {

    public int[] mostCompetitive(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int n = nums.length;
        if (n == k) {
            return nums;
        }
        for (int i = 0; i < n; i++) {
            int temp = nums[i];
            while (!queue.isEmpty() && temp < queue.peekLast() && n - i > k - queue.size()) {
                queue.pollLast();
            }
            queue.addLast(temp);
        }


        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.removeFirst();
        }
        return result;
    }
}
