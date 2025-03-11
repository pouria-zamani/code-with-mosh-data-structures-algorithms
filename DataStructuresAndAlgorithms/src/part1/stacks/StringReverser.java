package part1.stacks;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        var stack = new Stack<Character>();

        for (char ch : input.toCharArray())
            stack.push(ch);

        StringBuffer reversed = new StringBuffer();
        while (!stack.isEmpty())
            reversed.append(stack.pop());

        return reversed.toString();
    }

    public static void main(String[] args) {
        String str = "abcd";
        StringReverser stringReverser = new StringReverser();

        System.out.println("reversed abcd: " + stringReverser.reverse(str));
    }
}
