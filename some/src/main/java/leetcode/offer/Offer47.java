package leetcode.offer;

/**
 * 典型的dp解法
 */
public class Offer47 {

    public static void main(String[] args) {
        Offer47 offer = new Offer47();
        int res = offer.maxValue(
                new int[][]{
                        {1,3,1},
                        {1,5,1},
                        {4,2,1}
                }
        );

        System.out.println(res);
    }

    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int dp[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int top = i - 1 >= 0 ? dp[i - 1][j] : 0;
                int left = j - 1 >= 0 ? dp[i][j - 1] : 0;
                dp[i][j] = Math.max(top + grid[i][j], left + grid[i][j]);
            }
        }
        return dp[row - 1][col - 1];
    }

}
