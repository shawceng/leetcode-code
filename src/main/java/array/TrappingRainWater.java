package array;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) return 0;

        int heightest = 0, len = height.length;
        for (int i = 0; i < len; i++)
            heightest = height[heightest] < height[i] ? i : heightest;

        int result = 0;
        for (int i = 0, peak = 0; i < heightest; i++) {
            if (height[i] > peak) peak = height[i];
            else result += peak - height[i];
        }

        for (int i = len - 1, peak = 0; i >= heightest; i--) {
            if (height[i] > peak) peak = height[i];
            else result += peak - height[i];
        }

        return result;
    }
}
