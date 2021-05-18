package leetcode.week210131;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution5665 {

    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length + 1;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            int value1 = pair[0];
            int value2 = pair[1];

            List<Integer> list1 = map.get(value1);
            if (list1 == null) {
                list1 = new ArrayList<>(2);
                list1.add(value2);
                map.put(value1, list1);
            } else
                list1.add(value2);

            List<Integer> list2 = map.get(value2);
            if (list2 == null) {
                list2 = new ArrayList<>(2);
                list2.add(value1);
                map.put(value2, list2);
            } else
                list2.add(value1);
        }
        int start = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }
        int[] res = new int[n];
        res[0] = start;
        for (int i = 1; i < n; i++) {
            List<Integer> list = map.get(res[i-1]);
            if (list.size() == 1) {
                res[i] = list.get(0);
                continue;
            }
            if (list.get(0) == res[i-2]) {
                res[i] = list.get(1);
            } else {
                res[i] = list.get(0);
            }
        }
        return res;
    }
}
