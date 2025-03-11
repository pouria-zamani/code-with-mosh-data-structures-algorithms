package part1.queues;

import part1.stacks.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();
    private int top;

    // O(1)
    public void push(int item) {
        queue1.add(item);
        top = item;
    }

    //O(n)
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }

        swapQueues();

        return queue2.remove();
    }

    private void swapQueues() {
        var temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return top;
    }

    //O(1)
    public int size() {
        return queue1.size();
    }

    //O(1)
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        StackWithQueues stack = new StackWithQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack.toString());
        System.out.println("Last element of stack: " + stack.pop());

        System.out.println("Stack after pop: " + stack.toString());

    }
}
