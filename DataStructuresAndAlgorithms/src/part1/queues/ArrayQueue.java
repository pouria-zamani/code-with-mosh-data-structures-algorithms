package part1.queues;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
    }

    public void enqueue(int item)  {
        if(isFull())
            throw new IllegalStateException();

        items[rear] = item;
        rear = (rear + 1) % items.length;
        size++;
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();


        var item = items[front];
        items[front] = 0;
        front = (front + 1) % items.length;
        size--;

        return item;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return items[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("queue: " + queue.toString());
        queue.dequeue();
        System.out.println("queue after dequeue: " + queue.toString());
    }
}
