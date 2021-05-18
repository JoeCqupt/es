package leetcode.offer;

import java.util.Arrays;

public class Offer21 {
    public static void main(String[] args) {
        Offer21 offer21 = new Offer21();
        int[] exchange = offer21.exchange(
                new int[]
                        {2,16,3,5,13,1,16,1,12,18,11,8,11,11,5,1}        );

        System.out.println(Arrays.toString(exchange));
    }
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; ) {
            if (n - 1 - i == count) break;

            if (nums[i] % 2 == 1) {
                i++;
                continue;
            }

            int temp = nums[i];
            // array copy
            copy(nums, i, n - 2);
            nums[n - 1] = temp;
            count++;
        }

        return nums;
    }

    private void copy(int[] nums, int s, int e) {
        for (int i = s; i <= e; i++) {
            nums[i] = nums[i + 1];
        }
    }
}
