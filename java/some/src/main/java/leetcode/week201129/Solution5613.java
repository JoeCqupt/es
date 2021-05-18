package leetcode.week201129;

public class Solution5613 {

    public int maximumWealth(int[][] accounts) {
        int n = accounts.length;
        int m = accounts[0].length;

        int result = 0;

        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < m; j++) {
                temp += accounts[i][j];
            }
            result = Math.max(temp, result);
        }
        return result;
    }
}
