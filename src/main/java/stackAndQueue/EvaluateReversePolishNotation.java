package stackAndQueue;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;
        for (String each:
             tokens) {
            if (is_operator(each)) {
                int a = stack[--top];
                if (each.equals("+")) stack[top - 1] += a;
                else if (each.equals("-")) stack[top - 1] -= a;
                else if (each.equals("*")) stack[top - 1] *= a;
                else if (each.equals("/")) stack[top - 1] /= a;
            } else {
                stack[top++] = Integer.parseInt(each);
            }
        }
        return stack[top - 1];
    }

    private boolean is_operator(String s) {
        return "+-*/".contains(s);
    }
}
