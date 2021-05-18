package leetcode;

public class Solution123_2 {
    public static void main(String[] args) {
        Solution123_2 solution = new Solution123_2();
        int res = solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length; // array length
        int t = 2; // 2 times

        // 三个状态  1.购买时机 2.购买次数  3.是否持有股票
        int dp[][][] = new int[n][t + 1][2];

        // 如何i/j为0，表示还未进行交易 所以利润是0

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < t + 1; j++) {
                int price = prices[i];
                if (i == 0 || j == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -price;
                    continue;
                }
                // 不持有股票
                dp[i][j][0] = Math.max(
                        dp[i - 1][j][0],
                        dp[i - 1][j][1] + price
                );
                // 持有股票
                dp[i][j][1] = Math.max(
                        dp[i - 1][j][1],
                        dp[i - 1][j - 1][0] - price
                );
            }
        }

        return dp[n-1][t][0];
    }

}
