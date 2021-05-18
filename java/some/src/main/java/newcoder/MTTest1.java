package newcoder;

import java.util.ArrayList;
import java.util.List;

/**
 * 美团应届测开 笔试题
 */
public class MTTest1 {
    static class TreeNode {
        int idx; // 节点索引
        int val; // 节点阈值
        TreeNode left;
        TreeNode right;
    }
   static List<TreeNode>  canNotArriveList = new ArrayList<>();
    /**
     * @param root      当前节点
     * @param start     当前节点阈值可选范围起点
     * @param end       当前节点阈值可选单位终点
     * @param direction 方向：1 表示左子树  2 表示右子树
     */
    public static void surfing(TreeNode root, int start, int end, int direction) {
        if (root == null) return;
        if (root.val < end && direction == 1) {
            surfing(root.left, start, root.val, 1);
            surfing(root.right, root.val, end, 2);
        } else if (root.val >= start && direction == 2) {
            surfing(root.left, start, root.val, 1);
            surfing(root.right, root.val, end, 2);
        } else {
            // 表示该节点不在 可选阈值范围内，表示不可达节点
            canNotArriveList.add(root);
            return;
        }
    }

    public static void main(String[] args) {
        // step 1： 构建 tree ，读取行，并且利用dict缓存节点关系
        TreeNode root = null; //省略.....
        // step 2:
        surfing(root.left, Integer.MIN_VALUE, root.val, 1);
        surfing(root.right, root.val, Integer.MAX_VALUE, 2);
        // step 3: 遍历不能到达节点(canNotArriveList)和它的子节点
        for(TreeNode node: canNotArriveList){
            // 省略
        }
    }
}
