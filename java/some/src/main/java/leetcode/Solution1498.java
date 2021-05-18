package leetcode;

import java.util.Arrays;

public class Solution1498 {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int cnt = 0;

        int left = 0;
        int right = 0;
        while (left <= right && right < nums.length && left<nums.length) {
            if (nums[left] + nums[right] <= target) {
                cnt++;
                right++;
            } else {
                left++;
                right = left;
            }
        }
        return cnt;
    }

}
