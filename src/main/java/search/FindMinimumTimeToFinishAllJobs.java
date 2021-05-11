package search;

import java.util.*;

public class FindMinimumTimeToFinishAllJobs {
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int low = Arrays.stream(jobs).max().getAsInt();
        int up = Arrays.stream(jobs).sum();

        Stack<Integer> stack = new Stack<>();
        for (int job : jobs) {
            stack.push(job);
        }

        while (low < up) {
            int mid = low + (up - low) / 2;
            if (isFinish((Stack<Integer>) stack.clone(), k, mid)) {
                up = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    boolean isFinish(Stack<Integer> stack, int k, int cap) {
        int[] map = new int[k];
        Arrays.fill(map, cap);
        return dfs(stack, map, cap);
    }

    boolean dfs(Stack<Integer> stack, int[] map, int cap) {
        if (stack.size() == 0) return true;
        int t = stack.pop();
        for (int i = 0; i < map.length; i++) {
            if (map[i] >= t) {
                map[i] -= t;
                if (dfs(stack, map, cap))
                    return true;
//                if (map[i] == 0) break;
                map[i] += t;
                if (map[i] == cap) break;
            }
        }
        stack.push(t);
        return false;
    }
}
