package leetcode.offer;

/**
 * 从左下出发
 */
public class Offer04_2 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) return false;
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) return false;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && i < row && j >= 0 && j < col) {
            int value = matrix[i][j];
            if (value == target) {
                return true;
            }
            if (value > target) {
                i--;
            }
            if (value < target) {
                j++;
            }
        }
        return false;
    }

}
