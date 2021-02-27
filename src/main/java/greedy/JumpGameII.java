package greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) return 1;
        int step = 0;
        int left = 0, right = 0;

        while (left <= right) {
            step++;

            int oldRight = right;
            for (int i = left; i <= oldRight; i++) {
                right = Math.max(right, i + nums[i]);
                if (right >= nums.length - 1) return step;
            }
            left = oldRight;
        }
        return 0;
    }

    public int jump2(int[] nums) {
        int result = 0;
        int next = 0;
        int maxStep = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > next) {
                next = maxStep;
                result++;
            }
            maxStep = Math.max(maxStep, i + nums[i]);
        }
        return result;
    }
}
