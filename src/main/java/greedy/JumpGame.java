package greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int lastReach = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (lastReach <= nums[i] + i)
                lastReach = i;
        }
        return lastReach == 0;
    }
}
