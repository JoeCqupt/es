package leetcode;

public class Solution105 {

    public TreeNode buildTree(int[] preorder , int[] inorder){
        TreeNode root = null;
        for(int i = 0; i< preorder.length; i++){
            int pre = preorder[i];
            TreeNode node = new TreeNode(pre);
            if(i == 0){
                    
            }
        }
        // todo @joe
        return null;
    }


    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
