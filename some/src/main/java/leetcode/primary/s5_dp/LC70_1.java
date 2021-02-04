package leetcode.primary.s5_dp;

public class LC70_1 {

    public int climbStairs(int n) {
        int i1 = 0;
        int i2 = 1;
        int res = 0;

        for (int i = 1; i <= n; i++) {
            res = i1 + i2;

            i1 = i2;
            i2 = res;
        }

        return res;
    }
}
