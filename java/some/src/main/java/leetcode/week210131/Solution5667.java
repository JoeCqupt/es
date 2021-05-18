package leetcode.week210131;

/**
 * 这道题坑爹的地方就是要考虑 计算会溢出！！！
 */
public class Solution5667 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sum = new long[candiesCount.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = candiesCount[i] + sum[i - 1];
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int type = query[0];
            int day = query[1];
            int dayCount = query[2];

            // 表示最少
            long min = day + 1L;
            // 表示最多
            long max = (day + 1) *  (long)dayCount;

            long typeCount = sum[type];
            long preTypeCount = type == 0 ? 0 : sum[type - 1];

            if (min <= typeCount && max > preTypeCount) {
                res[i] = true;
            } else {
                res[i] = false;
            }
        }
        return res;
    }
}
