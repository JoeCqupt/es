package leetcode.oi_wiki.basic;

import java.util.ArrayList;
import java.util.List;

public class DivideAndConquer {
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

    int res = 0;

    public int pathSum(TreeNode root, int sum) {
        doPathSum(root, sum);
        return res;
    }

    private List<Integer> doPathSum(TreeNode node, int sum) {
        if (node == null) {
            return null;
        }

        List<Integer> leftChoice = doPathSum(node.left, sum);

        List<Integer> rightChoice = doPathSum(node.right, sum);

        if (node.val == sum) res++;

        if (leftChoice == null && rightChoice == null) {
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            return list;
        } else if (leftChoice == null) {
            for (int i = 0; i < rightChoice.size(); i++) {
                Integer temp = rightChoice.get(i) + node.val;
                if (temp == sum) res++;
                rightChoice.set(i, temp);
            }
            rightChoice.add(node.val);
            return rightChoice;
        } else if (rightChoice == null) {
            for (int i = 0; i < leftChoice.size(); i++) {
                Integer temp = leftChoice.get(i) + node.val;
                if (temp == sum) res++;
                leftChoice.set(i, temp);
            }
            leftChoice.add(node.val);
            return leftChoice;
        } else {
            // both not null
            for (int i = 0; i < rightChoice.size(); i++) {
                Integer temp = rightChoice.get(i) + node.val;
                if (temp == sum) res++;
                rightChoice.set(i, temp);
            }
            for (int i = 0; i < leftChoice.size(); i++) {
                Integer temp = leftChoice.get(i) + node.val;
                if (temp == sum) res++;
                leftChoice.set(i, temp);
            }
            leftChoice.addAll(rightChoice);
            leftChoice.add(node.val);
            return leftChoice;
        }
    }

}
