package dp;

public class HouseRobber {
    public int rob(int[] nums) {
        int a = 0, b = 0, c = 0;

        for (int i = 0; i < nums.length; i++) {
            int d = Math.max(a, b) + nums[i];
            a = b;
            b = c;
            c = d;
        }
        return Math.max(b, c);
    }
}
