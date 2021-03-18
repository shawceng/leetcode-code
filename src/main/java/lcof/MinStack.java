package lcof;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack, minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack= new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (minStack.peek().equals(stack.pop())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
