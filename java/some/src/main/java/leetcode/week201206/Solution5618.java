package leetcode.week201206;

import java.util.HashMap;
import java.util.Map;

public class Solution5618 {

    public static void main(String[] args) {
        Solution5618 solution5618 = new Solution5618();
        int result = solution5618.maxOperations(
                new int[]{2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2},

        3
        );

        System.out.println(result);
    }

    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int target = k - num;
            Integer value = map.get(target);
            if (value == null) {
                map.put(num, map.getOrDefault(num,0)+1);
            } else {
                result++;
                if((value-1)==0) {
                    map.remove(target);
                }else {
                    map.put(target, --value);
                }
            }
        }
        return result;
    }

}
