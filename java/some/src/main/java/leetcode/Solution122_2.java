package leetcode;

public class Solution122_2 {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int i_0 = 0;
        int i_1 = Integer.MIN_VALUE;
        int temp ;
        for (int i = 0; i < n; i++) {
            temp = i_0;
            i_0 = Math.max(i_0, i_1 + prices[i]);
            i_1 = Math.max(i_1, temp - prices[i]);
        }
        return i_0;
    }
}
