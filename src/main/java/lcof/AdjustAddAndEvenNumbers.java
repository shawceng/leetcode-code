package lcof;

public class AdjustAddAndEvenNumbers {
    public int[] exchange(int[] nums) {
        int from = 0, to = nums.length - 1;
        while (from < to) {
            while (from < to && (nums[from] & 0x1) == 1) from++;
            while (from < to && (nums[to] & 0x1) == 0) to--;
            if (from < to) {
                int t = nums[from];
                nums[from++] = nums[to];
                nums[to--] = t;
            }
        }
        return nums;
    }
}
