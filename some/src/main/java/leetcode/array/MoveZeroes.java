package leetcode.array;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums == null) return;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        i++;
                    }
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(data);

        System.out.println(Arrays.toString(data));
    }
}