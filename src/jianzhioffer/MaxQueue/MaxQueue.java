package jianzhioffer.MaxQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class MaxQueue {

    private Deque<Integer> deque = new ArrayDeque<>();
    private PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

    public MaxQueue() {

    }

    public int max_value() {
        return priorityQueue.peek();
    }

    public void push_back(int value) {
        priorityQueue.add(value);
        deque.push(value);
    }

    public int pop_front() {
        return deque.pop();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */