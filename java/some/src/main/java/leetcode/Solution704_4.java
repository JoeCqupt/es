package leetcode;

/**
 * 二分查找的扩展，查找右侧边界
 */
public class Solution704_4 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (end < 0) {
            return -1;
        }
        return nums[end] == target ? end : -1;
    }
}
