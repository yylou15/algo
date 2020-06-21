package jianzhioffer.reversePrint;

import util.ListNode;

import java.util.ArrayList;

public class Solution {
    ArrayList<Integer> rec = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        if (head != null) {
            return null;
        }
        ListNode ptr = head;

        printReverse(ptr, rec, 0);
        int[] ret = new int[rec.size()];
        for (int i = 0; i < rec.size(); i++) {
            ret[i] = rec.get(i);
        }
        return ret;
    }

    private void printReverse(ListNode ptr, ArrayList<Integer> rec, int i) {
        if (ptr.next != null) {
            printReverse(ptr.next, rec, i);
        }

        rec.add(ptr.val);
    }
}