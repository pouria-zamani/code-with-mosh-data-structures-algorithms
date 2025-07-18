package part1.stacks;

import java.util.Arrays;

public class TwoStacks {
    private int top1;
    private int top2;
    private int[] items;

    public TwoStacks(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity must be 1 or greater.");

        items = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    public void push1(int item) {
        if (isFull1())
            throw new IllegalStateException();

        items[++top1] = item;
    }

    public int pop1() {
        if (isEmpty1())
            throw new IllegalStateException();

        return items[top1--];
    }

    public boolean isEmpty1() {
        return top1 == -1;
    }

    public boolean isFull1() {
        return top1 + 1 == top2;
    }

    public void push2(int item) {
        if (isFull2())
            throw new IllegalStateException();

        items[--top2] = item;
    }

    public int pop2() {
        if (isEmpty2())
            throw new IllegalStateException();

        return items[top2++];
    }

    public boolean isEmpty2() {
        return top2 == items.length;
    }

    public boolean isFull2() {
        return top2 - 1 == top1;
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    public static void main(String[] args) {
        TwoStacks twoStacks = new TwoStacks(4);
        twoStacks.push1(1);
        twoStacks.push1(2);
        twoStacks.push1(3);
        twoStacks.push2(4);
        System.out.println("two stacks: " + twoStacks.toString());
        System.out.println("last item of stack1: " + twoStacks.pop1());
        System.out.println("two stacks after pop1: " + twoStacks.toString());
    }
}
