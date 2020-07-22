package dailyKill;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LRU {
    Node head, tail;
    Map<Integer, Node> map = new HashMap<>();
    int size = 0;
    int cap = 10;

    public Integer get(int idx) {
        if(!map.containsKey(idx)){
            return null;
        }

        Node node = map.get(idx);
        node.pre.next = node.next;
        node.next.pre = node.pre;
        head.next = node;
        node.pre = head;
        head = head.next;
        return node.val;
    }

    public void add(Integer integer) {
        if (head == null && size > 0) {
            head = new Node(integer);
            tail = head;
            map.put(integer, head);
            size++;
        }

        if (size >= cap) {
            tail.next.pre= null;

            tail = tail.next;

        }

        if (!map.containsKey(integer)) {
            head.next = new Node(integer);
            head = head.next;
            size++;
            map.put(integer,head);
        }
    }

}

class Node {
    int val;
    Node pre;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
