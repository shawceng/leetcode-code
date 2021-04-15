package array;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, current = 0;
        for (int each :
                nums) {
            current = Math.max(each, current + each);
            max = Math.max(current, max);
        }
        return max;
    }
}
