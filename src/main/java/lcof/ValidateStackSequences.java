package lcof;

import java.util.Stack;

public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n = 0, m = 0;
        for (int e :
                pushed) {
            pushed[n] = e;
            while (n >= 0 && popped[m] == pushed[n]) {
                m++;
                n--;
            }
            n++;
        }
        return n == 0;
    }
}
