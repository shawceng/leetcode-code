package greedy;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int from = 0, to = height.length - 1;
        int result = 0;
        while (from < to) {
            int area = Math.min(height[from], height[to]) * (to - from);
            result = Math.max(result, area);
            if (height[from] < height[to]) {
                from++;
            } else if (height[from] > height[to]) {
                to--;
            } else {
                to--;
                from++;
            }
        }
        return result;
    }
}
