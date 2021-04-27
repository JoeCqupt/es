package leetcode;

public class Solution4_2 {

    public static void main(String[] args) {
        Solution4_2 solution = new Solution4_2();

        double res = solution.findMedianSortedArrays(
                new int[]{1, 3},
                new int[]{2, 4}
        );
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        if (total % 2 == 1) {
            // 奇数
            return midSearch(nums1, nums2, total / 2);
        } else {
            // 偶数
            return (midSearch(nums1, nums2, total / 2 - 1) + midSearch(nums1, nums2, total / 2)) / 2;
        }
    }

    private double midSearch(int[] nums1, int[] nums2, int i) {
        int n1 = 0;
        int n2 = 0;
        while (true) {
            if (n1 == nums1.length) {
                return nums2[n2 + i];
            }

            if (n2 == nums2.length) {
                return nums1[n1 + i];
            }

            if (i == 0) {
                return Math.min(nums1[n1], nums2[n2]);
            }

            if (i == 1) {
                if (nums1[n1] < nums2[n2]) {
                    n1++;
                } else {
                    n2++;
                }
                i--;
                continue;
            }


            int half = i / 2;
            int new1 = Math.min(n1 + half - 1, nums1.length - 1); // ps 这里要减去一，因为要包括当前的idx值
            int new2 = Math.min(n2 + half - 1, nums2.length - 1);
            if (nums1[new1] < nums2[new2]) {
                i -= (new1 - n1 + 1);
                n1 = new1 + 1;
            } else {
                i -= (new2 - n2 + 1);
                n2 = new2 + 1;
            }
        }
    }
}
