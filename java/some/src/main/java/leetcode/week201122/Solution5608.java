package leetcode.week201122;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/minimum-initial-energy-to-finish-tasks/
 */
public class Solution5608 {

    public static void main(String[] args) {
        int[][] arg = new int[][]{{1, 2}, {1, 7}, {2, 3}, {5, 9}, {2, 2}};
        Solution5608 solution5608 = new Solution5608();
        int i = solution5608.minimumEffort(arg);
        System.out.println(i);

    }

    public int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int value1 = Math.abs(o1[0] - o1[1]);
                int value2 = Math.abs(o2[0] - o2[1]);
                return value1 - value2;
            }
        });

        int[] copBefore = tasks[0];
        for (int i = 1; i < tasks.length; i++) {
            int[] currentCop = tasks[i];
            int real = copBefore[0] + currentCop[0];


            int minBefore = Math.max(copBefore[0], copBefore[1]);
            int minCurrent = Math.max(currentCop[0], currentCop[1]);

            int need;
            if (minBefore <= Math.abs(currentCop[1] - currentCop[0])) {
                need = minCurrent;
            } else if (minCurrent <= Math.abs(copBefore[1] - copBefore[0])) {
                need = minBefore;
            } else {
                need = Math.min(currentCop[0] + copBefore[1], currentCop[1] + copBefore[0]);
            }
            copBefore = new int[]{real, need};
        }
        return copBefore[1];
    }

}
