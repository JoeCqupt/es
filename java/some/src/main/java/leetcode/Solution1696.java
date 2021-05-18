package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 动态规划 + 单调队列优化
 */
public class Solution1696 {

    public static void main(String[] args) {
        Solution1696 solution = new Solution1696();
        int result = solution.maxResult(
                new int[]{1, -1, -2, 4, -7, 3},
                2
        );
        System.out.println(result);
    }

    public int maxResult(int[] nums, int k) {
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nums[0], 0});
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            while (i - queue.peek()[1] > k) {
                queue.poll();
            }
            res = nums[i] + queue.peek()[0];
            if (i == nums.length - 1) {
                break;
            }
            while (!queue.isEmpty() && queue.peekLast()[0] <= res) {
                queue.pollLast();
            }
            queue.offer(new int[]{res, i});
        }
        return res;
    }

}
