package dp;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];
        int pri = 0, neg = 0;
        int ret = 0;
        for (int e:
             nums) {
            if (e == 0) {
                pri = 0;
                neg = 0;
            } else if (e > 0) {
                pri = Math.max(1, pri) * e;
                neg = neg * e;
            } else {
                int t = neg;
                neg = Math.min(pri * e, e);
                pri = t * e;
            }
            ret = Math.max(ret, pri);
        }
        return ret;
    }
}
