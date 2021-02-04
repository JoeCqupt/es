package leetcode;

/**
 * 二分查找的扩展，查找左侧边界
 */
public class Solution704_3 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target <= nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(start>= nums.length){
            return -1;
        }
        return nums[start] == target? start : -1;
    }
}
