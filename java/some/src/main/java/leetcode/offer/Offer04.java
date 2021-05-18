package leetcode.offer;

/**
 * 从右上出发
 */
public class Offer04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) return false;
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) return false;
        int i = 0;
        int j = col - 1;
        while (i >= 0 && i < row && j >= 0 && j < col) {
            int value = matrix[i][j];
            if (target == value) {
                return true;
            }
            if (target < value) {
                j--;
            }
            if (target > value) {
                i++;
            }
        }
        return false;
    }

}
