package leetcode;

/**
 * 典型的二分查找方法
 *
 * 递归写法
 */
public class Solution704 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;


        return doSearch(nums, start, end, target);

    }

    private int doSearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > target) {
            return doSearch(nums, start, mid - 1, target);
        }
        return doSearch(nums, start + 1, end, target);
    }
}
