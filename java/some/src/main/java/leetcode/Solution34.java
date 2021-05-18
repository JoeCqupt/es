package leetcode;

public class Solution34 {

    public static void main(String[] args) {
        Solution34 solution34 = new Solution34();

        solution34.searchRange(new int[]{1,2,4,6,8} , 5);

    }
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int left1 = 0;
        int right1 = nums.length - 1;

        int left2 = 0;
        int right2 = nums.length - 1;


        while (left1 <= right1 || left2 <= right2) {

            if (left1 <= right1) {
                int mid1 = left1 + (right1 - left1) / 2;
                if (target <= nums[mid1]) {
                    right1 = mid1 - 1;
                } else {
                    left1 = mid1 + 1; // 找大于等于target的第一个数
                }
            }

            if (left2 <= right2) {
                int mid2 = left2 + (right2 - left2) / 2;
                if (target >= nums[mid2]) {
                    left2 = mid2 + 1;
                } else {
                    right2 = mid2 - 1; // 找小于等于target的第一个数
                }
            }
        }

        if (left1 >= nums.length || right2 < 0) {
            return result;
        }
        if (nums[left1] != target || nums[right2] != target) {
            return result;
        }

        result[0] = left1;
        result[1] = right2;
        return result;
    }
}
