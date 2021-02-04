package leetcode;

/**
 * 理解了状态机 的原理之后，简化后
 */
public class Solution121_3 {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int pre = Integer.MAX_VALUE;
        int temResult = 0;
        for (int i = 0; i + 1 < n; i++) {
            // 保存前面最小的值
            pre = Math.min(pre, prices[i]);

            // 计算当前的结果
            temResult = Math.max(temResult, prices[i + 1] - pre);
        }

        return temResult;
    }

}
