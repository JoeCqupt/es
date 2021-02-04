package leetcode.primary.s1_arr;


import java.util.Arrays;

public class LC189 {
    public static void main(String[] args) {
        LC189 so = new LC189();
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        so.rotate(
                arr
                , 3
        );

        System.out.println(Arrays.toString(arr));
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] temp = new int[k];
        System.arraycopy(nums, n - k, temp, 0, k);
        for (int i = n - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, k);
    }
}
