package leetcode;

public class Solution123 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] stateTo = new int[n][k + 1][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                stateTo[i][k][0] = 0;
                stateTo[i][k][1] = Integer.MIN_VALUE;
                stateTo[i][k - 1][0] = 0;
                continue;
            }
            stateTo[i][k][0] = Math.max(
                    stateTo[i - 1][k][0],
                    stateTo[i - 1][k][1] + prices[i]
            );

            stateTo[i][k][1] = Math.max(
                    stateTo[i - 1][k][1],
                    stateTo[i - 1][k - 1][0] - prices[1]
            );

        }
        return stateTo[n - 1][k][0];
    }
}
