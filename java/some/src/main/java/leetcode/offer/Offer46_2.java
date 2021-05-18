package leetcode.offer;

import java.util.LinkedList;
import java.util.List;

/**
 * DP 解法
 */
public class Offer46_2 {

    public int translateNum(int num) {
        List<Integer> list = splitNum(num);
        int[] dp = new int[list.size()];
        dp[0] = 1;
        for (int i = 1; i < list.size(); i++) {
            int pre = list.get(i - 1);
            int now = list.get(i);
            if (pre == 0 || pre * 10 + now > 25) {
                dp[i] = dp[i - 1];
            } else {
                if (i - 2 >= 0) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + 1;// ps：这里需要加一
                }
            }
        }
        return dp[list.size() - 1];
    }

    private List<Integer> splitNum(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        while (num / 10 >= 1) {
            list.addFirst(num % 10);
            num = num / 10;
        }
        list.addFirst(num);
        return list;
    }
}
