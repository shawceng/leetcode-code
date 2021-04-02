package lcci;

public class VolumeOfHistogram {
    public int trap(int[] height) {






        int heightest = 0;
        for (int i = 0; i < height.length; i++) {
            heightest = height[heightest] < height[i] ? i : heightest;
        }

        int res = 0;
        for (int i = 0, peak = 0; i < heightest; i++) {
            if (peak < height[i]) {
                peak = height[i];
            }
            res += peak - height[i];
        }

        for (int i = height.length - 1, peak = 0; i > heightest; i--) {
            if (peak < height[i]) {
                peak = height[i];
            }
            res += peak - height[i];
        }

        return res;
    }
}
