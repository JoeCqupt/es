package leetcode.offer;

/**
 *  这个解法也太复杂了，稍微一个条件写错了，就是错
 */
public class Offer29 {

    public int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return new int[]{};
        int col = matrix[0].length;
        if (col == 0) return new int[]{};
        int res[] = new int[row * col];
        int length = res.length;

        int l1 = 0, l2 = col - 1;
        int d1 = 0, d2 = row - 1;
        int r1 = col - 1, r2 = 0;
        int u1 = row - 1, u2 = 0;

        int index = 0;
        while (true) {
            int left = travel(res, true, u2, l1, l2, index, matrix);
            if (left == length) break;
            l1++;
            l2--;
            d1++;
            index = left;
            int down = travel(res, false, l2 + 1, d1, d2, index, matrix);
            if (down == length) break;

            d2--;
            r1--;
            index = down;
            int right = travel(res, true, d2 + 1, r1, r2, index, matrix);
            if (right == length) break;

            r2++;
            u1--;
            u2++;
            index = right;
            int up = travel(res, false, r2 - 1, u1, u2, index, matrix);
            if (up == length) break;

            index = up;
        }
        return res;
    }

    private int travel(int[] res, boolean isRow, int value, int start, int end, int index, int[][] matrix) {
        if (start <= end) {
            for (int i = start; i <= end; i++) {
                res[index] = isRow ? matrix[value][i] : matrix[i][value];
                index++;
            }
        } else {
            for (int i = start; i >= end; i--) {
                res[index] = isRow ? matrix[value][i] : matrix[i][value];
                index++;
            }
        }
        return index;
    }

}
