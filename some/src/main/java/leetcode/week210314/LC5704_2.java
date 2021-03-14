package leetcode.week210314;

/**
 * 感觉有点没懂：为什么
 */
public class LC5704_2 {
    public int maximumScore(int[] nums, int k) {
        int left = k;
        int right = k;
        int res = nums[k];
        int n = nums.length;
        int min = nums[k];
        while (true) {
            if (left == 0) {
                if (right == n - 1) {
                    break;
                }
                right++;
                min = Math.min(min, nums[right]);
            } else if (right == n - 1) {
                if (left == 0) {
                    break;
                }
                left--;
                min = Math.min(min, nums[left]);
            } else if (nums[left - 1] > nums[right + 1]) {
                left--;
                min = Math.min(min, nums[left]);
            } else {
                right++;
                min = Math.min(min, nums[right]);
            }
            res = Math.max(res, (right - left + 1) * min);
        }
        return res;
    }
}
