package leetcode.offer;


public class Offer25 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode pos =  null;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                if (newHead == null) {
                    newHead = l2;
                } else {
                    pos.next = l2;
                }
                break;
            } else if (l2 == null) {
                if (newHead == null) {
                    newHead = l1;
                } else {
                    pos.next = l1;
                }
                break;
            } else {
                if (l1.val > l2.val) {
                    ListNode old = l2;
                    l2 = l2.next;
                    if (newHead == null) {
                        newHead = old;
                        pos = old;
                    } else {
                        pos.next = old;
                        pos = pos.next;
                    }

                } else {
                    ListNode old = l1;
                    l1 = l1.next;
                    if (newHead == null) {
                        newHead = old;
                        pos = old;
                    } else {
                        pos.next = old;
                        pos = pos.next;
                    }
                }
            }
        }
        return newHead;
    }
}
