package leetcode.primary.s1_arr;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LC350 {
    public static void main(String[] args) {
        LC350 soulution = new LC350();

        soulution.intersect(
                new int[]{1, 2, 2, 1},
                new int[]{2, 2}
        );
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] temp = new int[nums1.length];
        int t = 0;
        for (int i : nums2) {
            Integer value = map.getOrDefault(i, 0);
            if (value > 0) {
                temp[t++] = i;
                map.put(i, --value);
            }
        }
        return Arrays.copyOfRange(temp, 0, t);
    }
}
