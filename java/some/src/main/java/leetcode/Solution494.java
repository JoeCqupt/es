package leetcode;

/**
 * 回溯算法
 */
public class Solution494 {

    public static void main(String[] args) {
        Solution494 solution = new Solution494();
        int res = solution.findTargetSumWays(
                new int[]{1, 1, 1, 1, 1},
                3
        );
        System.out.println(res);
    }

    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 1) {
            return nums[0] == S || -nums[0] == S ? 1 : 0;
        }
        int v1 = tryFind(nums[0], nums, 1, S);
        int v2 = tryFind(-nums[0], nums, 1, S);
        return v1 + v2;
    }

    private int tryFind(int total, int[] nums, int i, int target) {
        if (i == nums.length - 1) {
            // 最后一个数字
            int result = 0;
            if (total + nums[i] == target) result++;
            if (total - nums[i] == target) result++;
            return result;
        }
        int v1 = tryFind(total + nums[i], nums, i + 1, target);
        int v2 = tryFind(total - nums[i], nums, i + 1, target);
        return v1 + v2;
    }

}
