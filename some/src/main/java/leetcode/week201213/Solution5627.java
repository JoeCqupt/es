package leetcode.week201213;

/**
 * 博弈dp / 区间dp
 *
 * 算法之深，我真的是菜到无法形容
 *
 */
public class Solution5627 {

    public static void main(String[] args) {
        Solution5627 solution5627 = new Solution5627();
        int i = solution5627.stoneGameVII(new int[]{5, 3, 1, 4, 2});
        System.out.println(i);

    }

    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[] dp = new int[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += stones[i];
            dp[i] = temp;
        }

        int result[][] = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (j - i == 1) {
                    result[i][j] = Math.max(stones[i], stones[j]);
                } else {
                    result[i][j] = Math.max(
                            dp[j] - dp[i + 1] + stones[i + 1] - result[i + 1][j],
                            dp[j - 1] - dp[i] + stones[i] - result[i][j - 1]
                    );
                }
            }
        }
        return result[0][n - 1];
    }
}
