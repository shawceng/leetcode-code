package dp;

public class HouseRobberII {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    int rob(int[] nums, int from, int to) {
        int a = 0, b = 0, c = nums[from];
        for (int i = from + 1; i < to; i++) {
            int t = nums[i] + Math.max(a, b);
            a = b;
            b = c;
            c = t;
        }
        return Math.max(b, c);
    }
}
