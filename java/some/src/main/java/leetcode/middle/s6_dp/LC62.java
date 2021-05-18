package leetcode.middle.s6_dp;

import java.util.Arrays;

public class LC62 {

    public int uniquePaths(int m, int n) {
        if (m == 1) {
            return 1;
        }
        int[] pre = new int[n];
        Arrays.fill(pre, 1); // 初始化第一行的
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pre[j] = pre[j] + pre[j - 1];
            }
        }

        return pre[n - 1];
    }
}
