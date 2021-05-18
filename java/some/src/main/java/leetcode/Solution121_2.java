package leetcode;

/**
 * 通过状态机来判断
 */
public class Solution121_2 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                temp[0][0] = 0;
                temp[0][1] = -prices[i];
                continue;
            }
            temp[i][0] = Math.max(temp[i - 1][0], temp[i - 1][1] + prices[i]);
            temp[i][1] = Math.max(temp[i - 1][1], -prices[i]);
        }
        return temp[n - 1][0];
    }
}
