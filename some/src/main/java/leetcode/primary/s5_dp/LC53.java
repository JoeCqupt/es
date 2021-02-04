package leetcode.primary.s5_dp;

public class LC53 {


    public static void main(String[] args) {
        LC53 solution = new LC53();
        int res = solution.maxSubArray(
                new int[]{
                        1, 2
                }
        );
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int tempMin = Math.min(0, nums[0]);
        int tempCount = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tempCount = nums[i] + tempCount;
            max = Math.max(max, tempCount - tempMin);
            tempMin = Math.min(tempCount, tempMin);
        }

        return max;
    }
}
