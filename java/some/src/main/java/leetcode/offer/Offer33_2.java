package leetcode.offer;

import java.util.LinkedList;

public class Offer33_2 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) return true;
        int n = postorder.length;
        if (n <= 2) return true;


        LinkedList<Integer> stack = new LinkedList<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;
            while (!stack.isEmpty() && postorder[i] < stack.peek())
                root = stack.pop();

            stack.push(postorder[i]);
        }
        return true;
    }
}
