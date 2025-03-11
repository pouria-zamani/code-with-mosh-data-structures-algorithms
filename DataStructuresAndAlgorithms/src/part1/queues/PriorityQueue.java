package part1.queues;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int size;

    public PriorityQueue(int capacity) {
        items = new int[capacity];
    }

    public void add(int item) {
        if (isFull())
            throw new IllegalStateException();

        if (isFull())
            throw new IllegalStateException();

        var i = shiftItemsToInsert(item);
        items[i] = item;
        size++;
    }

    public int remove() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[--size];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = size - 1; i >= 0; i--) {
            if (items[i] > item)
                items[i + 1] = items[i];
            else
                break;
        }
        return i + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue(5);
        priorityQueue.add(5);
        priorityQueue.add(2);
        priorityQueue.add(4);
        priorityQueue.add(1);
        System.out.println("priority queue: " + priorityQueue);
        while (!priorityQueue.isEmpty())
            System.out.println(priorityQueue.remove());
    }
}
