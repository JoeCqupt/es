package leetcode.week210117;

import java.util.HashMap;
import java.util.Map;

public class Solution5243 {

    public static void main(String[] args) {
        Solution5243 solution = new Solution5243();
        int res = solution.tupleSameProduct(
                new int[]{
                        2,3,4,6,8,12
                }
        );
        System.out.println(res);
    }

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int temp = nums[i] * nums[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }

        int res = 0;
        for (Integer c : map.values()) {
            if (c >= 2) {
                res = res + (8 * (c*(c-1)/2));
            }
        }
        return res;
    }



}