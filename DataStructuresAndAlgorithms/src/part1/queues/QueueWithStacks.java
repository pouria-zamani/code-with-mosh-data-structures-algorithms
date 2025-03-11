package part1.queues;

import java.util.Stack;

public class QueueWithStacks {
    Stack<Integer> firstStack = new Stack<>();
    Stack<Integer> secondStack = new Stack<>();

    public void enqueue(int item) {
        firstStack.push(item);
    }

    public int dequeue() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return secondStack.pop();
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        moveStack1ToStack2();

        return secondStack.peek();
    }

    public boolean isEmpty() {
        return firstStack.isEmpty() && secondStack.isEmpty();
    }

    private void moveStack1ToStack2() {
        if (secondStack.isEmpty())
            while (!firstStack.isEmpty())
                secondStack.push(firstStack.pop());
    }

    public static void main(String[] args) {
        QueueWithStacks queue = new QueueWithStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        int first = queue.dequeue();
        System.out.println("first: " + first);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(5);
        queue.dequeue();
        int last = queue.dequeue();
        System.out.println("last: " + last);
    }
}
