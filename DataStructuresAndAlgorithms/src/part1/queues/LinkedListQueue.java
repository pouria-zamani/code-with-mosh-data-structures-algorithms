package part1.queues;

import java.util.LinkedList;

public class LinkedListQueue {
    private LinkedList<Integer> list = new LinkedList<>();

    public void enqueue(int item) {
        list.add(item);
    }

    public int dequeue() {
        int first = list.getFirst();
        list.remove(0);
        return first;
    }

    public int peek() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("queue: " + queue.toString());
        queue.dequeue();
        System.out.println("queue after dequeue: " + queue.toString());
    }
}
