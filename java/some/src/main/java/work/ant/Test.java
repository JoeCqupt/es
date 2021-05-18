package work.ant;

/**
 * 蚂蚁二面 笔试题 要求bugfree
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode tree = test.getTree(preorder, inorder);
        System.out.println(tree);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode getTree(int[] preOrder, int[] inOrder) {
        // todo 校验参数的有效性

        TreeNode root = doGetTreeNode(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);

        return root;
    }

    // 递归创建TreeNode
    public TreeNode doGetTreeNode(int[] preOrder, int pStart, int pEnd,
                                  int[] inOrder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return new TreeNode(preOrder[pStart]);
        }
        if (pStart > pEnd) return null;

        //获取当前的root
        int rootVal = preOrder[pStart];
        TreeNode root = new TreeNode(rootVal);

        // 找到root节点在 中序遍历结果中的位置
        int mid = 0;
        for (int i = iStart; i <= iEnd; i++) {
            if (inOrder[i] == rootVal) {
                mid = i;
            }
        }

        // 获取左子树的数量，可以确定左边的前序遍历的范围
        int length = mid - iStart;
        // 开始递归
        root.left = doGetTreeNode(preOrder, pStart + 1, pStart + length, inOrder, iStart, mid - 1);
        root.right = doGetTreeNode(preOrder, pStart + length + 1, pEnd, inOrder, mid + 1, iEnd);
        return root;
    }
}
