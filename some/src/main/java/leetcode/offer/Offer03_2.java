package leetcode.offer;

public class Offer03_2 {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            while (value != i) {
                if (value == nums[value]) {
                    return value;
                }
                int temp = nums[value];
                nums[value] = value;
                nums[i] = temp;
            }
        }

        return -1;
    }
}
