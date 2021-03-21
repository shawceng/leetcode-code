package lcof;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        int[] map = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    if (map[j] == nums.length - i - 1) {
                        map[i] += map[j] + 1;
                        break;
                    }
                    map[i]++;
                } else if (nums[i] == nums[j]) {
                    map[i] += map[j];
                    break;
                }
            }
        }
        int count = 0;
        for (int e:
             map) {
            count += e;
        }
        return count;
    }
}
