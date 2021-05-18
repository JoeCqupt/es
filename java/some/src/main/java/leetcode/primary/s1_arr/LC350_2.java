package leetcode.primary.s1_arr;

import java.util.Arrays;

public class LC350_2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] temp = new int[Math.min(nums1.length, nums2.length)];

        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] == nums2[index2]) {
                temp[i++] = nums1[index1];
                index1++;
                index2++;
            } else if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(temp, 0, i);
    }
}
