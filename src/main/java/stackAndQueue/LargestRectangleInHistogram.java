package stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        int[] stack = new int[len];
        int top = 0;
        int max = 0;

        for (int i = 0; i < len; ) {
            if (top < 1 || heights[stack[top - 1]] < heights[i]) {
                stack[top++] = i++;
            }  else {
                int tmp = stack[--top];
                int step = top < 1 ? i : i - stack[top - 1] - 1;
                max = Math.max(max, step * heights[tmp]);
            }
        }

        while (top > 0) {
            int tmp = stack[--top];
            int step = top > 0 ? len - stack[top - 1] - 1 : len;
            max = Math.max(max, step * heights[tmp]);
        }
        return max;
    }

}
