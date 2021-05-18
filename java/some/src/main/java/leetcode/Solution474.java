package leetcode;

/**
 * todo @jiangyuan
 */
public class Solution474 {

    public int findMaxForm(String[] strs, int m, int n) {
        int o = strs.length;
        // m 代表0 n 代表1
        int dp[][][] = new int[o + 1][m + 1][n + 1]; // 初始化为0

        for (int i = 1; i <= o; i++) {
            String str = strs[i-1];
            int[] temp = count(str);
            int one = temp[0];
            int zero = temp[1];
            dp[i] = dp[i-1];
            // j:0  k:1
            for (int j = 1, k = 1; j <= m || k <= n; j++, k++) {
                if (j > m || k > n || one > k || zero > j) {
                    dp[i][j][k] = dp[i - 1][j][k];
                } else {
                    dp[i][j][k] = Math.max(
                            dp[i - 1][j][k],
                            dp[i - 1][j - zero][k - one] + 1
                    );
                }
            }
        }
        return dp[o][m][n];
    }

    private int[] count(String str) {
        int[] count = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count[0]++;
            } else {
                count[1]++;
            }
        }
        return count;
    }

}
