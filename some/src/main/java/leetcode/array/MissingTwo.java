package leetcode.array;

import java.util.Arrays;

public class MissingTwo {

    public int[] missingTwo(int[] nums) {

        int n = nums.length + 2; // 这个数组的最大值

        int j = 0;  // n-1 出现次数
        int k = 0;  // n 次数

        for (int i = 0; i < nums.length; i++) {
            int index = nums[i];
            if (index <= 0) {
                index += n;
            }

            if (index == n) {
                k++;
                continue;
            }
            if (index == n - 1) {
                j++;
                continue;
            }

            nums[index - 1] -= n;
        }

        int[] result = new int[2];
        int resultIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value > 0) {
                result[resultIndex] = i + 1;
                resultIndex++;
            }
        }

        if (j == 0) {
            result[resultIndex] = n - 1;
            resultIndex++;
        }
        if (k == 0) {
            result[resultIndex] = n;
            resultIndex++;
        }

        return result;
    }

    public static void main(String[] args) {
        MissingTwo missingTwo = new MissingTwo();
        int[] param = new int[]{2,3};
        int[] result = missingTwo.missingTwo(param);
        System.out.println(Arrays.toString(result));
    }

}
