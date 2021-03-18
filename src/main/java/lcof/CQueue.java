package lcof;

import java.util.Stack;

public class CQueue {
    Stack<Integer> m, s;

    public CQueue() {
        m = new Stack();
        s = new Stack();
    }

    public void appendTail(int value) {
        m.push(value);
    }

    public int deleteHead() {
        if (m.isEmpty() && s.isEmpty()) return -1;
        if (!s.isEmpty()) return s.pop();
        while (!m.isEmpty()) {
            s.push(m.pop());
        }
        return s.pop();
    }
}
