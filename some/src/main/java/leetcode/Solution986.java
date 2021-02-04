package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution986 {

    public static void main(String[] args) {
        Solution986 solution986 = new Solution986();

    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int la = A.length;
        int lb = B.length;
        int[][] res = new int[][]{};
        if (la == 0 || lb == 0) {
            return res;
        }
        List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < la && j < lb) {
            int[] a = A[i];
            int[] b = B[j];

            if (a[1] < b[0]) {
                i++;
                continue;
            }
            if (a[0] > b[1]) {
                j++;
                continue;
            }

            if (a[0] <= b[1]) {
                //交集部分
                int left = Math.max(a[0], b[0]);
                int right = Math.min(a[1], b[1]);
                result.add(new int[]{left, right});
                if (a[1] <= b[1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        int n = result.size();
        if (n == 0) {
            return res;
        }
        res = new int[n][2];
        for (int k = 0; k < result.size(); k++) {
            res[k] = result.get(k);
        }
        return res;
    }

}
