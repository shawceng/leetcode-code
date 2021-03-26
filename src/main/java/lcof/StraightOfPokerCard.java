package lcof;

import java.util.Arrays;

public class StraightOfPokerCard {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int zeroCnt = 0;
        for (; i < nums.length && nums[i] == 0; i++, zeroCnt++) ;
        for (i = i + 1; i < nums.length; i++) {
            while (nums[i] - nums[i - 1] > 1 && zeroCnt > 0) {
                nums[i - 1] += 1;
                zeroCnt--;
            }
            if (nums[i] == nums[i - 1] || nums[i] - nums[i - 1] > 1) return false;
        }
        return true;
    }
}
