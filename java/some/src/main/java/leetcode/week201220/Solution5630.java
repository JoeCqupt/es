package leetcode.week201220;

import java.util.HashMap;

public class Solution5630 {
    public static void main(String[] args) {
        Solution5630 solution5630 = new Solution5630();
        int result = solution5630.maximumUniqueSubarray(
                new int[]{
                        187, 470, 25, 436, 538, 809, 441, 167, 477, 110, 275, 133, 666, 345, 411, 459, 490, 266, 987, 965, 429, 166, 809, 340, 467, 318, 125, 165, 809, 610, 31, 585, 970, 306, 42, 189, 169, 743, 78, 810, 70, 382, 367, 490, 787, 670, 476, 278, 775, 673, 299, 19, 893, 817, 971, 458, 409, 886, 434
                }
        );
        System.out.println(result);
    }

    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> window = new HashMap<>();
        int result = 0;
        int temp = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            while (window.keySet().contains(value) ) {
                // 缩小窗口
                int removed =  nums[left++];
                window.keySet().remove(removed);
                temp -= removed;
            }
            temp += value;
            right++;
            result = Math.max(temp, result);
            window.put(value, i);
        }
        return result;
    }
}
