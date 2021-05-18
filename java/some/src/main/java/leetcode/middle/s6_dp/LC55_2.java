package leetcode.middle.s6_dp;

public class LC55_2 {
    public boolean canJump(int[] nums) {
        int leftMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= leftMost) {
                leftMost = Math.max(leftMost, i + nums[i]);
                if (leftMost >= nums.length - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }
        return false;
    }
}
