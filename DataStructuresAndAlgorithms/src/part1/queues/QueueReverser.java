package part1.queues;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println("queue before reverse: " + queue.toString());
        reverse(queue);
        System.out.println("queue after reverse: " + queue.toString());


        queue.add(4);
        queue.add(5);
        System.out.println("queue before reverse of the 3 elements: " + queue.toString());
        reverse(queue, 3);
        System.out.println("queue after reverse of the 3 elements: " + queue.toString());
    }

    public static void reverse(Queue<Integer> queue) {
        //add
        //remove
        //isEmpty
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    public static void reverse(Queue<Integer> queue, int k) {
        if (k < 0 || k > queue.size())
            throw new IllegalArgumentException();


        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++)
            stack.push(queue.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        for (int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());
    }
}
