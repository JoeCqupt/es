package leetcode;

public class Solution4 {
    /**
     * 垃圾实现时间复杂度 O(m+n)
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;


        int total = m + n;
        boolean isDouble = total % 2 == 0 ? true : false;
        int mid = total / 2;

        int midValue = 0;
        int preMidValue = 0;

        int n1 = 0;
        int n2 = 0;
        while (n1 < nums1.length || n2 < nums2.length) {
            int value1;
            int value2;
            if(n1==nums1.length) value1 = Integer.MAX_VALUE;
            else value1 = nums1[n1];

            if(n2 == nums2.length) value2 = Integer.MAX_VALUE;
            else value2 = nums2[n2];


            if (n1 + n2 <mid) {
                if (value1 < value2) {
                    preMidValue = value1;
                    n1++;
                }else {
                    preMidValue = value2;
                    n2++;
                }
            }else {
                midValue = value1<value2? value1:value2;
                break;
            }
        }

        return isDouble? (preMidValue+midValue)/2.0 : midValue;
    }
}
