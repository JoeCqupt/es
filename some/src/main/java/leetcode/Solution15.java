package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution15 {

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum(new int[]{
                -1, 0, 1, 2, -1, -4
        });
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int target = 0 - nums[i];
            List<List<Integer>> lists = twoSum(nums, i + 1, n - 1, target);
            if (!lists.isEmpty()) {
                for (List<Integer> list : lists) {
                    list.add(nums[i]);
                    result.add(list);
                }
            }
            while (i + 1 < n && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return result;
    }

    public List<List<Integer>> twoSum(int[] nums, int left, int right, int sum) {
        if (left == right) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp > sum) {
                while (right - 1 >= left && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
            } else if (temp < sum) {
                while (left + 1 <= right && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;
            } else {
                // 表示找到了
                ArrayList<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                result.add(list);
                while (left + 1 <= right && nums[left + 1] == nums[left]) {
                    left++;
                }
                left++;
                while (right - 1 >= left && nums[right - 1] == nums[right]) {
                    right--;
                }
                right--;
            }
        }
        return result;
    }

}
