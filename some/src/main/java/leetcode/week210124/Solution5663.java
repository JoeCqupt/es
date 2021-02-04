package leetcode.week210124;

import java.util.PriorityQueue;

public class Solution5663 {
    public static void main(String[] args) {
       Solution5663 solution = new Solution5663();
       int value = solution.kthLargestValue(
               new int[][]{
                       {5,2},{1,6}
               }, 1
       );
        System.out.println(value);
    }

    public int kthLargestValue(int[][] matrix, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k + 1);
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int left = 0;
                if (i - 1 >= 0) {
                    left = temp[i - 1][j];
                }

                int top = 0;
                if (j - 1 >= 0) {
                    top = temp[i][j - 1];
                }

                int tl = 0;
                if (i - 1 >= 0 && j - 1 >= 0) {
                    tl = temp[i - 1][j - 1];
                }

                temp[i][j] = left ^ top ^ tl ^ matrix[i][j];

                queue.add(temp[i][j]);
                if (queue.size() == k + 1) {
                    queue.poll();
                }
            }
        }
        return queue.poll();
    }
}
