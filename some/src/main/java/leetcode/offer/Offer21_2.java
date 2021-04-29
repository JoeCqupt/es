package leetcode.offer;

import java.util.Arrays;

public class Offer21_2 {

    public static void main(String[] args) {
        Offer21_2 o = new Offer21_2();
        int[] exchange = o.exchange(
                new int[]
                        {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1}
        );
        System.out.println(Arrays.toString(exchange));
    }

    public int[] exchange(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return nums;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            while (l < r && (nums[l] & 1) == 1) {
                l++;
            }
            while (l < r && (nums[r] & 1) == 0) {
                r--;
            }
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
}
