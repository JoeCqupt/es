package leetcode.primary.s3_linkedlist;

/**
 *  采用递归法 时间复杂度和空间复杂度都是 O(n)
 */
public class LC234 {

    public static void main(String[] args) {
        LC234 solution = new LC234();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;

        solution.isPalindrome(node1);

    }
    private ListNode headPos = null;

    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        headPos = head;
        return doPalindrome(head);
    }

    private boolean doPalindrome(ListNode pos) {
        boolean res = true;
        if (pos.next != null) {
            res = doPalindrome(pos.next);
        }
        if (!res) {
            return false;
        }
        if (pos.val != headPos.val) {
            return false;
        }

        if (pos == headPos || headPos.next == pos) {
            headPos = headPos.next;
            return true;
        }

        headPos = headPos.next;
        return true;
    }

    public static class ListNode {
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
}
