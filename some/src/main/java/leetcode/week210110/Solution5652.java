package leetcode.week210110;


public class Solution5652 {

    public static void main(String[] args) {
        Solution5652 solution = new Solution5652();
        ListNode list = genNodeList(new int[]{1, 2});
        solution.swapNodes(
                list,
                1
        );
    }

    private static ListNode genNodeList(int[] ints) {
        ListNode head = null;
        ListNode pre = null;
        for (int i = 0; i < ints.length; i++) {
            ListNode t = new ListNode(ints[i]);
            if (i == 0) {
                head = t;
            }

            if (pre != null) {
                pre.next = t;
            }
            pre = t;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode nodeK = null;

        ListNode nodeTailK = null;

        ListNode preK = null;
        ListNode pos = head;
        for (int i = 1; pos != null; i++) {
            ListNode next = pos.next;
            if (i == k) {
                nodeK = pos;
                preK = head;
            }
            if (i > k) {
                preK = preK.next;
            }
            pos = next;
        }

        nodeTailK = preK;

        if (nodeK == nodeTailK) {
            return head;
        }
        int temp = nodeK.val;
        nodeK.val = nodeTailK.val;;
        nodeTailK.val = temp;
        return head;
    }


}
