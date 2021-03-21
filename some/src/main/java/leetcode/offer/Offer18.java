package leetcode.offer;

public class Offer18 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(-3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(-99);
        n1.next = n2; n2.next = n3;

        Offer18 o = new Offer18();
        o.deleteNode(n1, -99);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null;
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val == val) {
                if (p == head) {
                    head = p.next;
                    break;
                } else {
                    pre.next = p.next;
                    break;
                }
            } else {
                pre = p;
            }
        }
        return head;
    }

}
