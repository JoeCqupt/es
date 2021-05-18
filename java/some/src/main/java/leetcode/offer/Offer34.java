package leetcode.offer;

import java.util.ArrayList;
import java.util.List;

public class Offer34 {

    public class TreeNode {
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

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int target, int prefix,
                     List<Integer> preList) {
        if (root == null) {
            return;
        }
        int value = root.val + prefix;
        preList.add(root.val);
        if(value == target&& root.left==null && root.right == null){
            res.add(new ArrayList<>(preList));
        }
        dfs(root.left, res, target, value, preList);
        dfs(root.right, res, target, value, preList);
        preList.remove(preList.size()-1); //移除最后一个元素
    }
}