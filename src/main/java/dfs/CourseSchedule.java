package dfs;

import java.util.*;

public class CourseSchedule {
    Map<Integer, List<Integer>> map;
    int[] visited;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        visited = new int[numCourses];
        map = new HashMap<>(n);
        for (int[] e :
                prerequisites) {
            List<Integer> v = map.getOrDefault(e[0], new ArrayList());
            map.put(e[0], v);
            v.add(e[1]);
        }

        for (int key :
                map.keySet()) {
            if (!dfs(visited, key))
                return false;
        }
        return true;
    }

    boolean dfs(int[] visited, int key) {
        if (visited[key] == 2) return true;
        if (visited[key] == 1) return false;
        visited[key] = 1;

        List<Integer> pres = map.get(key);
        boolean r = true;
        for (int pre :
                pres) {
            if (map.containsKey(pre)) {
                r &= dfs(visited, pre);
            }
        }
        if (r) {
            visited[key] = 2;
        }
        return r;
    }
}
