package leetcode;


import java.util.HashMap;
import java.util.Map;

public class Solution437 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);

        return dfs(cache, root, sum, 0);
    }

    private int dfs(Map<Integer, Integer> cache, TreeNode node, int sum, int rootVal) {
        if (node == null) {
            return 0;
        }
        int val = node.val + rootVal;

        // val - x = sum
        int res = cache.getOrDefault(val - sum, 0);

        cache.put(val, cache.getOrDefault(val, 0) + 1);


        int left = dfs(cache, node.left, sum, val);
        int right = dfs(cache, node.right, sum, val);

        cache.put(val, cache.get(val) - 1);

        return res + left + right;
    }

}
