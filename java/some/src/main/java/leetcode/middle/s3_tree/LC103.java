package leetcode.middle.s3_tree;

import java.util.*;

public class LC103 {

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return Collections.EMPTY_LIST;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int row = 1;
        int col = 1;

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int i = 0;
            int newCol = 0;
            List<Integer> list = new ArrayList<>();
            while (i < col) {
                TreeNode node;
                if (row % 2 == 1) {
                    node = queue.pollFirst();
                    if (node.left != null) {
                        queue.addLast(node.left);
                        newCol++;
                    }
                    if (node.right != null) {
                        queue.addLast(node.right);
                        newCol++;
                    }
                } else {
                    node = queue.pollLast();

                    if (node.right != null) {
                        queue.addFirst(node.right);
                        newCol++;
                    }
                    if (node.left != null) {
                        queue.addFirst(node.left);
                        newCol++;
                    }

                }
                list.add(node.val);
                i++;
            }
            row++;
            col = newCol;
            res.add(list);
        }
        return res;
    }
}
