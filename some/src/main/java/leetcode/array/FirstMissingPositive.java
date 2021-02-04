package leetcode.array;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (index > nums.length) {
                continue;
            }
            if (nums[index - 1] < 0) {
                continue;
            } else {
                nums[index - 1] = 0 - nums[index - 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive = new FirstMissingPositive();
        int[] inputs = new int[]{3, 4, -1, 1};
        int i = firstMissingPositive.firstMissingPositive(inputs);
        System.out.println(i);
    }

}