package leetcode.primary.s5_dp;

/**
 * 最原始的递归方式 ： 复杂度 惨不忍睹
 */
public class LC70 {
    public int climbStairs(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        int s1 = 0;
        int s2 = 0;
        s1 = climbStairs(n - 1);
        s2 = climbStairs(n - 2);
        return s1 + s2;
    }

}
