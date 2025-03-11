package part1.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {
    private final List<Character> leftBrackets
            = Arrays.asList('(', '<', '[', '{');
    private final List<Character> rightBrackets
            = Arrays.asList(')', '>', ']', '}');

    public boolean isBalanced(String input) {
        Stack<Character> expression = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch))
                expression.push(ch);

            if (isRightBracket(ch)) {
                if (expression.empty()) return false;

                var top = expression.pop();
                if (!bracketsMatch(top, ch)) return false;
            }
        }

        return expression.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBrackets.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBrackets.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return leftBrackets.indexOf(left) == rightBrackets.indexOf(right);
    }

    public static void main(String[] args) {
        Expression expression = new Expression();
        String expression1 = "(1(1(2)<2>()))";
        String expression2 = "(<]";
        System.out.println("Expression: " + expression1);
        System.out.println("is balanced: " + expression.isBalanced(expression1));
        System.out.println("Expression: " + expression2);
        System.out.println("is balanced: " + expression.isBalanced(expression2));
    }
}
