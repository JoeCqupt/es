package leetcode.offer;

public class Offer07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        return buildNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildNode(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return new TreeNode(preorder[pStart]);
        }
        int value = preorder[pStart];
        TreeNode node = new TreeNode(value);
        int temp = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inorder[i] == value) {
                temp = i;
            }
        }
        int leftW = temp - iStart;
        if (leftW > 0)
            node.left = buildNode(preorder, pStart + 1, pStart + leftW, inorder,
                    iStart, temp - 1);

        int rightW = iEnd - temp;
        if (rightW > 0)
            node.right = buildNode(preorder, pStart + leftW + 1, pEnd, inorder,
                    temp + 1, iEnd);

        return node;
    }
}
