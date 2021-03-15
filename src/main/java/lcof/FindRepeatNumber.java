package lcof;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int p = 0;
        while (p == nums[p]) p++;

        int v = nums[p];

        while (v != nums[v]) {
            int t = nums[v];
            nums[v] = v;
            v = t;
        }

        return v;
    }
}
