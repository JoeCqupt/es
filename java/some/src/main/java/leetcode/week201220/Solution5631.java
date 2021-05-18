package leetcode.week201220;

/**
 *  超时
 */
public class Solution5631 {

    public static void main(String[] args) {
        Solution5631 solution5631 = new Solution5631();
        int result = solution5631.maxResult(
                new int[]{
                        1, -1, -2, 4, -7, 3
                },
                2
        );
        System.out.println(result);
    }

    public int maxResult(int[] nums, int k) {
        int[] dpTable = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                dpTable[i] = nums[0];
                continue;
            }

            int max = dpTable[i - 1];
            for (int m = i - 1; m >= i - k && m>=0; m--) {
                max = Math.max(max, dpTable[m]);
            }
            dpTable[i] = max + nums[i];

        }
        return dpTable[nums.length - 1];
    }

}
