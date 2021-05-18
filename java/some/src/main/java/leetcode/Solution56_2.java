package leetcode;

import java.util.*;

public class Solution56_2 {

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        for (int i = 1; i < n; i++) {
            int[] arr = intervals[i];
            int[] ints = list.peekLast();
            if (arr[0] <= ints[1]) {
                ints[1] = Math.max(ints[1], arr[1]);
            } else {
                list.addLast(arr);
            }
        }

        n = list.size();

        int[][] res = new int[n][2];
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
