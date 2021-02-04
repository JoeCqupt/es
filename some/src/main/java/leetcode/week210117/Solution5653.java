package leetcode.week210117;

import java.util.HashMap;
import java.util.Map;

public class Solution5653 {

    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int[] tuple : rectangles) {
            int w = Math.min(tuple[0], tuple[1]);
            res = Math.max(res, w);
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        return map.get(res);
    }

}
