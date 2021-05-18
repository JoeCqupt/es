package leetcode;

import java.util.*;

public class Solution56 {

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        int[][] param = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution56.merge(param);
        System.out.println(Arrays.deepToString(result));
    }

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            }
        });


        int left = intervals[0][0];
        int right = intervals[0][1];
        int cIndex = 0;
        Set<Integer> removeIndexes = new HashSet<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = intervals[i];
            int cl = ints[0];
            int cr = ints[1];

            if (left <= cl && cr <= right) {
                removeIndexes.add(i);
                continue;
            }

            if (cl <= right && cr > right) {
                right = cr;
                removeIndexes.add(i);
                intervals[cIndex] = new int[]{left, right};
                continue;
            }

            if (cl > right) {
                left = cl;
                right = cr;
                cIndex = i;
            }
        }

        if (removeIndexes.isEmpty()) {
            return intervals;
        }
        int n = intervals.length - removeIndexes.size();
        int[][] result = new int[n][2];
        for (int i = 0, j = 0; i < intervals.length; i++) {
            if (!removeIndexes.contains(i)) {
                result[j] = intervals[i];
                j++;
            }
        }

        return result;
    }

}
