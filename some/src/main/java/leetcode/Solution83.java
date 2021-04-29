package leetcode;

public class Solution83 {



    public class ListNode {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = null;
        ListNode pos = head;

        while (pos != null) {
            if (pre != null && pre.val == pos.val) {
                pre.next = pos.next;
            } else {
                pre = pos;
            }
            pos = pos.next;
        }

        return head;
    }
}
