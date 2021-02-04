package leetcode.primary.s4_tree;

/**
 * 事实证明这个算法很垃圾，
 */
public class LC101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        // 思路：把左子树做镜像翻转，然后比较一下是否和右子树相同
        TreeNode reverseLeft = reverse(root.left);
        boolean isSame = compareStruct(reverseLeft, root.right);
        // 如果有必要可以再把 左子树翻转回来
        return isSame;
    }

    private boolean compareStruct(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        boolean l = compareStruct(node1.left, node2.left);
        boolean r = true;
        if (l) {
            r = compareStruct(node1.right, node2.right);
        }
        return l & r;
    }

    private TreeNode reverse(TreeNode node) {
        if (node == null) {
            return null;
        }

        TreeNode rNode = reverse(node.left);
        TreeNode lNode = reverse(node.right);
        node.left = lNode;
        node.right = rNode;
        return node;
    }


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
}
