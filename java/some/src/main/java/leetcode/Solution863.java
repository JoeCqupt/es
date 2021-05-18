package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 和官方解答思路的第二种是一样的
 *
 * 官方还有一种，空间换时间的解法：https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/solution/er-cha-shu-zhong-suo-you-ju-chi-wei-k-de-jie-dian-/
 */
public class Solution863 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode0 = new TreeNode(0);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode0.right = treeNode1;
        treeNode1.right = treeNode2;
        treeNode2.right = treeNode3;
        Solution863 solution863 = new Solution863();
        List<Integer> integers = solution863.distanceK(treeNode0, treeNode1, 2);
        System.out.println(integers);
    }

    List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (K == 0) {
            result.add(target.val);
            return result;
        }
        findDownN(target, 1, K);
        traverse(root, target, K);
        return result;
    }

    private int traverse(TreeNode node, TreeNode target, int k) {
        if (node == null) {
            // 表示没有找到
            return -1;
        }
        if (node.val == target.val) {
            // 表示找到了
            return 1;
        }

        int left = traverse(node.left, target, k);
        int right = traverse(node.right, target, k);


        if (left == -1 && right == -1) {
            // 两边都没有找到
            return -1;
        } else if (left == k || right == k) {
            result.add(node.val);
            return -1;
        } else if (left > 0) {
            // 能向下搜索结果
            findDown(node.right, k - left - 1);
            return left + 1;
        } else {
            findDown(node.left, k - right - 1);
            return right + 1;
        }
    }

    private void findDown(TreeNode node, int i) {
        if (node == null) {
            return;
        }
        if (i < 0) {
            return;
        }
        if (i == 0) {
            result.add(node.val);
            return;
        }
        findDownN(node, 1, i);
    }

    private void findDownN(TreeNode node, int i, int N) {
        if (node == null) {
            return;
        }
        if (i == N) {
            if (node.left != null) {
                result.add(node.left.val);
            }
            if (node.right != null) {
                result.add(node.right.val);
            }
            return;
        }
        findDownN(node.left, i + 1, N);
        findDownN(node.right, i + 1, N);
    }

}
