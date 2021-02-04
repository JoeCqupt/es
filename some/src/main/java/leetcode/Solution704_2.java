package leetcode;

/**
 * 标准的二分查找模版， 考虑以下几点：
 * 为什么是 start <= end
 *
 * 方法的有所局限，如果数组中含有重复的target元素，我们没办法找到第一个出现的target元素
 *
 */
public class Solution704_2 {

    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            }
        }

        return -1;
    }
}
