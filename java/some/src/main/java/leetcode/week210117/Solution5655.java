package leetcode.week210117;

import java.util.Arrays;

public class Solution5655 {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] == 1 ?
                        (matrix[i - 1][j] + matrix[i][j]) :  // 当前值为1
                        matrix[i][j];  // 当前值为0
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            int[] arr = matrix[i];
            Arrays.sort(arr);
            for (int j = n - 1; j >= 0; j--) {
                if(arr[j] == 0){
                    break;
                }
                res = Math.max(res, arr[j] * (n -j));
            }
        }

        return res;
    }
}
