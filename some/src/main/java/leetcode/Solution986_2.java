package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution986_2 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int res[][] = new int[][]{};
        int la = A.length;
        int lb = B.length;
        if (la == 0 || lb == 0) {
            return res;
        }
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < la && j < lb) {
            int[] a = A[i];
            int[] b = B[j];

            if (a[0] <= b[1] && a[1] >= b[0]) {
                int left = Math.max(a[0], b[0]);
                int right = Math.min(a[1], b[1]);
                list.add(new int[]{left, right});
            }

            if (a[1] >= b[1]) {
                j++;
            } else {
                i++;
            }
        }

        if (list.isEmpty()) {
            return res;
        }
        res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        return res;
    }
}
