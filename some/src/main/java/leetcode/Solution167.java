package leetcode;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp > target) {
                right--;
            } else if (temp < target) {
                left++;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                return result;
            }
        }
        return result;
    }
}
