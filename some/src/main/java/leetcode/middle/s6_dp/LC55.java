package leetcode.middle.s6_dp;

/**
 * 不算是一个dp题目，不知道为什么会在dp的分类里面
 * <p>
 * 贪心算法
 */
public class LC55 {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return true;
        }

        //取第一次行进的值
        int num = nums[0];
        if (num == 0) {
            return false;
        }
        int max = num;
        if (max >= n - 1) {
            return true;
        }
        int i = 0;
        while (i < max) {
            i++;
            num = nums[i];
            max = Math.max(max, num + i);
            if (max >= n - 1) {
                return true;
            }
        }

        return false;
    }
}
