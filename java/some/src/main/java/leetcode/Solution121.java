package leetcode;

/**
 * 暴力解法
 */
public class Solution121 {

    public int maxProfit(int[] prices) {
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                value = Math.max(prices[j] - prices[i], value);
            }
        }
        return value < 0 ? 0 : value;
    }
}
