package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    /**
     * 使用 遍历 + 递减的思想
     *
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        int m = 0;
        for (int i = 0; i < n; i++) {
            int index = nums[i];
            if (index <= 0) {
                index += n;
            }
            if (index == n) {
                m++;
                if (m == 2) {
                    result.add(n);
                }
                continue;
            }
            if (nums[index] <= 0) {
                result.add(index);
            } else {
                nums[index] -= n;
            }
        }


        return result;
    }

    public static void main(String[] args) {
        FindDuplicates findDuplicates = new FindDuplicates();
        int[] nums = new int[]{5, 4, 6, 7, 9, 3, 10, 9, 5, 6};
        List<Integer> duplicates = findDuplicates.findDuplicates(nums);
        System.out.println(duplicates);
    }
}