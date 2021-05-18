package leetcode;

/**
 */
public class Solution81 {

    public static void main(String[] args) {
        Solution81 solution = new Solution81();
        boolean res = solution.search(
                new int[]{1, 0, 1, 1, 1},
                0
        );

        System.out.println(res);
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == nums[right]) {
                if (nums[left] == target) return true;
                left++;
                continue;
            }
            int mid = left + (right - left) / 2;
            int temp = nums[mid];
            if (temp == target) return true;

            if (temp > nums[right]) {
                if (target == nums[left]) return true;
                if (target < temp && target > nums[left]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target == nums[right]) return true;
                if (target > temp && target < nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}
