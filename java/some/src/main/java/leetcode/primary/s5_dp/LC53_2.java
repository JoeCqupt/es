package leetcode.primary.s5_dp;

public class LC53_2 {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int pre = 0;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            res = Math.max(res, pre);
        }
        return res;
    }
}
