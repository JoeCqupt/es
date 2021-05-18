package leetcode.offer;


public class Offer29_2 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0|| matrix==null) return new int[]{};
        // 上界 t
        // 下界 d
        // 左边 l
        // 右边 r

        int t = 0, l = 0;
        int d = matrix.length - 1;
        int r = matrix[0].length - 1;

        int idx = 0;
        int res[] = new int[(d + 1) * (r + 1)];
        while (true) {
            for (int i = l; i <= r; i++) res[idx++] = matrix[t][i];
            if (++t > d) break;
            for (int i = t; i <= d; i++) res[idx++] = matrix[i][r];
            if (--r < l) break;
            for (int i = r; i >= l; i--) res[idx++] = matrix[d][i];
            if (--d < t) break;
            for (int i = d; i >= t; i--) res[idx++] = matrix[i][l];
            if (++l > r) break;
        }
        return res;
    }
}
