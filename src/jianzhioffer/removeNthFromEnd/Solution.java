package jianzhioffer.removeNthFromEnd;

import util.ListNode;

public class Solution {
    private int count = 0;
    private int n;
    private ListNode node;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        this.n = n;
        return remove(head, true) ? this.node : head;
    }

    private boolean remove(ListNode node, boolean flag) {
        if (node.next != null) {
            remove(node.next, false);
        }
        count++;
        System.out.println(count);
        if (count == this.n && flag) {
            this.node = node.next;
            return true;
        } else if (count == this.n + 1) {
            node.next = node.next.next;
        }
        return false;
    }


}