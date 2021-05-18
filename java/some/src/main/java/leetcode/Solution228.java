package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
    public static void main(String[] args) {

    }

    public List<String> summaryRanges(int[] nums) {
        // 条件： 有序 无重复的数组
        List<String> res = new ArrayList<>();

        for (int i = 0; i < nums.length; ) {
            int j = i + 1;
            while (j < nums.length) {
                if ((nums[i] + j - i) == nums[j]) {
                    j++;
                } else {
                    break;
                }
            }
            if (j - 1 == i) {
                res.add(String.valueOf(nums[i]));
            } else {
                res.add(nums[i] + "->" + nums[j - 1]);
            }
            i = j;
        }
        return res;
    }
}
