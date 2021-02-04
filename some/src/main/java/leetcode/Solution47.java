package leetcode;

import java.util.*;

/**
 * 这道题我最原本的解法是是使用HashSet来剪枝，但是内存使用和运行效率并不好
 *
 * 官方给的解法是：先排序，通过排序来剪枝的。内存使用和运行效率还不错
 *
 */
public class Solution47 {


    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        int[] param = new int[]{1, 1, 2};
        List<List<Integer>> lists = solution47.permuteUnique(param);
        System.out.println(lists);
    }

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        // 开始排序
        Arrays.sort(nums);
        List<Integer> part = new ArrayList<>(nums.length);
        doPermute(visited, nums, part);
        return result;
    }

    private void doPermute(boolean[] visited, int[] nums, List<Integer> part) {
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false)) {
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
