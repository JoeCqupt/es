package leetcode.middle.s3_tree;

/**
 * ac
 */
public class LC105 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildNode(preorder, 0, preorder.length - 1, inorder, 0, preorder.length - 1);
    }

    private TreeNode buildNode(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int value = preorder[preStart];
        TreeNode node = new TreeNode(value);
        // 在中序遍历中找value的值，去确定左右子树的范围
        int temp = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == value) {
                temp = i;
                break;
            }
        }
        int leftWide = temp - inStart;
        node.left = leftWide == 0 ? null : buildNode(preorder, preStart + 1, preStart + leftWide,
                inorder, inStart, temp - 1);

        int rightWide = inEnd - temp;
        node.right = rightWide == 0 ? null : buildNode(preorder, preStart + leftWide + 1, preEnd, inorder, temp + 1, inEnd);
        return node;
    }


}
