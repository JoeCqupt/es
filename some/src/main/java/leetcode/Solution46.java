package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        List<Integer> part = new ArrayList<>(nums.length);
        doPermute(visited, nums, part);
        return result;
    }

    private void doPermute(boolean[] visited, int[] nums, List<Integer> part) {
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            } else {
                visited[i] = true;
                part.add(nums[i]);
                doPermute(visited, nums, part);

                // 处理遍历完的情况
                if (part.size() == nums.length) {
                    result.add(new ArrayList<>(part));
                }

                visited[i] = false;
                // 移除最后一个元素
                part.remove(part.size() - 1);
            }
        }
    }
}
