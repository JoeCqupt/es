package leetcode.offer;

public class Offer33 {

    public static void main(String[] args) {
        Offer33 o = new Offer33();
        o.verifyPostorder(
                new int[]{
                        4, 6, 7, 5
                }
        );
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) return true;
        int n = postorder.length;
        if (n <= 2) return true;

        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int start, int end) {
        if (start == end) {
            return true;
        }
        int root = postorder[end];
        int mark = 0;
        for (int i = start; i < end; i++) {
            if (postorder[i] > root) {
                break;
            } else {
                mark++;
            }
        }

        for (int j = start + mark; j < end; j++) {
            if (postorder[j] < root) return false;
        }

        if (mark == 0) {
            return verifyPostorder(postorder, start, end - 1);
        } else if (start + mark == end) {
            return verifyPostorder(postorder, start, start + mark - 1);
        } else {
            return verifyPostorder(postorder, start, start + mark - 1) &&
                    verifyPostorder(postorder, start + mark, end - 1);
        }

    }
}
