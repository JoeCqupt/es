package leetcode.primary.s1_arr;

/**
 * 每次向后移动一位
 *
 * 效率很低  O(kn)
 */
public class LC189_3 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            return;
        }

        k = k % n;
        for (int i = 0; i < k; i++) {
            // 向后移动一位
            removeOneStep(nums);
        }
    }

    private void removeOneStep(int[] nums) {
        int n = nums.length;
        int last = nums[n - 1];
        for (int i = n - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = last;
    }
}
