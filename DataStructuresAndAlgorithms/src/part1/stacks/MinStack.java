package part1.stacks;

public class MinStack {
    private Stack stack = new Stack();
    private Stack minStack = new Stack();

    public void push(int item) {
        stack.push(item);

        if (minStack.isEmpty())
            minStack.push(item);
        else if (item < minStack.peek())
            minStack.push(item);
    }

    public int pop() {
        if (stack.isEmpty())
            throw new IllegalStateException();

        var top = stack.pop();

        if (minStack.peek() == top)
            minStack.pop();

        return top;
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(6);
        minStack.push(1);
        minStack.push(2);
        minStack.push(8);
        minStack.push(4);
        System.out.println("stack min: " + minStack.min());
        System.out.println("stack pops: " + minStack.pop());
        System.out.println("stack min: " + minStack.min());
        System.out.println("stack pops: " + minStack.pop());
        System.out.println("stack min: " + minStack.min());
        System.out.println("stack pops: " + minStack.pop());
        System.out.println("stack min: " + minStack.min());
        System.out.println("stack pops: " + minStack.pop());
        System.out.println("stack min: " + minStack.min());
        System.out.println("stack pops: " + minStack.pop());
        System.out.println("stack min: " + minStack.min());
        System.out.println("stack pops: " + minStack.pop());
        System.out.println("stack min: " + minStack.min());
    }
}
