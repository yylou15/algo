package jianzhioffer.copyRandomList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node ptr = head;
        Node newHead = new Node(ptr.val), newPtr = newHead;
        map.put(head, newHead);

        while (ptr.next != null) {
            Node newNode = new Node(ptr.next.val);
            newPtr.next = newNode;
            map.put(ptr.next, newNode);

            ptr = ptr.next;
            newPtr = newPtr.next;
        }

        ptr = head;
        newPtr = newHead;
        while (ptr != null) {
            if (ptr.random != null) {
                System.out.println(ptr.val);
                newPtr.random = map.get(ptr.random);
            }
            ptr = ptr.next;
            newPtr = newPtr.next;
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            System.out.println(entry.getKey().val + ":" + entry.getValue().val);
        }
        return newHead;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        node.random = node1;
        node.next = node1;
        node1.random = node1;
        new Solution().copyRandomList(node);
    }
}