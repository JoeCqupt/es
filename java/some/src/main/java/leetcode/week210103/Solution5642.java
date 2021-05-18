package leetcode.week210103;

import java.util.*;

public class Solution5642 {
    public static void main(String[] args) {
        Solution5642 solution = new Solution5642();
        int res = solution.countPairs(new int[]{
                149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234
        });


        System.out.println(res);
    }

    public int countPairs(int[] deliciousness) {
        int div = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> targets = new ArrayList<>(22);
        for (int i = 0; i <= 21; i++) {
            targets.add(1 << i);
        }
        int result = 0;
        for (int d : deliciousness) {
            for (int target : targets) {
                result = (result + map.getOrDefault(target - d, 0)) % div;
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        return result;
    }

}
