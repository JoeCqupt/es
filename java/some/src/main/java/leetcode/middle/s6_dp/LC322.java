package leetcode.middle.s6_dp;

import java.util.Arrays;
/**
 * dp
 *  这个解法不是最优的
 *  我感觉可以把那个dp数组的长度优化为coins的长度
 *
 */
public class LC322 {

    public static void main(String[] args) {
        LC322 solution = new LC322();
        int i = solution.coinChange(
                new int[]{1, 2147483647},
                2
        );
        System.out.println(i);
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int coin = coins[j];
                if (i == coin) {
                    dp[i] = 1;  //刚好相等
                    break;
                } else if (i > coin) {
                    if (dp[i - coin] > 0) {
                        dp[i] = dp[i] > 0 ?
                                Math.min(dp[i - coin] + 1, dp[i]) : dp[i - coin] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }

}
