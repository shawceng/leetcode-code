package dp;

import java.util.Arrays;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int a = 0, b = 0;
        int pre = -1, cur = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur != nums[i]) {
                int c = 0;
                if (cur != pre + 1) {
                    c = cur * count + b;
                } else {
                    c = Math.max(b, a + cur * count);
                }
                a = b;
                b = c;
                count = 0;
                pre = cur;
                cur = nums[i];
            }
            count++;
        }

        int c = 0;
        if (cur != pre + 1) {
            c = cur * count + b;
        } else {
            c = Math.max(b, a + cur * count);
        }
        return c;
    }
}
