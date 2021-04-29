package leetcode;

public class Solution4_2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int l1 = nums1.length;
        int l2 = nums2.length;
        int total = l1 + l2;
        if (total % 2 == 1) {
            return doMidSearch(nums1, nums2, total / 2);
        } else {
            return (doMidSearch(nums1, nums2, total / 2 - 1) + doMidSearch(nums1, nums2, total / 2)) / 2;
        }
    }

    private double doMidSearch(int[] nums1, int[] nums2, int k) {

        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (index1 == nums1.length) {
                return nums2[index2 + k];
            }
            if (index2 == nums2.length) {
                return nums1[index1 + k];
            }
            if (k == 0) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // ps：特殊处理这一段
            if (k == 1) {
                if (nums1[index1] < nums2[index2]) {
                    index1++;
                } else {
                    index2++;
                }
                k--;
                continue;
            }

            int half = k / 2;

            int newIdx1 = Math.min(index1 + half - 1, nums1.length - 1);
            int newIdx2 = Math.min(index2 + half - 1, nums2.length - 1);

            if (nums1[newIdx1] < nums2[newIdx2]) {
                k -= (newIdx1 - index1 + 1);
                index1 = newIdx1 + 1;
            } else {
                k -= (newIdx2 - index2 + 1);
                index2 = newIdx2 + 1;
            }
        }
    }
}
