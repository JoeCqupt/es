package leetcode;

public class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] temp = new int[n][2];
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                temp[i][0] = 0;
                temp[i][1] = -prices[i];
                continue;
            }
            temp[i][0] = Math.max(temp[i - 1][0], temp[i - 1][1] + prices[i]);
            //为下一次尝试计算最小购买值
            temp[i][1] = Math.max(temp[i - 1][1], result - prices[i]);
            result = temp[i][0];
        }

        return temp[n - 1][0];
    }
}
