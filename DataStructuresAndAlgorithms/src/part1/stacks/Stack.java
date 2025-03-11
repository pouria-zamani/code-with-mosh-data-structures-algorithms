package part1.stacks;

import java.util.Arrays;

public class Stack {
    private int[] items = new int[8];
    int size;

    public void push(int item) {
        if (size == items.length)
            throw new StackOverflowError();

//        resizeIfRequired();

        items[size++] = item;
    }

    public int pop() {
        if (size == 0)
            throw new IllegalStateException();

        return items[--size];
    }

    public int peek() {
        if (size == 0)
            throw new IllegalStateException();

        return items[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(items, 0, size);
        return Arrays.toString(content);
    }

    private void resizeIfRequired() {
        if (items.length == size) {
            int[] newItems = new int[size * 2];

            for (int i = 0; i < size; i++)
                newItems[i] = items[i];

            items = newItems;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Stack: " + stack.toString());
        System.out.println("Last element of stack: " + stack.pop());

        System.out.println("Stack after pop: " + stack.toString());

    }
}
