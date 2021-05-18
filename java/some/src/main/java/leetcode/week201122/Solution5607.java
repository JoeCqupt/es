package leetcode.week201122;

import java.util.HashMap;
import java.util.Map;

public class Solution5607 {
    public static void main(String[] args) {
        Solution5607 solution5607 = new Solution5607();
        int i = solution5607.waysToMakeFair(new int[]{1, 1, 1});
        System.out.println(i);
    }

    public int waysToMakeFair(int[] nums) {
        int result = 0;
        Map<Integer, Integer> skipMap = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            skipMap.put(i, skipMap.getOrDefault(i + 2, 0) + nums[i]);
        }

        int doubleValue = 0;
        int singleValue = 0;
        for (int i = 0; i + 1 <= nums.length; i++) {
            int value = skipMap.get(i) - nums[i];
            if (i % 2 == 0) {
                int tmp1 = singleValue + value;
                int tmp2 = doubleValue + skipMap.getOrDefault(i + 1,0);
                if (tmp1 == tmp2) {
                    result++;
                }
                doubleValue += nums[i];
            } else {
                int tmp1 = doubleValue + value;
                int tmp2 = singleValue + skipMap.getOrDefault(i + 1,0);
                if (tmp1 == tmp2) {
                    result++;
                }
                singleValue += nums[i];
            }
        }

        return result;
    }
}
